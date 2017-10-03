package br.com.imoob.quiz.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.imoob.quiz.R
import br.com.imoob.quiz.domain.Quiz
import br.com.imoob.quiz.domain.QuizService
import br.com.imoob.quiz.domain.TypeTheme
import br.com.imoob.quiz.extencions.click
import br.com.imoob.quiz.utils.Prefs
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.activity_level.*
import org.jetbrains.anko.*

class LevelActivity : AppCompatActivity() {

    var typeTheme: TypeTheme? = null
    lateinit var mQuestions: List<Quiz>
    val INDEX: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        containerTec.setOnClickListener {
            typeTheme = TypeTheme.technology
            doAsync {
                val questions = QuizService.getQuestions(baseContext, typeTheme as TypeTheme)

                uiThread {
                    Log.d("TAG", questions.toString())
                    mQuestions = questions
                }
            }
            txtSelected.text = (typeTheme as TypeTheme).name
        }

        containerSport.setOnClickListener {
            typeTheme = TypeTheme.sports
            doAsync {
                val questions = QuizService.getQuestions(baseContext, typeTheme as TypeTheme)
                uiThread {
                    Log.d("TAG", questions.toString())
                    mQuestions = questions
                }
            }
            txtSelected.text = (typeTheme as TypeTheme).name
        }

        imageButtonBack.setOnClickListener {
            imageButtonBack.click()
            finish()
        }

        imageButtonPlay.setOnClickListener {
            imageButtonPlay.click()
            if (typeTheme != null) {
                typeTheme
                when (typeTheme) {
                    TypeTheme.technology -> {
                        startActivity<QuestionActivity>("quiz" to mQuestions, "index" to INDEX, "score" to 0, "typeTheme" to TypeTheme.technology)
                    }
                    TypeTheme.sports -> {
                        startActivity<QuestionActivity>("quiz" to mQuestions, "index" to INDEX, "score" to 0, "typeTheme" to TypeTheme.sports)
                    }
                }
            } else {
                ViewAnimator
                        .animate(containerTec)
                        .scale(1f, 0.5f, 1f)
                        .accelerate()
                        .duration(1000)
                        .start()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        ViewAnimator.animate(containerTec)
                .scale(0f, 1f)
                .accelerate()
                .start()

        ViewAnimator.animate(containerSport)
                .scale(0f, 1f)
                .accelerate()
                .start()

        val starOne = Prefs.getInt(TypeTheme.technology.name)
        val starTwo = Prefs.getInt(TypeTheme.sports.name)

        starThemeOne.rating = starOne.toFloat()
        starThemeTwo.rating = starTwo.toFloat()

    }
}
