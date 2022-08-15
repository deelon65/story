package com.example.story.data

import android.graphics.Color
import com.example.story123.R

data class Hobbie(
    val name: String,
    var isSelect: Boolean = false,
    var lineColor: Int = R.drawable.ic_hobbie_delete,
    var textColor : Int = Color.WHITE
)
