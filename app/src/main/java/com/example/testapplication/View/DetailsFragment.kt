package com.example.testapplication.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.testapplication.R
import com.example.testapplication.ViewModel.DetailsViewModel
import com.example.testapplication.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DetailsFragment : Fragment() {

//    private lateinit var binding : FragmentDetailsBinding

    private var _binding : FragmentDetailsBinding? = null

    private val binding get() = _binding!!

    private val args by navArgs<DetailsFragmentArgs>()

    private val viewModel : DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false)

        binding.titles.text = args.Contents.Title

        binding.summarys.text = args.Contents.Summary

        Glide.with(this)
            .load(args.Contents.LandscapeImage)
            .into(binding.imgPoster)


        var isChecked = false

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.Main) {
                val count = viewModel.checkFavorite(args.Contents.ContentID)

                if (count > 0) {

                    binding.toggleFavorite.isChecked = true
                    isChecked = true

                } else {

                    binding.toggleFavorite.isChecked = false
                    isChecked = false

                }

            }

        }

        binding.toggleFavorite.setOnClickListener {

            isChecked = !isChecked

            if (isChecked){

                viewModel.insertFavorite(args.Contents)
            } else{

                viewModel.deleteFromFavorite(args.Contents.ContentID)
            }

            binding.toggleFavorite.isChecked = isChecked
        }

        return binding.root

    }

}
