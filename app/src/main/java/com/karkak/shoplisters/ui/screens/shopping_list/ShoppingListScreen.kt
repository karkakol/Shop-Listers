package com.karkak.shoplisters.ui.screens.shopping_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.karkak.shoplisters.ui.common.CommonTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(modifier: Modifier = Modifier, navigateBack: () -> Unit = {}) {
    Scaffold(
        topBar = { CommonTopAppBar(title = "Shopping List") }
    ) { innerPadding ->
        Box(Modifier
            .padding(innerPadding)
            .background(color = Color.Red)
            .fillMaxSize()) {
            Button(onClick = navigateBack, Modifier.align(Alignment.Center)) {
                Text("Move back")
            }
        }
    }
}