package com.ct.erp.dto

import com.ct.erp.base.adapter.BaseViewHolderData


enum class TestEnum {
    TYPE_ONE, TYPE_TWO
}

sealed class TestItemViewData(holderType: TestEnum) : BaseViewHolderData<TestEnum>() {
    override val viewHolderType: TestEnum = holderType

    data class TestOneViewData(val id: String, val name: String) : TestItemViewData(TestEnum.TYPE_ONE) {
        override fun getDataSourceKey(): String {
            return "one:$id"
        }

    }

    data class TestTwoViewData(val id: String, val title: String, val imageUrl: String) :
        TestItemViewData(TestEnum.TYPE_TWO) {
        override fun getDataSourceKey(): String {
            return "two:$id"
        }
    }
}