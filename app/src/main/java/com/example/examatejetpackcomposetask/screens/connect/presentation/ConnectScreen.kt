package com.example.examatejetpackcomposetask.screens.connect.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.connect.ui.StudyPartnerCard
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.Typography

import androidx.compose.runtime.collectAsState
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartner

@Preview(showBackground = true)
@Composable
fun ConnectScreen(viewModel: ConnectViewModel = hiltViewModel()) {
    val studyPartners = viewModel.studyPartners.collectAsState().value

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            StudyPartnersList(studyPartners)
        }
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Connect",
            style = Typography.titleLarge.copy(fontSize = 32.sp, color = PrimaryColor),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Suggested Study Partners : ",
                color = PrimaryColor,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Suggestions icon",
                colorFilter = ColorFilter.tint(PrimaryColor),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun StudyPartnersList(studyPartners: List<StudyPartner>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(studyPartners) { partner ->
            StudyPartnerCard(partner = partner)
        }
    }
}


