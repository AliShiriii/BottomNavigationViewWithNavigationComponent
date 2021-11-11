package com.example.testapplication.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.Model.GetContent
import com.example.testapplication.R
import com.example.testapplication.ViewModel.FavoriteViewModel
import com.example.testapplication.adapter.FavoriteAdapter
import com.example.testapplication.databinding.FragmentAllBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : androidx.fragment.app.Fragment() {

//    private lateinit var binding: FragmentAllBinding

    private var _binding : FragmentAllBinding? = null

    private val binding get() = _binding!!

    private val viewModel: FavoriteViewModel by viewModels()

    private var adapter: FavoriteAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentAllBinding.inflate(inflater, container, false)

        addListToAdapter()
        addListToDataBase()
        addOnClickForItem()

        return binding.root

    }

    fun addListToAdapter(){

        adapter = FavoriteAdapter()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

    }

    fun addListToDataBase(){

        lifecycleScope.launch {
            viewModel.getFavorite()

            viewModel.favoriteData?.observe(viewLifecycleOwner) { newData ->

                adapter?.setList(newData)

            }
        }
    }

    private fun addOnClickForItem(){

        adapter?.setOnItemClickCallBack(object : FavoriteAdapter.OnItemClickCallBack {
            override fun callBack(contentEntity: ContentEntity) {

                val getContent = GetContent(
                    contentEntity.contentID,
                    contentEntity.Image,
                    contentEntity.Summary,
                    contentEntity.Title
                )

                val action = FavoriteFragmentDirections.actionFavoriteToDetails(getContent)
                findNavController().navigate(action)

            }

        })

    }
}
