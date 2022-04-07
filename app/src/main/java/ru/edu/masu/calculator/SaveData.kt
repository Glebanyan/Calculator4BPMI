package ru.edu.masu.calculator

import android.content.SharedPreferences
import android.content.Context

class SaveData (context:Context) {
    private var sharedPreferences: SharedPreferences = context.getSharedPreferences("file", Context.MODE_PRIVATE)

    fun setDarkModeState(state: String?) {
        val editor = sharedPreferences.edit()
        editor.putString("Dark", state!!)
        editor.apply()
    }
    fun loadDarkModeState():String? {
        val state = sharedPreferences.getString("Dark", "1")
        return (state)
    }




    fun setLang(state: String?) {
        val editor = sharedPreferences.edit()
        editor.putString("Lang", state!!)
        editor.apply()
    }
    fun loadLang():String? {
        val state = sharedPreferences.getString("Lang", "en")
        return (state)
    }
}
