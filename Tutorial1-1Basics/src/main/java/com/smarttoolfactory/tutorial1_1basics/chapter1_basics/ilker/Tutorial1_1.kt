package com.smarttoolfactory.tutorial1_1basics.chapter1_basics.ilker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * TODO:
 * Create Row that adds elements in horizontal order, and Column that adds elements in vertical order.
 */

@Composable
fun T1_1() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, Color.Black))
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Row(scrollable)", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                SampleElements()
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, Color.Black))
            ) {
                Text(
                    text = "Column",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 20.sp
                )
                SampleElements()
            }
        }
    }
}

@Composable
private fun SampleElements() {
    SampleText(text = "First Text Element")
    SampleText(text = "Second Text Element")
}

@Composable
fun SampleText(text: String) {
    Text(text = text, fontSize = 16.sp, fontFamily = FontFamily.Monospace)
}

@Preview
@Composable
private fun Preview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        T1_1()
    }
}