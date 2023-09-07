package com.ct.utils

val enumMap = mutableMapOf<Class<*>, Array<*>>()

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Enum<T>> getEnumValues(): Array<T> {
    val clazz = T::class.java

    if (enumMap[clazz] == null) {
        enumMap[clazz] = enumValues<T>()
    }

    return enumMap[clazz] as Array<T>
}