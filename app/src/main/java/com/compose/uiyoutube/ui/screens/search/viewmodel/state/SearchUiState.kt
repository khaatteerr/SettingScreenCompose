package com.compose.uiyoutube.ui.screens.search.viewmodel.state

data class SearchUiState(
    val trendingFeature: List<TrendingFeatureState>? = null,
    val songCategory: List<SongCategoryState>? = null,
    val genres: List<SongCategoryState>? = null,
    val podcastByCategory: List<SongCategoryState>? = null,
    val featureName : List<String> = listOf("Genres","Category","Podcasts by category")
)