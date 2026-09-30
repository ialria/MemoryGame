package com.hiba.memorygame.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MemoryCard(
    val cardIndex:Int,
    isFaceUp:Boolean=false,
    isMatched:Boolean=false
) {
   var isFaceUp by mutableStateOf(isFaceUp)
    var isMatched by mutableStateOf(isMatched)
}