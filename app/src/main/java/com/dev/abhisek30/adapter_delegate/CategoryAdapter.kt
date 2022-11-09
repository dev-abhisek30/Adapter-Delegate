package com.dev.abhisek30.adapter_delegate

import com.dev.abhisek30.adapter_delegate.model.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CategoryAdapter(listener: (ItemClickListner) -> Unit) : ListDelegationAdapter<List<DisplayableItem>>(
    categoryAdapterDelegate(listener)
)