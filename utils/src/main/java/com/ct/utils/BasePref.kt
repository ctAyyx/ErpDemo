package com.ct.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

abstract class BasePref(context: Context, prefKey: String) {

    private val pref: SharedPreferences = context.getSharedPreferences(prefKey, Context.MODE_PRIVATE)
     val gson by lazy { Gson() }

    protected fun putString(key: String, value: String, commit: Boolean = false) =
        pref.edit(commit) { putString(key, value) }

    protected fun putStringSet(key: String, value: Set<String>) = pref.edit { putStringSet(key, value) }

    protected fun putInt(key: String, value: Int) = pref.edit { putInt(key, value) }

    protected fun putLong(key: String, value: Long) = pref.edit { putLong(key, value) }

    protected fun putFloat(key: String, value: Float) = pref.edit { putFloat(key, value) }

    protected fun putBoolean(key: String, value: Boolean) = pref.edit { putBoolean(key, value) }

    protected fun putJsonFromListValue(key: String, value: ArrayList<String>?) =
        pref.edit { putString(key,gson.toJson(value)) }

    protected fun getJsonToListValue(key: String, defValue: String): ArrayList<String>? {
        val json: String = pref.getString(key, defValue) ?: defValue
        return if (json == "") {
            null
        } else {
            try {
                gson.fromJson(json, object : TypeToken<ArrayList<String?>?>() {}.type)
            } catch (e: Exception) {
                null
            }
        }
    }

    protected fun getJsonToData(key: String, defValue: String = ""): HashMap<String, String?>? {
        val json = pref.getString(key, defValue) ?: defValue
        return if (json.isBlank()) null
        else {
            try {
                gson.fromJson<HashMap<String, String?>>(json, object : TypeToken<HashMap<String, String?>>() {}.type)
            } catch (e: Exception) {
                pref.edit {
                    remove(key)
                }
                null
            }
        }
    }

    protected fun putJsonData(key: String, value: HashMap<String, String?>?): Boolean {
        return try {
            pref.edit { putString(key, gson.toJson(value)) }
            true
        } catch (e: Exception) {
            false
        }
    }


    protected fun getString(key: String, defValue: String) = pref.getString(key, defValue) ?: defValue

    protected fun getStringSet(key: String, defValue: Set<String>) = pref.getStringSet(key, defValue) ?: defValue

    protected fun getInt(key: String, defValue: Int) = pref.getInt(key, defValue)

    protected fun getLong(key: String, defValue: Long) = pref.getLong(key, defValue)

    protected fun getFloat(key: String, defValue: Float) = pref.getFloat(key, defValue)

    protected fun getBoolean(key: String, defValue: Boolean) = pref.getBoolean(key, defValue)

    protected fun remove(key: String) = pref.edit { remove(key) }

    protected fun contains(key: String) = pref.contains(key)

    protected fun clear() = pref.edit { clear() }

}