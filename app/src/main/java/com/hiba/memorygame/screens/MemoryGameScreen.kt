package com.hiba.memorygame.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hiba.memorygame.utils.DEFAULT_ICONS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoryGameScreen() {
    val primaryColor:Color=Color(0xFF768E78)
    val onPrimary:Color=Color(0xFFC6C092)
    val cardColor:Color=Color(0xFFFFFcF5)
    Scaffold(
topBar = {TopAppBar(
    title = {Text(text = "Memory Game")},
colors = TopAppBarDefaults.topAppBarColors(
    containerColor =primaryColor
)
    )
}

    ){innerPadding->


        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)

        ){
            BoxWithConstraints(
                modifier = Modifier.weight(1f).padding(18.dp)
            ) {
                val columns=4
                val rows=6
                val spacing=12.dp
                val cellWidth=(maxWidth-spacing*(columns-1))/columns
                val cellHeight=(maxHeight-spacing * (rows-1))/rows
val horizontalSpacing=spacing

                val resourceImages=DEFAULT_ICONS.shuffled()
                val randomizedImages=(resourceImages+resourceImages).shuffled()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(columns),
                    userScrollEnabled = false,
horizontalArrangement = Arrangement.spacedBy(horizontalSpacing),
                    verticalArrangement = Arrangement.spacedBy(spacing)
                ) {items(columns*rows){i->
                    Card(
                        onClick = {
                            Log.d("MemoryCard","card index clicked= $i")

                                  },
                        modifier=Modifier.fillMaxWidth().width(cellWidth).height(cellHeight).border(
                            1.dp, Color.Black.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(8.dp),
                            ),
                        colors = CardDefaults.cardColors(containerColor = cardColor)
                    ) {
                        Image(painter = painterResource(randomizedImages[i]),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier=Modifier.fillMaxSize()
                        )
                    }

                }


                }

            }
            Row(
                modifier = Modifier.fillMaxWidth().background(color = primaryColor).padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier.weight(1f).background(color = onPrimary, shape = RoundedCornerShape(size=18.dp)).padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text="Moves : 0/0")
                }
                Box(
                    modifier = Modifier.weight(1f).background(color = onPrimary, shape = RoundedCornerShape(size=18.dp)).padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text="Pairs : 4/4")
                }
            }
        }
        }}
