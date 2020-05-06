package com.sch.wanandroid.util

import android.content.Context
import com.sch.wanandroid.PlayAndroidApplication

/**
 * SharePreference封装
 *
 * @author zs
 */
object PrefUtils {

    private const val PREF_NAME = "config"

    fun getBoolean(
        key: String,
        defaultValue: Boolean
    ): Boolean {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.getBoolean(key, defaultValue)
    }

    fun setBoolean(ctx: Context, key: String, value: Boolean) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putBoolean(key, value).apply()
    }

    fun getString(ctx: Context, key: String, defaultValue: String): String? {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.getString(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String): String? {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.getString(key, defaultValue)
    }

    fun setString(ctx: Context, key: String, value: String) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putString(key, value).apply()
    }

    fun setInt(ctx: Context, key: String, value: Int) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putInt(key, value).apply()
    }

    fun getInt(ctx: Context, key: String, defaultValue: Int): Int {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.getInt(key, defaultValue)
    }

    fun setLong(ctx: Context, key: String, value: Long) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putLong(key, value).apply()
    }

    fun getLong(ctx: Context, key: String, defaultValue: Long): Long {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.getLong(key, defaultValue)
    }

    fun setBoolean(key: String, value: Boolean) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putBoolean(key, value).apply()
    }

    fun getString(key: String): String? {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        var result: String? = null
        result = try {
            sp.getString(key, "")
        } catch (e: ClassCastException) {
            sp.getInt(key, -1).toString()
        }

        return result
    }

    fun setString(key: String, value: String) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putString(key, value).apply()
    }

    fun setInt(key: String, value: Int) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int): Int {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.getInt(key, defaultValue)
    }

    fun setLong(key: String, value: Long) {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        sp.edit().putLong(key, value).apply()
    }

    fun getLong(key: String, defaultValue: Long): Long {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getLong(key, defaultValue)
    }

    fun setHashSet(key: String,value:HashSet<String>){
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sp.edit().putStringSet(key, value).apply()
    }

    fun getHashSet(key: String): MutableSet<String>? {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getStringSet(key, null)
    }

    fun removeKey(key: String): Boolean {
        val sp = PlayAndroidApplication.getContext().getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
        return sp.edit().remove(key).commit()
    }

}
