package com.example.arts.presentation.artslist

import androidx.paging.PagingData
import com.example.artsdomain.model.ArtListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@JvmInline
value class ArtsListState(
    val arts: Flow<PagingData<ArtListItem>> = flow { emit(PagingData.empty()) },
)