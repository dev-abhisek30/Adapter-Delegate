package com.dev.abhisek30.adapter_delegate

import androidx.navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.abhisek30.adapter_delegate.databinding.ItemBannerBinding
import com.dev.abhisek30.adapter_delegate.databinding.ItemCampaignBinding
import com.dev.abhisek30.adapter_delegate.databinding.ItemCategoryBinding
import com.dev.abhisek30.adapter_delegate.databinding.ItemFeaturedBinding
import com.dev.abhisek30.adapter_delegate.databinding.ItemPromotionBinding
import com.dev.abhisek30.adapter_delegate.model.*
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun bannerAdapterDelegate() =
    adapterDelegateViewBinding<Banner, DisplayableItem, ItemBannerBinding>(
        { layoutInflater, root -> ItemBannerBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.tvTitle.text = item.title
            binding.tvSubTitle.text = item.subTitle
            binding.tvDescription.text = item.description
        }
    }

fun campaignAdapterDelegate() =
    adapterDelegateViewBinding<Campaign, DisplayableItem, ItemCampaignBinding>(
        { layoutInflater, root -> ItemCampaignBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            val bannerAdapter = BannerAdapter()
            binding.recyclerBanner.apply {
                adapter = bannerAdapter
                itemAnimator = DefaultItemAnimator()
                layoutManager =
                    LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            }
            bannerAdapter.setItems(item.banners)
        }
    }

fun featuredAdapterDelegate() =
    adapterDelegateViewBinding<Featured, DisplayableItem, ItemFeaturedBinding>(
        { layoutInflater, root -> ItemFeaturedBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            val appAdapter = AppAdapter()
            binding.recyclerApp.apply {
                adapter = appAdapter
                layoutManager =
                    LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                itemAnimator = DefaultItemAnimator()
            }
            appAdapter.setItems(item.apps)
            binding.tvTitle.text = item.title
            binding.tvSubTitle.text = item.subTitle
            binding.ivNext.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_categoryFragment)
            }
        }
    }

fun promotionAdapterDelegate() =
    adapterDelegateViewBinding<Promotion, DisplayableItem, ItemPromotionBinding>(
        { layoutInflater, root -> ItemPromotionBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            val promoAdapter = PromoAdapter()
            binding.recyclerPromo.apply {
                adapter = promoAdapter
                itemAnimator = DefaultItemAnimator()
                layoutManager =
                    LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            }
            promoAdapter.setItems(item.promos)
            binding.tvTitle.text = item.title
            binding.tvAppName.text = item.app.name
            binding.tvAppDeveloper.text = item.app.developer
            binding.tvAppRating.text = item.app.size.toString()
        }
    }

fun categoryAdapterDelegate(listner : ItemClickListner) =
    adapterDelegateViewBinding<Category, DisplayableItem, ItemCategoryBinding>(
        { layoutInflater, root -> ItemCategoryBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.tvTitle.text = item.categoryName
            binding.tvTitle.setOnClickListener {
                listner.showToastMessage(item.categoryName)
            }
        }
    }