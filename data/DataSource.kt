package com.example.quotesappv2.data

import com.example.quotesappv2.R
import com.example.quotesappv2.model.Quote

class DataSource {

    fun loadQuotes(): List<Quote>{
        return listOf<Quote>(
            Quote(R.string.quotes1, R.drawable.c1),
            Quote(R.string.quotes2, R.drawable.c2),
            Quote(R.string.quotes3, R.drawable.c3),
            Quote(R.string.quotes4, R.drawable.c4),
            Quote(R.string.quotes5, R.drawable.c5),
            Quote(R.string.quotes6, R.drawable.c6),
            Quote(R.string.quotes7, R.drawable.c7),
            Quote(R.string.quotes8, R.drawable.c8),
            Quote(R.string.quotes9, R.drawable.c9),
            Quote(R.string.quotes10, R.drawable.c10)
        )
    }

}