package com.dev.abhisek30.adapter_delegate.model

data class Promotion(
    val title: String,
    val app: App,
    val promos: List<String>
): DisplayableItem
