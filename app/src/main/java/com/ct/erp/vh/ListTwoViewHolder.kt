package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemListTwoBinding
import com.ct.erp.dto.TestItemViewData
import com.ct.utils.image.ImageManager

class ListTwoViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemListTwoBinding, TestItemViewData.TestTwoViewData>(parent, R.layout.item_list_two) {
    override fun onBind(adapter: BaseAdapter<*>, data: TestItemViewData.TestTwoViewData, position: Int) {
        binding.tvTwoTitle.text = data.title
        ImageManager.getInstance()
                .loadImageIntoImageView(
                    "https://jvtest-image-dest-gz-1304474863.cos.ap-guangzhou.myqcloud.com/EO/124/3634/tn/2x/ea14abf1-ad38-4058-b3e6-32d180606fc5",
                    binding.imgTwo,
                    ImageManager.Type.WEBP
                )
    }
}