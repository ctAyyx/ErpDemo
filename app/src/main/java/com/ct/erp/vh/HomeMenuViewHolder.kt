package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.base.adapter.OnItemClickHolder
import com.ct.erp.databinding.ItemHomeMenuBinding
import com.ct.erp.vo.HomeMenuViewData
import com.ct.utils.click
import com.ct.utils.image.ImageManager

class HomeMenuViewHolder(parent: ViewGroup, private var clickHolder: OnItemClickHolder<HomeMenuViewData>? = null) :
    BaseDataBindingViewHolder<ItemHomeMenuBinding, HomeMenuViewData>(parent = parent, resId = R.layout.item_home_menu) {
    override fun onBind(adapter: BaseAdapter<*>, data: HomeMenuViewData, position: Int) {
        ImageManager.getInstance().loadImageIntoImageView(data.icon, binding.imgItemHomeMenu, ImageManager.Type.NONE)
        binding.tvItemHomeEnumTitle.text = data.title
        binding.root.click {
            clickHolder?.onItemClick(data, layoutPosition)
        }
    }
}