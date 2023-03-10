package com.compose.uiyoutube.ui.screens.search.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.compose.uiyoutube.ColorsBox
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.SearchUiState
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.SongCategoryState
import com.compose.uiyoutube.ui.screens.search.viewmodel.state.TrendingFeatureState
import com.compose.uiyoutube.ui.theme.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(SearchUiState())
    val state = _state.asStateFlow()

    init {
        getTrendingFeature()
    }

    private fun getTrendingFeature() {
        _state.update {
            it.copy(
                trendingFeature = listOf(
                    TrendingFeatureState(
                        "The Dark Side",
                        "muse - Simulation Theory",

                        "https://www.premadepixels.com/wp-content/uploads/2021/12/Paradise-Album-Cover-PP1.jpg",

                        ColorsBox(
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3,
                        )
                    ), TrendingFeatureState(
                        "Unstoppable",
                        "sia",

                        "https://images.squarespace-cdn.com/content/56454c01e4b0177ad4141742/1458827329966-I6OAVNU68IOF0A4IHQVY/Im-Gonna-Be-500-Miles-Cover.jpg?content-type=image%2Fjpeg",

                        ColorsBox(
                            LightGreen1,
                            LightGreen2,
                            LightGreen3,
                        )
                    ), TrendingFeatureState(
                        "The Dark Side",
                        "muse - Simulation Theory",

                        "https://d1csarkz8obe9u.cloudfront.net/themedlandingpages/tlp_hero_album-covers-d12ef0296af80b58363dc0deef077ecc-1552649680.jpg",

                        ColorsBox(
                            OrangeYellow1,
                            OrangeYellow2,
                            OrangeYellow3,
                        )
                    ), TrendingFeatureState(
                        "The Dark Side",
                        "muse - Simulation Theory",

                        "https://d2n9ha3hrkss16.cloudfront.net/uploads/stage/stage_image/21198/optimized_large_thumb_stage.jpg",
                        ColorsBox(
                            Beige1,
                            Beige2,
                            Beige3,
                        )
                    ), TrendingFeatureState(
                        "The Dark Side",
                        "muse - Simulation Theory",

                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDTJ4AuwUIeQ-wc-z78atPgem_s9RgBtGP_A&usqp=CAU",
                        ColorsBox(
                            Red1,
                            Red2,
                            Red3,
                        )
                    )
                ),
                genres = listOf(
                    SongCategoryState(
                        "Arabic music", background =  null
                    ),

                    SongCategoryState(
                        "Rap" , background = "https://indiater.com/wp-content/uploads/2021/06/Free-Music-Album-Cover-Art-Banner-Photoshop-Template-1024x1024.jpg"
                    ),
                    SongCategoryState(
                        "R&B", background =   "https://mavenprodcontenthobv2.blob.core.windows.net/media/houseofblues_hou/Event%20Detail%20Images/RB_Only__1024x683.jpg"
                    ),
                    SongCategoryState(
                        "Pop",background = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
                    ),
                    SongCategoryState(
                        "Grime", background = "https://d1csarkz8obe9u.cloudfront.net/themedlandingpages/tlp_hero_album-cover-art-73ab5b3d9b81f442cb2288630ab63acf-1602178816.jpg"
                    ),
                    SongCategoryState(
                        "Movies & Series", background = "https://www.bmi.com/cache/images/news/2015/jason_blume_may_MW_770_436_70_s.jpg"
                    ),
                ),
                songCategory = listOf(
                    SongCategoryState(
                        "New releases", background =  null
                    ),

                    SongCategoryState(
                        "Charts", background = null
                    ),
                    SongCategoryState(
                        "Chill",background = null
                    ),
                    SongCategoryState(
                        "Work out",background = null
                    ),
                    SongCategoryState(
                        "Party",background = null
                    ),
                    SongCategoryState(
                        "Women's Impact", background = null
                    ),
                ),
                podcastByCategory = listOf(
                    SongCategoryState(
                        "Podcast charts",background = null
                    ),

                    SongCategoryState(
                        "New podcasts", background = null
                    ),
                    SongCategoryState(
                        "Mental health",background = null
                    ),
                    SongCategoryState(
                        "News & Politics", background = null
                    ),
                    SongCategoryState(
                        "True crime",background = null
                    ),
                    SongCategoryState(
                        "Sports coaching", background = null
                    ),
                ),
            )
        }
    }




}