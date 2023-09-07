package com.ct.utils

/**
 * Singleton helper class
 *
 * Created by erkas on 2017. 12. 26..
 */
open class SingletonHolder<out T>(creator: () -> T) {
    private var creator: (() -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!()
                instance = created
                creator = null
                created
            }
        }
    }
}

/**
 * Used to allow Singleton with arguments in Kotlin while keeping the code efficient and safe.
 *
 * See https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
 */
open class SingletonHolderSingleArg<out T, in A>(creator: (A?) -> T) {
    private var creator: ((A?) -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A? = null): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}

/**
 * Used to allow Singleton with arguments in Kotlin while keeping the code efficient and safe.
 *
 * See https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
 */
open class SingletonHolderDoubleArg<out T, in A, in B>(creator: (A, B) -> T) {
    private var creator: ((A, B) -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(arg1: A, arg2: B): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg1, arg2)
                instance = created
                creator = null
                created
            }
        }
    }

    /**
     * Used to force [SingletonHolderDoubleArg.getInstance] to create a new INSTANCE next time it's called.
     * Used in tests.
     */
    fun clearInstance() {
        instance = null
    }
}