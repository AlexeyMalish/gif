package com.example.vkgif.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.vkgif.databinding.FragmentGifPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifPageFragment : Fragment() {

    private lateinit var binding: com.example.vkgif.databinding.FragmentGifPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGifPageBinding.inflate(inflater)
        binding.title.text = arguments?.getString("title")
        arguments?.getString("source")?.let {
            if(it.isEmpty()){
                binding.source.visibility = View.GONE
                binding.sourceText.visibility = View.GONE
            }
            else{
                binding.source.visibility = View.VISIBLE
                binding.sourceText.visibility = View.VISIBLE
                binding.source.text =it
            }

        }
        binding.crate.text = arguments?.getString("date")
        binding.backButtonArrow.setOnClickListener{
            findNavController().popBackStack()
        }
        Glide.with(requireContext())
            .load(arguments?.getString("url"))
            .into(binding.giphyFullPageIv)
        return binding.root
    }

}