package com.smarttoolfactory.tutorial1_1basics

import android.content.Context
import android.widget.Toast

fun makeToast(context: Context, text: String) {
    Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
}