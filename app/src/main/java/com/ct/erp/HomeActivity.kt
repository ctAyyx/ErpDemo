package com.ct.erp

import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.ct.erp.adapter.HomeRvAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.base.adapter.IsFullViewHolder
import com.ct.erp.base.adapter.OnItemClickHolder
import com.ct.erp.databinding.ActivityHomeBinding
import com.ct.erp.vm.HomeViewModel
import com.ct.erp.vm.LoginViewModel
import com.ct.erp.vo.HomeMenuViewData
import com.ct.utils.LiveDataBus
import com.ct.utils.LogUtils
import com.king.camera.scan.CameraScan
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    @Inject
    lateinit var commonPref: CommonPref
    private var loginViewModel: LoginViewModel? = null
    override fun getLayoutId(): Int = R.layout.activity_home

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val result = it.data?.getStringExtra(CameraScan.SCAN_RESULT)
        LogUtils.e("二维码数据:$result")
    }

    private var mAdapter: HomeRvAdapter? = null

    private var menuClickHolder: OnItemClickHolder<HomeMenuViewData>? = object : OnItemClickHolder<HomeMenuViewData> {
        override fun onItemClick(data: HomeMenuViewData, position: Int) {

        }
    }

    override fun initView(binding: ActivityHomeBinding) {
        super.initView(binding)
        if (loginViewModel == null) {
            loginViewModel = obtainViewModel(LoginViewModel::class.java)
        }
        if (LoginManager.getInstance().isLogin()) {
            loginViewModel?.getUserInfo()
        }



        binding.rvHome.apply {
            mAdapter = HomeRvAdapter(onMenuHolder = menuClickHolder)

            adapter = mAdapter
            layoutManager = buildLayoutManager()
//            addItemDecoration()
        }

    }

    private fun buildLayoutManager(): GridLayoutManager {
        val layoutManager = GridLayoutManager(this@HomeActivity, Constants.GRID_SPAN_COUNT)
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val viewHolder = binding.rvHome.findViewHolderForAdapterPosition(position)
                return if (viewHolder is IsFullViewHolder && viewHolder.isFullViewHolder()) Constants.GRID_SPAN_COUNT
                else 1
            }
        }

        return layoutManager
    }

    override fun bindEvent(binding: ActivityHomeBinding) {
        super.bindEvent(binding)
        loginViewModel?.loginStatus?.observe(this) {


        }

        LiveDataBus.get().with(Constants.BUS_USER_LOGIN, String::class.java).observe(this) {
            //登录成功

            //退出登录
            loginViewModel?.getUserInfo()
        }

        viewModel.homeMenu.observe(this) {
            mAdapter?.submitList(it)
        }
        viewModel.getHomeMenu()
    }


    override fun onDestroy() {
        super.onDestroy()
        menuClickHolder = null
    }


}