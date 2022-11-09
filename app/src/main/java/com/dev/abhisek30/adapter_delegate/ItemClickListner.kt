package com.dev.abhisek30.adapter_delegate

sealed class ItemClickListner {
    data class showToastMessage(val data: String, val adapterPosition: Int) : ItemClickListner()

    data class showLongToastMessage(val data: String, val bindingAdapterPosition: Int) : ItemClickListner()
}