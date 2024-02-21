package com.example.quotesappv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotesappv2.data.DataSource
import com.example.quotesappv2.model.Quote
import com.example.quotesappv2.ui.theme.QuotesAppV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAppV2Theme {
                QuotesApp()
            }
        }
    }
}

@Composable
fun QuotesApp()
{
    QuotesList(
        quotesList = DataSource().loadQuotes()
    )
}

@Composable
fun QuotesList(quotesList:List<Quote>, modifier:Modifier = Modifier)
{
    LazyColumn {
        items(quotesList){
                quote: Quote -> QuoteCard(quote = quote,
            modifier = Modifier.padding(8.dp))

        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = quote.imageResourceId),
                contentDescription = stringResource(id = quote.stringResourceId),
                modifier = Modifier
                    .width(194.dp)
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = quote.stringResourceId),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun QuoteCardPreview(){
    QuotesApp()
}