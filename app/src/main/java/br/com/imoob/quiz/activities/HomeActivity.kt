package br.com.imoob.quiz.activities

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import br.com.imoob.quiz.R
import br.com.imoob.quiz.extencions.click
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.sdk25.coroutines.onTouch
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageButtonPlay.setOnClickListener {
            startActivity<LevelActivity>()
        }

        imageButtonPlay.onTouch { v, event -> imageButtonPlay.click()  }
    }

    override fun onResume() {
        super.onResume()

        ViewAnimator
                .animate(imageButtonPlay)
                .repeatCount(Animation.INFINITE)
                .rotation(360f)
                .start()
        ViewAnimator
                .animate(imageTitle)
                .translationY(-1000f, 0f)
                .alpha(0f, 1f)
                .start()



    }
}
