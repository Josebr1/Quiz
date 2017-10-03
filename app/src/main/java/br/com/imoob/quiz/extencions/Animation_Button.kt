package br.com.imoob.quiz.extencions

import android.widget.ImageButton
import com.github.florent37.viewanimator.ViewAnimator

/**
 * Created by Jose on 10/2/2017.
 */

fun ImageButton.click(){
    ViewAnimator
            .animate(this)
            .scale(0f, 1f)
            .start()
}