package br.com.imoob.quiz.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.imoob.quiz.R
import br.com.imoob.quiz.domain.Quiz
import br.com.imoob.quiz.domain.TypeTheme
import br.com.imoob.quiz.utils.Prefs
import br.com.imoob.quiz.utils.ScoreStar
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.startActivity

class ResultActivity : AppCompatActivity() {

    lateinit var questions: List<Quiz>
    var INDEX:Int = 0
    lateinit var quiz: Quiz
    var SCORE:Int = 0
    lateinit var typeTheme:TypeTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        questions = intent.getSerializableExtra("quiz") as List<Quiz>
        INDEX = intent.getIntExtra("index", 0)
        quiz = questions[INDEX]
        SCORE = intent.getIntExtra("score", 0)
        typeTheme = intent.getSerializableExtra("typeTheme") as TypeTheme

        imageButtonHome.setOnClickListener {
            startActivity<LevelActivity>()
            finish()
        }

        imageButtonBack.setOnClickListener {
            startActivity<HomeActivity>()
            finish()
        }

        imageButtonRepeat.setOnClickListener {
            startActivity<QuestionActivity>("quiz" to questions, "index" to 0, "score" to 0, "typeTheme" to typeTheme)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        txtGameScore.text = "$SCORE"
        txtResult.text = "Você acertou $SCORE de ${questions.size} questões."

        Prefs.setInt(typeTheme.name, ScoreStar.star(SCORE, questions.size))
        starResult.rating = Prefs.getInt(typeTheme.name).toFloat()
    }
}
