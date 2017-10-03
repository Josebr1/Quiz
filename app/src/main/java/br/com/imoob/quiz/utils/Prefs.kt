package br.com.imoob.quiz.utils

import android.content.SharedPreferences
import br.com.imoob.quiz.QuizApplication

/**
 * Created by Jose on 10/2/2017.
 */

object Prefs{
    val PREF_ID = "quiz"

    private fun prefs(): SharedPreferences{
        val context = QuizApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }
    fun setInt(flag: String, valor: Int) = prefs().edit().putInt(flag, valor).apply()
    fun getInt(flag: String) = prefs().getInt(flag, 0)
    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()
    fun getString(flag: String) = prefs().getString(flag, "")
}