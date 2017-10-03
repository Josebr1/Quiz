package br.com.imoob.quiz.domain

import android.content.Context
import br.com.imoob.quiz.R
import br.com.imoob.quiz.extencions.fromJson

/**
 * Created by Jose on 10/2/2017.
 */
object QuizService{

    fun getQuestions(context: Context, theme: TypeTheme): List<Quiz>{
        val raw = getArquivoRaw(theme)
        val resources = context.resources
        val inputStream = resources.openRawResource(raw)
        inputStream.bufferedReader().use {
            val json = it.readText()
            val questions = fromJson<List<Quiz>>(json)
            return questions
        }
    }

    fun getArquivoRaw(theme: TypeTheme) = when(theme){
        TypeTheme.technology -> R.raw.technology
        else -> R.raw.sports
    }

}