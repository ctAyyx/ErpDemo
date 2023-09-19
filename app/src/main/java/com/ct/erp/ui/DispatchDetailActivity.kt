package com.ct.erp.ui

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.ct.erp.R
import com.ct.erp.adapter.DispatchDetailVpAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityDispatchDetailBinding
import com.ct.erp.vm.DispatchViewModel
import com.ct.erp.vo.DispatchDetailViewData
import com.ct.erp.vo.TabViewData
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DispatchDetailActivity : BaseActivity<DispatchViewModel, ActivityDispatchDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_dispatch_detail

    private var mAdapter: DispatchDetailVpAdapter? = null

    override fun initView(binding: ActivityDispatchDetailBinding) {
        super.initView(binding)
        mAdapter = DispatchDetailVpAdapter()
        binding.vpDispatchDetail.adapter = mAdapter
        val data = DispatchDetailViewData("1")
        mAdapter?.submitList(listOf(data, data, data, data))

        binding.tabDispatchDetail.setTabData(getTabData())
    }


    override fun initListener(binding: ActivityDispatchDetailBinding) {
        super.initListener(binding)
        binding.tabDispatchDetail.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                binding.vpDispatchDetail.apply {
                    if (currentItem != position)
                        setCurrentItem(position, false)
                }
            }

            override fun onTabReselect(position: Int) {
            }
        })

        binding.vpDispatchDetail.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabDispatchDetail.apply {
                    if (currentTab != position)
                        currentTab = position
                }
            }
        })
    }

    private fun getTabData(): ArrayList<CustomTabEntity> {
        return arrayListOf(
            TabViewData("基础"),
            TabViewData("聚合"),
            TabViewData("数量"),
            TabViewData("时间")
        )
    }
}