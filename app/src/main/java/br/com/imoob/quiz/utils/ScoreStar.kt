package br.com.imoob.quiz.utils

/**
 * Created by Jose on 10/3/2017.
 */
object ScoreStar{
    fun star(score: Int, total: Int): Int{
        if(total / 1 == score){
            return 3
        }else if(total / 2 == score){
            return 2
        }else if(total / 3 == score){
            return 1
        }else{
            return 0
        }
    }
}