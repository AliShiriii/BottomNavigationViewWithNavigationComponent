package com.example.testapplication.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.Model.GetContent
import com.example.testapplication.R
import com.example.testapplication.ViewModel.FavoriteViewModel
import com.example.testapplication.adapter.FavoriteAdapter
import com.example.testapplication.databinding.FragmentAllBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentAllBinding

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all, container, false)

        val adapter = FavoriteAdapter()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        viewModel.getFavorite()

        viewModel.favoriteData?.observe(viewLifecycleOwner) { newData ->

            adapter.setList(newData)

        }


//
//        adapter.setOnItemClickCallBack(object : FavoriteAdapter.OnItemClickCallBack {
//            override fun callBack(contentEntity: ContentEntity) {
//
//                val getContent = GetContent(
//                    contentEntity.contentID,
//                    contentEntity.Image,
//                    contentEntity.Summary,
//                    contentEntity.Title
//                )
//
//                val action =
//                    FavoriteFragmentDirections.actionFavoriteToContentsFragment2(getContent)
//                findNavController().navigate(action)
//            }
//
//        })

        return binding.root

    }
}