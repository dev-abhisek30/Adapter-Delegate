package com.dev.abhisek30.adapter_delegate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.abhisek30.adapter_delegate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupAdapter()
        observeViewModel()
        viewModel.createDummyDisplayableItems()
    }

    private fun setupViewModel() {
        viewModel = MainViewModel()
    }

    private fun setupAdapter() {
        adapter = MainAdapter()
        binding.recyclerMain.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            displayableItems.observe(this@MainActivity) {
                adapter.items = it
            }
        }
    }
}