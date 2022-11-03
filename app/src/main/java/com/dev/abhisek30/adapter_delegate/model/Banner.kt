package com.dev.abhisek30.adapter_delegate.model

import com.dev.abhisek30.adapter_delegate.model.DisplayableItem

data class Banner(
    val title: String,
    val subTitle: String,
    val description: String,
    val image: String
) : DisplayableItem