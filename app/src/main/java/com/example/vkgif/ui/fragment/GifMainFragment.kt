package com.example.vkgif.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vkgif.databinding.GifFragmentBinding
import com.example.vkgif.ui.adapter.CategoryListAdapter
import com.example.vkgif.ui.adapter.GifListAdapter
import com.example.vkgif.ui.viewModel.GifListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GifMainFragment : Fragment(), CellClickListener {

    private lateinit var binding: GifFragmentBinding
   private val viewModel : GifListViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = GifFragmentBinding.inflate(inflater)

        binding.searchButton.setOnClickListener {
            viewModel.getSearchGiphy(binding.searchAutocomplete.text.toString())
        }

        binding.categoryListRecyclerview.apply {
            layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = CategoryListAdapter(viewModel.categoryList, this@GifMainFragment)
        }

        viewModel.giphyList.observe(viewLifecycleOwner, Observer {
            binding.giphyListRecyclerview.apply {
                layoutManager=GridLayoutManager(requireContext(),2)
                adapter = GifListAdapter(it)
            }
        })
        return binding.root
    }

    override fun onCellClickListener(title : String) {
        viewModel.getSearchGiphy(title)
    }
}

interface CellClickListener {
    fun onCellClickListener(title : String)
}