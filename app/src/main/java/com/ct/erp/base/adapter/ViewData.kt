package com.ct.erp.base.adapter

abstract class ViewData {
    abstract fun getDataSourceKey(): String

    override fun equals(other: Any?): Boolean {
        throw RuntimeException("You must override equals()")
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    open fun getPayloadHash(): Int = 0

    open fun getChangePayload(other: ViewData): Any? {
        return if (getPayloadHash() != other.getPayloadHash()) {
            other
        } else {
            null
        }
    }

}