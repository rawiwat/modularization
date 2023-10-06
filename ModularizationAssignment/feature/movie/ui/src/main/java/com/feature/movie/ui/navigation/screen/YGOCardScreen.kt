package com.feature.movie.ui.navigation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.feature.movie.domain.model.YGOCardImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YGOCardScreen(viewModel: YGOCardSearchViewModel) {
    val result = viewModel.ygoCardList.value
    val query = viewModel.query.collectAsState()
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val cardWidth = screenWidth - 5
    val cardHeight = cardWidth * 3.25 / 2.25
    Scaffold(
        topBar = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = query.value,
                onValueChange = { searchKey->
                    viewModel.setQuery(searchKey)
                },
                colors = TextFieldDefaults.textFieldColors(),
                placeholder = {
                    Text(text = "Search Card")
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        if(result.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }

        if(result.errorMessage.isNotBlank()) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = result.errorMessage)
            }
        }

        result.data?.let { ygoCardList ->
            if (ygoCardList.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Not Found")
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                ) {
                    items(
                        ygoCardList,
                        key = { it.imageUrl }
                    ) {
                        Box(
                            modifier = Modifier
                        ) {
                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
    }
}