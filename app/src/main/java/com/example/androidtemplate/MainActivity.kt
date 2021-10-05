package com.example.androidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidtemplate.data.Puppy
import com.example.androidtemplate.data.PuppyProvider
import com.example.androidtemplate.ui.theme.AndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BarkScreen("Android")
                }
            }
        }
    }
}

@Composable
fun BarkScreen(name: String) {

    Scaffold {
        var puppies by remember { mutableStateOf(PuppyProvider.puppyList) }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(puppies) { puppy ->
               PuppyListItem(item = puppy)
            }
        }
    }

}

@Composable
fun PuppyListItem(item: Puppy) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row() {
            Image(
             painter = painterResource(id = item.puppyImageId),
             contentDescription = "",
             contentScale = ContentScale.Crop,
             modifier = Modifier.padding(8.dp).size(84.dp).clip(RoundedCornerShape(16.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = item.title, style = MaterialTheme.typography.h6)
                Text(text = "VIEW DETAIL", style = MaterialTheme.typography.caption)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidTemplateTheme {
        BarkScreen("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun PuppyPreview() {
    AndroidTemplateTheme {
        PuppyListItem(Puppy(
            id = 1,
            title = "Monty",
            sex = "Male",
            age = 14,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            puppyImageId = R.drawable.p1
        ))
    }
}