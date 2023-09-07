package com.ct.erp.base.adapter


abstract class BaseViewHolderData<VH_TYPE : Enum<VH_TYPE>> : ViewData() {
    abstract val viewHolderType: VH_TYPE
}

enum class ViewHolderEnum {
    TYPE_1
}

abstract class BaseViewHolderDataAdapter : BaseViewHolderData<ViewHolderEnum>() {
    override val viewHolderType: ViewHolderEnum = ViewHolderEnum.TYPE_1
}