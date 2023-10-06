package com.feature.movie_detail.mappers

import com.core.network.model.YGOCardDetails
import com.feature.movie_detials.domain.SimpleYGOCardDetail

fun YGOCardDetails.simplified():SimpleYGOCardDetail {
    return SimpleYGOCardDetail(
        name = this.data[0].name,
        imageURL = this.data[0].card_images[0].image_url,
        archetype = this.data[0].archetype,
        cardType = this.data[0].type
    )
}