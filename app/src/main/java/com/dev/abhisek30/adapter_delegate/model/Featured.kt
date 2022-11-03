package com.dev.abhisek30.adapter_delegate.model

data class Featured(
    val title: String,
    val subTitle: String,
    val apps: List<App>
): DisplayableItem
