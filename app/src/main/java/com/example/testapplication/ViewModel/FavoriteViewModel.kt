package com.example.testapplication.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.Repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository) :
    ViewModel() {

    var favoriteData: LiveData<List<ContentEntity>>? = null

    fun getFavorite() {

        val favorite = favoriteRepository.getAllFavorite()

        favoriteData = favorite

    }

}