package com.ct.erp.adapter

import android.view.ViewGroup
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseViewHolder
import com.ct.erp.dto.TestEnum
import com.ct.erp.dto.TestItemViewData
import com.ct.erp.vh.ListOneViewHolder
import com.ct.erp.vh.ListTwoViewHolder

class ListRvAdapter : BaseAdapter<TestItemViewData>() {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (getViewHolderType<TestEnum>(viewType)) {
            TestEnum.TYPE_ONE -> ListOneViewHolder(parent)
            TestEnum.TYPE_TWO -> ListTwoViewHolder(parent)
        }
    }
}