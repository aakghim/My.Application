package com.example.myapplication

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.AndroidTrainingTheme
import com.example.myapplication.ui.theme.Brown100
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTrainingTheme{
                Conversation(GenerateDataDummyUser())
            }
        }
    }
}

fun GenerateDataDummyUser(): ArrayList<User>{
    var users: ArrayList<User> = ArrayList()

    // buat objek user
    var user: User = User("Arfa", "Lampung Lampung Lampung Lampung Lampung Lampung Lampungg asdfadfasadfasdf  asdfadfasadfasdf ", 20)
    users.add(user)

    user = User("Fando", "Metro Metro Metro Metro Metro Metro Metro Metro Metro Metro asdfadfasadfasdf asdfadfasadfasdf  asdfadfasadfasdf ", 25)
    users.add(user)

    user = User("Ghymsa", "Merauke Merauke Merauke Merauke Merauke Merauke Merauke Merauke asdfadfasadfasdf  asdfadfasadfasdf  asdfadfasadfasdf ", 22)
    users.add(user)

    return users
}
data class User(
    val name: String,
    val address: String,
    val umur: Int
)

@Composable
fun Pesan(user: User) {
        Row(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Image(painter =
            painterResource(id = R.drawable.univ_musamus),
                contentDescription = "Univ musamus",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember {mutableStateOf(false)}

            Column() {
                Text(text = user.name, color = Brown100)
                Spacer(modifier = Modifier.height(8.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {
                    Text(
                        text = user.address,
                        modifier = Modifier.padding(all = 4.dp),

                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,

                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
}
@Preview
@Composable
fun PreviewPesan(){
    val user = User("Unmus", "Papua", 36)
    Pesan(user)
}

@Composable
fun Conversation(users: ArrayList<User>) {
    LazyColumn {
        items(users) { user ->
            Pesan(user = user)
        }
    }
}