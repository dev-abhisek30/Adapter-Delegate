package com.dev.abhisek30.adapter_delegate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.abhisek30.adapter_delegate.databinding.FragmentCategoryBinding
import com.dev.abhisek30.adapter_delegate.databinding.FragmentMainBinding

class CategoryFragment : Fragment() , ItemClickListner {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root

        setupViewModel()
        setupAdapter()
        observeViewModel()
        viewModel.createDummyDisplayableItems()

        return view
    }

    private fun setupViewModel() {
        viewModel = CategoryViewModel()
    }

    private fun setupAdapter() {
        adapter = CategoryAdapter(this)
        binding.recyclerCategory.apply {
            adapter = this@CategoryFragment.adapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            displayableItems.observe(viewLifecycleOwner) {
                adapter.items = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //handle with lamdas
    override fun showToastMessage(data: String) {
        Toast.makeText(requireContext(),data, Toast.LENGTH_SHORT).show()
    }
}