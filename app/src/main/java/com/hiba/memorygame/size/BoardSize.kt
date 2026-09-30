package com.hiba.memorygame.size

enum class BoardSize(
    val numCards:Int,
    val numOfColumns:Int,
    var isFaceUp: Boolean=false,
    var isMatched: Boolean=false
) {
    Easy(8,2),
    Medium(18,3),
    Hard(24,4), ;

    fun getNumOfPairs():Int{
        return numCards/2
    }

    fun getNumOfRows():Int{
        return numCards/numOfColumns
    }

}