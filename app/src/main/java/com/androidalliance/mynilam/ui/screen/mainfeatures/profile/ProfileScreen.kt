package com.androidalliance.mynilam.ui.screen.mainfeatures.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.androidalliance.mynilam.R
import com.androidalliance.mynilam.navigation.ProfilePage
import com.androidalliance.mynilam.ui.screen.auths.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: UserViewModel
) {
    // User State
    val userState = viewModel.sharedUserState.collectAsStateWithLifecycle()
    val username by remember {
        derivedStateOf {
            userState.value?.username ?: ""
        }
    }
    val userId by remember {
        derivedStateOf {
            userState.value?.uid ?: ""
        }
    }

    CenterAlignedTopAppBar(
        title = { Image(painter = painterResource(R.drawable.mobile_phone_nilam_nobg),
            contentDescription = "NILAM",
            modifier = Modifier
                .size(90.dp)
        ) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer,),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 130.dp, 16.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box (modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(20.dp)
            )
            .fillMaxWidth()
            .height(500.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile_bg),
                contentDescription = "Profile Background Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .aspectRatio(16f / 9f)
            )
            Image(
                painter = painterResource(R.drawable.defaultpfp),
                contentDescription = "NULL",
                modifier = Modifier
                    .size(140.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp, bottom = 100.dp)
                    .shadow(shape = CircleShape, elevation = 10.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            //can add anything about user profile here
            Text(
                text = "$username",
                modifier = Modifier
                    .padding(start = 16.dp, top = 75.dp)
                    .align(Alignment.CenterStart),
                fontWeight = FontWeight.Black,
                fontSize = 40f.sp,
            )
            Button(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 10.dp, end = 16.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Edit Profile")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Log Out")
        }
    }
}