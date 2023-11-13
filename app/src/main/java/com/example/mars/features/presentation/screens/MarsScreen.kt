package com.example.mars.features.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mars.features.presentation.contract.MarsUiState
import com.example.mars.features.presentation.uiModels.MarsUiModel

@Composable
fun MarsScreen(modifier: Modifier = Modifier, state: State<MarsUiState>) {
    LazyColumn {
        val list = state.value.list
        items(items = list) { item ->
            SingleItem(item)
        }
    }
}

@Composable
fun SingleItem(item: MarsUiModel) {
    val id = item.id
    val imgUrl = item.imgUrl
    ElevatedCard(modifier = Modifier.padding(8.dp)) {
        Row(Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = imgUrl,
                contentDescription = null,
                modifier = Modifier.width(200.dp).height(150.dp)
            )
            Text(text = id.toString(), modifier = Modifier)
        }
    }
}