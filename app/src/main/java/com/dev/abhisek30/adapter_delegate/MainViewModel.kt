package com.dev.abhisek30.adapter_delegate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.abhisek30.adapter_delegate.model.*

class MainViewModel : ViewModel() {

    private val _displayedItems = MutableLiveData<List<DisplayableItem>>()
    val displayableItems: LiveData<List<DisplayableItem>> = _displayedItems

    fun createDummyDisplayableItems() {
        val displayableItems = ArrayList<DisplayableItem>()
        displayableItems.add(Banner("Covid-19", "resources", "Useful apps & more", ""))
        displayableItems.add(
            Promotion("New to rent", App("Google Play Movies & TV", "Mahmood", "", 4.0f, 4, false), listOf(
            "", "", "", "", "", "", "", "", "", ""
        ))
        )
        displayableItems.add(Promotion("Top selling ebooks on Play", App("Google Play Books - Ebooks, Audio", "Priyabrata", "", 4.1f, 4, false), listOf(
            "", "", "", "", "", "", "", "", "", ""
        )))
        displayableItems.add(Banner("Social impact stars", "", "Inspiring ideas", ""))
        displayableItems.add(
            Featured("Recenly updated", "Fresh features & content", listOf(
            App("Podcast App: Free & Offline Podcasts by ...", "Likhit", "", 5.0f, 27, false),
            App("Air Brush: Easy Photo Editor", "Asif", "", 5.0f, 54, false),
            App("Soccer Scores - FotMob", "Aashish", "", 5.0f, 14, false),
            App("Focus Plant - Stay Focused Study Timer", "Arpit", "", 5.0f, 50, false)
        ))
        )
        displayableItems.add(Campaign(listOf(
            Banner("Make stunning", "videos in seconds", "Explore templates", ""),
            Banner("Change colors", "in one tap", "Try AI Select", ""),
            Banner("Try new", "masking effects", "Make awesome videos", "")
        )))
        _displayedItems.postValue(displayableItems)
    }
}