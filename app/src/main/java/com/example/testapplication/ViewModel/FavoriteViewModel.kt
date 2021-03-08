package com.example.testapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.Repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository): ViewModel() {


//    private val _pushBody = MutableLiveData<List<ContentEntity>>()

    var favoriteData : LiveData<List<ContentEntity>>? = null


    fun getFavorite() {

        val favorite = favoriteRepository.getAllFavorite()

        favoriteData = favorite

    }

}