package com.dev.abhisek30.adapter_delegate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.abhisek30.adapter_delegate.model.*

class CategoryViewModel : ViewModel() {

    private val _displayedItems = MutableLiveData<List<DisplayableItem>>()
    val displayableItems: LiveData<List<DisplayableItem>> = _displayedItems

    fun createDummyDisplayableItems() {
        val displayableItems = ArrayList<DisplayableItem>()
        displayableItems.add(Category("Action"))
        displayableItems.add(Category("Games"))
        displayableItems.add(Category("Board"))
        displayableItems.add(Category("Puzzle"))
        displayableItems.add(Category("Music"))
        displayableItems.add(Category("Trivia"))
        displayableItems.add(Category("Word"))
        displayableItems.add(Category("Racing"))

        _displayedItems.postValue(displayableItems)
    }
}