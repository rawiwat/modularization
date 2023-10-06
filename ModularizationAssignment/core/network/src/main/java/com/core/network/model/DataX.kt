package com.core.network.model

data class DataX(
    val archetype: String,
    val card_images: List<CardImageX>,
    val card_prices: List<CardPriceX>,
    val card_sets: List<CardSetX>,
    val desc: String,
    val frameType: String,
    val id: Int,
    val name: String,
    val race: String,
    val type: String
)