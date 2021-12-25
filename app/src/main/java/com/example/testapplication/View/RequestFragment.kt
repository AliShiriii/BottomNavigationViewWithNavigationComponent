package com.example.testapplication.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.testapplication.Model.GetContent
import com.example.testapplication.ViewModel.RequestViewModel
import com.example.testapplication.adapter.RequestAdapter
import com.example.testapplication.databinding.FragmentRequestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RequestFragment : androidx.fragment.app.Fragment(), RequestAdapter.OnItemClickListener {

    private var _binding: FragmentRequestBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RequestViewModel by viewModels()
    private lateinit var adapter: RequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentRequestBinding.inflate(inflater, container, false)

        addListRequestToRecycler()

        return binding.root
    }

    private fun addListRequestToRecycler() {

        adapter = RequestAdapter(this)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        viewModel.pushPost.observe(viewLifecycleOwner) { response ->
            Log.i("TAG: ", response.toString())
            adapter.submitData(viewLifecycleOwner.lifecycle, response)

        }
    }

    override fun onItemClick(content: GetContent) {

        val action = RequestFragmentDirections.actionRequestToDetails(content)
        findNavController().navigate(action)
    }

}