package com.smarttoolfactory.tutorial1_1basics.chapter1_basics.ilker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.tutorial1_1basics.chapter3_layout.CustomColumnScope.Companion.horizontalAlign
import com.smarttoolfactory.tutorial1_1basics.chapter3_layout.HorizontalAlignment
import com.smarttoolfactory.tutorial1_1basics.makeToast

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
        verticalArrangement = Arrangement.spacedBy(16.dp).also { Arrangement.Center }
    ) {
        item {
            Header(text = "Tutorial1.1", color = Color.Blue)
            Divider()
        }
        item {
            CustomCard {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Header(text = "Row(scrollable)")
                    SampleElements()
                }
            }

        }
        item {
            CustomCard {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Header(text = "Column")
                    SampleElements()
                }
            }
        }
    }
}

@Composable
private fun SampleElements() {
    SampleText(text = "1st Text Element")
    SampleText(text = "2nd Text Element")
    SampleText(text = "3rd Text Element")
    SampleText(text = "4th Text Element")
    SampleText(text = "5th Text Element")
    SampleText(text = "6th Text Element")
    SampleText(text = "...")
}

@Composable
fun SampleText(text: String) {
    Text(text = text, fontSize = 12.sp, fontFamily = FontFamily.Monospace)
}

@Composable
fun Header(text: String, color: Color = Color.Unspecified) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = color
    )
}

@Composable
fun CustomCard(content: @Composable () -> Unit) {
    val context = LocalContext.current
    Card(
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .horizontalAlign(HorizontalAlignment.Start)
            .clickable {
                makeToast(
                    context = context,
                    "You clicked to the card"
                )
            }
    ) {
        content()
    }
}

@Preview
@Composable
private fun Preview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        T1_1()
    }
}