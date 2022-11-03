package com.dev.abhisek30.adapter_delegate

import com.dev.abhisek30.adapter_delegate.model.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainAdapter : ListDelegationAdapter<List<DisplayableItem>>(
    bannerAdapterDelegate(),
    campaignAdapterDelegate(),
    featuredAdapterDelegate(),
    promotionAdapterDelegate()
)