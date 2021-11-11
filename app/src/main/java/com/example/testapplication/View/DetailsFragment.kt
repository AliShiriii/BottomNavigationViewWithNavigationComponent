package com.example.testapplication.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.testapplication.ViewModel.DetailsViewModel
import com.example.testapplication.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : androidx.fragment.app.Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()
    private val viewModel: DetailsViewModel by viewModels()

    var isChecked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDetailsData()
        checkItemForFavorite()
        addItemToDataBase()

    }

    private fun getDetailsData() {

        binding.titles.text = args.contents.Title
        binding.summarys.text = args.contents.Summary

        Picasso.get()
            .load(args.contents.LandscapeImage)
            .into(binding.imgPoster)

    }

    private fun checkItemForFavorite() {

        CoroutineScope(Dispatchers.Main).launch {

            val count = viewModel.checkFavorite(args.contents.ContentID)

            if (count > 0) {

                binding.toggleFavorite.isChecked = true
                isChecked = true

            } else {

                binding.toggleFavorite.isChecked = false
                isChecked = false

            }

        }
    }

    private fun addItemToDataBase() {

        binding.toggleFavorite.setOnClickListener {

            isChecked = !isChecked

            if (isChecked) {

                viewModel.insertFavorite(args.contents)

            } else {

                viewModel.deleteFromFavorite(args.contents.ContentID)
            }

            binding.toggleFavorite.isChecked = isChecked
        }

    }
}
