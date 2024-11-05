package com.example.examatejetpackcomposetask.screens.connect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.ui.theme.OnPrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor
import com.example.examatejetpackcomposetask.ui.theme.SurfaceColor


@Composable
fun StudyPartnerCard(partner: StudyPartner) {
    Surface(
        color = SurfaceColor,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Row for Profile image, Name, Targeting level
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Image with initials
                val initials = partner.name.split(" ").map { it.first() }.take(2).joinToString("")
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(PrimaryColor, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = initials,
                        color = OnPrimaryColor,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = partner.name,
                        color = PrimaryColor,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
                    )
                    Spacer(modifier = Modifier.height(4.dp)) // Space between name and targeting level
                    // Targeting Level with background
                    Text(
                        text = "Targeting: ${partner.targetLevel}",
                        color = OnPrimaryColor,
                        modifier = Modifier
                            .background(PrimaryColor, shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Last seen info
            Text(
                text = "Last seen online: ${partner.lastSeen}",
                color = SecondaryColor,
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Languages row
            Row {
                partner.languages.forEach { language ->
                    Text(
                        text = language,
                        color = OnPrimaryColor,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .background(PrimaryColor, shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Row for location, gender, age, date
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    InfoIcon(resourceId = R.drawable.location, contentDescription = "Location")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = partner.location,
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val genderIcon = if (partner.gender == "Male") R.drawable.male else R.drawable.female
                    InfoIcon(resourceId = genderIcon, contentDescription = "Gender")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = partner.gender,
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    InfoIcon(resourceId = R.drawable.cake, contentDescription = "Age")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${partner.age}",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    InfoIcon(resourceId = R.drawable.calendar, contentDescription = "Join Date")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = partner.joinDate,
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 14.sp)
                    )
                }
            }
        }
    }
}


