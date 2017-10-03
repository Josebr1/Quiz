package br.com.imoob.quiz

import android.app.Application
import android.media.MediaPlayer
import android.util.Log

/**
 * Created by Jose on 10/2/2017.
 */
class QuizApplication : Application() {
    private val TAG = "QuizApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this

    }


    companion object {
        private var appInstance: QuizApplication? = null

        fun getInstance(): QuizApplication {
            if (appInstance == null) {
                throw IllegalStateException("")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "QuizApplication.onTerminate")
    }
}