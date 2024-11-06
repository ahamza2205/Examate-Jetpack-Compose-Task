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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.connect.ui.StudyPartnerCard
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.Typography
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.examatejetpackcomposetask.BottomNavigation.BottomNavItem
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartner
import com.example.examatejetpackcomposetask.tutorial.TutorialDialog

@Composable
fun ConnectScreen(
    navController: NavController,
    viewModel: ConnectViewModel = hiltViewModel()
) {
    val studyPartners = viewModel.studyPartners.collectAsState().value
    var showConnectTutorial by remember { mutableStateOf(true) }

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        if (showConnectTutorial) {
            ConnectTutorialDialog(
                onDismiss = { showConnectTutorial = false },
                onNextStep = {
                    showConnectTutorial = false
                    navigateToQuestions(navController)
                }
            )
        }
        MainContent(studyPartners)
    }
}

private fun navigateToQuestions(navController: NavController) {
    navController.navigate(BottomNavItem.Questions.route) {
        popUpTo(BottomNavItem.Connect.route) { inclusive = true }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
fun MainContent(studyPartners: List<StudyPartner>) {
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

@Composable
fun Header() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TitleText()
        SuggestedPartnersHeader()
    }
}

@Composable
fun TitleText() {
    Text(
        text = "Connect",
        style = Typography.titleLarge.copy(fontSize = 32.sp, color = PrimaryColor),
        modifier = Modifier.padding(bottom = 24.dp)
    )
}

@Composable
fun SuggestedPartnersHeader() {
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
        FilterIcon()
    }
}

@Composable
fun FilterIcon() {
    Image(
        painter = painterResource(id = R.drawable.filter),
        contentDescription = "Suggestions icon",
        colorFilter = ColorFilter.tint(PrimaryColor),
        modifier = Modifier.size(24.dp)
    )
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

@Composable
fun ConnectTutorialDialog(onDismiss: () -> Unit, onNextStep: () -> Unit) {
    TutorialDialog(
        text = "Vous trouverez ici des partenaires\n" + "d'étude et des personnes avec qui vous\n" + "connecter",
        alignment = Alignment.BottomStart,
        onDismiss = onDismiss,
        onNextStep = onNextStep,
        offsetX = 75.dp,
        offsetY = -75.dp
    )
}
