package com.ct.erp.vo

import com.flyco.tablayout.listener.CustomTabEntity

data class TabViewData(val title: String) : CustomTabEntity {
    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return 0
    }

    override fun getTabUnselectedIcon(): Int {
        return 0
    }
}