package com.example.testapplication.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteBinding

    private val args by navArgs<FavoriteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_favorite, container, false)

        binding.titles.text = args.Contents.Title

        binding.summarys.text = args.Contents.Summary

        Glide.with(this)
            .load(args.Contents.LandscapeImage)
            .into(binding.imgPoster)

        return binding.root

    }

}