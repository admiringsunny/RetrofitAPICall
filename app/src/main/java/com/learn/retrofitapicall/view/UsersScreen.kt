package com.learn.retrofitapicall.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.learn.retrofitapicall.viewmodel.UserUiState
import com.learn.retrofitapicall.viewmodel.UserViewModel

//@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun UsersScreen(
    userViewModel: UserViewModel = viewModel(),
    name: String = "Android",
    modifier: Modifier = Modifier
) {
    val uiState by userViewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier.padding(20.dp),
        topBar = {
            Text(
                text = "Users Directory",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    ) { innerPadding ->
        when (val state = uiState) {
            is UserUiState.Loading -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Loading users")
                }

            }

            is UserUiState.Success -> {
                UsersList(
                    users = state.users,
                    modifier = Modifier.padding(innerPadding)
                )
            }

            is UserUiState.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Failed to load Users",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = state.message,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Red
                    )
                }
            }
        }
    }
}