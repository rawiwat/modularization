package com.feature.movie.data.mapper

import com.core.network.model.YGOCards
import com.feature.movie.domain.model.YGOCardImage

fun YGOCards.toYGOCardImage():List<YGOCardImage> {
    return this.data.map{
        YGOCardImage(
            imageUrl = it.card_images[0].image_url
        )
    }
}