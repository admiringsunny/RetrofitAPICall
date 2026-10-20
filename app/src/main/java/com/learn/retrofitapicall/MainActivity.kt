package com.learn.retrofitapicall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.learn.retrofitapicall.ui.theme.RetrofitAPICallTheme
import com.learn.retrofitapicall.view.UsersScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitAPICallTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // https://jsonplaceholder.typicode.com/users
                    UsersScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
