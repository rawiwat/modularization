package com.example.movie_details.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.core.common.navigation_constant.YGOCardDetailFeature

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YGOCardDetailScreen(
    id:String,
    viewModel: YGOCardDetailViewModel
) {
    val result = viewModel.ygoCardDetail.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Card Details")
                }
            )
        }
    ) {
        bodyPadding->
        if(result.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bodyPadding)
            )
        } else if(result.error.isNotBlank()) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = result.error)
            }
        }

        result.data.let {cardDetail->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bodyPadding)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = cardDetail?.imageURL,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = cardDetail?.name.toString(),
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Card Type : ${cardDetail?.cardType.toString()}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Archetype Origin :${cardDetail?.archetype.toString()}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}