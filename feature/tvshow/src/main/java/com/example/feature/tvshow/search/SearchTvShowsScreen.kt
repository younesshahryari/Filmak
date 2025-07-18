package com.example.feature.tvshow.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.model.TvShowModel
import com.example.core.ui.LazyLoadVerticalGridList
import com.example.core.designsystem.component.TopAppBarWithSearchBar
import com.example.feature.tvshow.R

@Composable
fun SearchTvShowsScreen(onItemClicked: (TvShowModel) -> Unit, onBackPressed: () -> Unit) {

    val viewModel: SearchTvShowsViewModel = hiltViewModel()
    val searchQuery by viewModel.currentSearchQuery.collectAsStateWithLifecycle(initialValue = "")
    val items = viewModel.items.collectAsLazyPagingItems()

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = {
            TopAppBarWithSearchBar(
                query = searchQuery,
                hintPlaceHolder = stringResource(R.string.search_tvshows),
                onQueryChange = { viewModel.searchMovie(it) },
                focusRequester = focusRequester,
                onBackPressed = onBackPressed,
                onClearClicked = {
                    viewModel.searchMovie("")
                })
        }
    ) { paddingValues ->
        LazyLoadVerticalGridList(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            list = items,
            onItemClicked = onItemClicked
        )
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }
}
