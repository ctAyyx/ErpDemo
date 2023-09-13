package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemHomeTitleBinding
import com.ct.erp.vo.HomeTitleViewData

class HomeTitleViewHolder(parent: ViewGroup) : BaseDataBindingViewHolder<ItemHomeTitleBinding, HomeTitleViewData>(
    parent = parent, resId = R.layout.item_home_title
) {
    override fun onBind(adapter: BaseAdapter<*>, data: HomeTitleViewData, position: Int) {
        binding.tvItemHomeTitle.text = data.title ?: ""
    }


}