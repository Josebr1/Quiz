package br.com.imoob.quiz.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import br.com.imoob.quiz.R
import br.com.imoob.quiz.domain.Quiz
import br.com.imoob.quiz.domain.TypeTheme
import kotlinx.android.synthetic.main.activity_question.*
import org.jetbrains.anko.startActivity

class QuestionActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Quiz>
    var INDEX:Int = 0
    lateinit var quiz: Quiz
    var SCORE:Int = 0
    lateinit var typeTheme:TypeTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questions = intent.getSerializableExtra("quiz") as ArrayList<Quiz>
        INDEX = intent.getIntExtra("index", 0)
        quiz = questions[INDEX]
        SCORE = intent.getIntExtra("score", 0)
        typeTheme = intent.getSerializableExtra("typeTheme") as TypeTheme

        questionA.setOnClickListener { 
            startActivity<ResultActivity>()
        }
    }

    override fun onResume() {
        super.onResume()
        txtQuestion.text = quiz.question
        txtQuestionA.text = quiz.answers[0].answer
        txtQuestionB.text = quiz.answers[1].answer
        txtQuestionC.text = quiz.answers[2].answer
        txtQuestionD.text = quiz.answers[3].answer

        textWay.text = "$INDEX de ${questions.size} questões."
    }

    fun question(view: View){
        val t = view as TextView

        if(t.text.toString() == quiz.correctAnswer){
            //toast("ok")
            SCORE++
        }
        if(INDEX < questions.size -1){
            INDEX++
            startActivity<QuestionActivity>("quiz" to questions, "index" to INDEX, "score" to SCORE, "typeTheme" to typeTheme)
        }else{
            startActivity<ResultActivity>("quiz" to questions, "index" to INDEX, "score" to SCORE, "typeTheme" to typeTheme)
        }
        finish()
    }
}
