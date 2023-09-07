package com.ct.erp.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.ct.erp.R
import com.ct.erp.adapter.ListRvAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityListBinding
import com.ct.erp.vm.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : BaseActivity<ListViewModel, ActivityListBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_list

    private var mAdapter: ListRvAdapter? = null

    override fun initView(binding: ActivityListBinding) {
        super.initView(binding)

        binding.rvList.apply {
            mAdapter = ListRvAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.getMulTypeList()
    }

    override fun initListener(binding: ActivityListBinding) {
        super.initListener(binding)
    }

    override fun bindEvent(binding: ActivityListBinding) {
        super.bindEvent(binding)
        viewModel.mulResult.observe(this) {
            mAdapter?.submitList(it)
        }
    }
}