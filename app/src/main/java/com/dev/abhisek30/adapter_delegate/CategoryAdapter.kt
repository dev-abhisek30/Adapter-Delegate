package com.dev.abhisek30.adapter_delegate

import com.dev.abhisek30.adapter_delegate.model.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CategoryAdapter(private val listner: ItemClickListner) : ListDelegationAdapter<List<DisplayableItem>>(
    categoryAdapterDelegate(listner)
)