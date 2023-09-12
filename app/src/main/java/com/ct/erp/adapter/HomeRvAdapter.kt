package com.ct.erp.adapter

import android.view.ViewGroup
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseViewHolder
import com.ct.erp.base.adapter.OnItemClickHolder
import com.ct.erp.vh.HomeMenuViewHolder
import com.ct.erp.vh.HomeTitleViewHolder
import com.ct.erp.vo.HomeMenuViewData
import com.ct.erp.vo.HomeViewData
import com.ct.erp.vo.HomeViewHolderType

/**
 * 主界面 菜单Adapter
 */
class HomeRvAdapter(private var onMenuHolder: OnItemClickHolder<HomeMenuViewData>? = null) :
    BaseAdapter<HomeViewData>() {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (getViewHolderType<HomeViewHolderType>(viewType)) {
            HomeViewHolderType.TYPE_TITLE -> HomeTitleViewHolder(parent = parent)
            HomeViewHolderType.TYPE_MENU -> HomeMenuViewHolder(parent = parent, clickHolder = onMenuHolder)
        }
    }
}