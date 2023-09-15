package com.ct.erp.popup

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ct.erp.R
import com.ct.erp.adapter.ColumnRvAdapter
import com.ct.erp.base.BaseDialogFragment
import com.ct.erp.common.Constants
import com.ct.erp.databinding.DialogTableColumnBinding
import com.ct.erp.vm.DispatchViewModel
import com.ct.erp.vo.TabColumnHeaderViewData
import com.ct.utils.LogUtils
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ColumnDialogFragment : BaseDialogFragment<DispatchViewModel, DialogTableColumnBinding>() {
    override fun getLayoutId(): Int = R.layout.dialog_table_column

    companion object {
        const val TAG = "ColumnDialogFragment"
        fun newInstance(): ColumnDialogFragment = ColumnDialogFragment()
    }


    override fun createViewModel(): DispatchViewModel {
        return ViewModelProvider(requireActivity()).get(DispatchViewModel::class.java)
    }


    @Inject
    lateinit var mAdapter: ColumnRvAdapter

    private val tempList = mutableListOf<TabColumnHeaderViewData>()

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        tempList.clear()
        tempList.addAll(viewModel.tableAllColumn)

        binding.rvDialogColumn.apply {
            layoutManager = GridLayoutManager(context, Constants.GRID_SPAN_COUNT)
            adapter = mAdapter
            mAdapter.submitList(tempList)
        }

        binding.checkDialogColumnAll.setOnCheckedChangeListener { _, isChecked ->
            val curList = mAdapter.currentList
            curList.forEach {
                it.isChecked = isChecked
            }
            mAdapter.notifyDataSetChanged()
        }

        binding.btnCancel.click {
            dismiss()
        }

        binding.btnSure.click {
            doSure()
        }

        LogUtils.e("Dialog:$viewModel $tempList")
    }

    private fun doSure() {
        val checkList = mutableListOf<TabColumnHeaderViewData>()
        tempList.forEach {
            if (it.isChecked) {
                checkList.add(it)
            }
        }

        if (checkList.isEmpty()) {
            showToast("最少需要选中一个标签")
            return
        }

        viewModel.setCheckedTableColumn(checkList)
        dismiss()
    }
}