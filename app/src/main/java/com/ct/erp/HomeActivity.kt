package com.ct.erp

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.ct.erp.adapter.HomeRvAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.base.adapter.OnItemClickHolder
import com.ct.erp.common.CommonPref
import com.ct.erp.common.Constants
import com.ct.erp.databinding.ActivityHomeBinding
import com.ct.erp.ui.DispatchDetailListActivity
import com.ct.erp.vm.HomeViewModel
import com.ct.erp.vo.HomeMenuViewData
import com.ct.utils.ActivityUtils
import com.ct.utils.LogUtils
import com.king.camera.scan.CameraScan
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    @Inject
    lateinit var commonPref: CommonPref
    override fun getLayoutId(): Int = R.layout.activity_home


    private var mAdapter: HomeRvAdapter? = null

    private var menuClickHolder: OnItemClickHolder<HomeMenuViewData>? = object : OnItemClickHolder<HomeMenuViewData> {
        override fun onItemClick(data: HomeMenuViewData, position: Int) {
            ActivityUtils.startActivitySafe(
                this@HomeActivity,
                Intent(this@HomeActivity, DispatchDetailListActivity::class.java)
            )
        }
    }

    override fun initView(binding: ActivityHomeBinding) {
        super.initView(binding)
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
                return mAdapter?.getItemColumnSpan(position = position, spanCount = Constants.GRID_SPAN_COUNT) ?: 1
            }
        }

        return layoutManager
    }

    override fun bindEvent(binding: ActivityHomeBinding) {
        super.bindEvent(binding)
        viewModel.homeMenu.observe(this) {
            mAdapter?.submitList(it)
        }

    }

    override fun loadData() {
        super.loadData()
        viewModel.getHomeMenu()
    }

    override fun onDestroy() {
        super.onDestroy()
        menuClickHolder = null
    }


}