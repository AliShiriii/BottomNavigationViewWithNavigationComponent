package com.example.testapplication.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.testapplication.Model.SendRequest
import com.example.testapplication.Model.Request
import com.example.testapplication.ViewModel.RequestViewModel
import com.example.testapplication.adapter.RequestAdapter
import com.example.testapplication.databinding.FragmentRequestBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.json.JSONObject

@AndroidEntryPoint
class RequestFragment : Fragment() {

    private var _binding: FragmentRequestBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RequestViewModel by viewModels()

    private lateinit var adpter : RequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentRequestBinding.inflate(inflater, container, false)

        adpter = RequestAdapter()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adpter
        viewModel.getBody()

        lifecycleScope.launch {
            viewModel.pushPost?.collectLatest {

//                Log.i("TAG: ", newData.toString())
                adpter.submitData(it)

            }
        }
        return binding.root
    }

}