package com.learn.retrofitapicall.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.retrofitapicall.models.Address
import com.learn.retrofitapicall.models.Company
import com.learn.retrofitapicall.models.Geo
import com.learn.retrofitapicall.models.User

val dummyUser = User(
    id = 1,
    name = "Name",
    username = "username",
    email = "email",
    address = Address("strees", "suit", "City", "12345", Geo("1.1", "1.1")),
    phone = "9900990099",
    website = "website.in",
    company = Company("Company Name", "Company catch phrase", "Company Business"),
)

@Preview(showBackground = true)
@Composable
fun UserCard(user: User = dummyUser) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "${user.id}. ${user.name}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Username: @${user.username}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Email: ${user.email}"
            )
            Text(text = "Phone: ${user.phone}")

            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "Company:",
                    style = MaterialTheme.typography.titleSmall
                )
                Text("${user.company.name}")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "Catch Phrase: ",
                    style = MaterialTheme.typography.titleSmall
                )
                Text("${user.company.catchPhrase}")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "Business:",
                    style = MaterialTheme.typography.titleSmall
                )
                Text("${user.company.bs}")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "Website:",
                    style = MaterialTheme.typography.titleSmall
                )
                Text("${user.website}")
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Address:",
                style = MaterialTheme.typography.titleSmall
            )
            Text("${user.address.street}, ${user.address.suite}, ${user.address.city}, ${user.address.zipcode}")
            Text("Geo: ${user.address.geo.lat}, ${user.address.geo.lng} ")
        }
    }
}