package com.ct.erp.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.ct.erp.R
import com.ct.erp.adapter.DispatchDetailVpAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityDispatchDetailBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.vm.DispatchViewModel
import com.ct.erp.vo.DispatchDetailViewData
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DispatchDetailActivity : BaseActivity<DispatchViewModel, ActivityDispatchDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_dispatch_detail

    private var mAdapter: DispatchDetailVpAdapter? = null
    private var changeByScroll: Boolean = false

    override fun initView(binding: ActivityDispatchDetailBinding) {
        super.initView(binding)
        binding.btnPlantBasic.isChecked = true
        mAdapter = DispatchDetailVpAdapter()
        binding.rvDispatchPlant.adapter = mAdapter
        binding.rvDispatchPlant.layoutManager = LinearLayoutManager(this)

        viewModel.dispatchDetail.observe(this) {
            mAdapter?.submitList(it)
        }
        viewModel.loadDispatchDetail()

    }


    override fun initListener(binding: ActivityDispatchDetailBinding) {
        super.initListener(binding)
        binding.radioGroupPlant.setOnCheckedChangeListener { _, id ->
            if (changeByScroll) {
                changeByScroll = false
                return@setOnCheckedChangeListener
            }
            when (id) {
                R.id.btnPlantBasic -> location(0)
                R.id.btnPlantCollect -> location(1)
                R.id.btnPlantQuantity -> location(2)
                R.id.btnPlantDate -> location(3)
            }
        }

        binding.rvDispatchPlant.addOnScrollListener(object : OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = binding.rvDispatchPlant.layoutManager as? LinearLayoutManager ?: return
                val position = if (dy > 0) {
                    manager.findLastVisibleItemPosition()
                } else {
                    manager.findFirstVisibleItemPosition()
                }

                val radioButton = when (position) {
                    0 -> binding.btnPlantBasic
                    1 -> binding.btnPlantCollect
                    2 -> binding.btnPlantQuantity
                    3 -> binding.btnPlantDate
                    else -> null
                }
                if (radioButton != null && !radioButton.isChecked) {
                    changeByScroll = true
                    radioButton.isChecked = true
                }
            }
        })

        binding.btnDetailPush.click {
            viewModel.postDispatchPlan()
        }
    }

    private fun location(position: Int) {
        binding.rvDispatchPlant.smoothScrollToPosition(position)
    }

}