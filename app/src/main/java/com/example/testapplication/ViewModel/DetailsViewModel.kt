package com.example.testapplication.ViewModel

import android.view.View
import android.view.ViewManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.Entity.ContentEntity
import com.example.testapplication.Model.GetContent
import com.example.testapplication.Repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository) : ViewModel() {


    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

     fun insertFavorite(getContent: GetContent) {

        viewModelScope.launch(Dispatchers.IO) {

            favoriteRepository.insertFavorite(
                ContentEntity(
                    getContent.ContentID,
                    getContent.Title,
                    getContent.Summary,
                    getContent.LandscapeImage
                )
            )

        }

    }

    suspend fun checkFavorite(id: Int):Int {

       return favoriteRepository.checkFavorite(id)

    }

     fun deleteFromFavorite(id: Int) {

        uiScope.launch(Dispatchers.IO) {
            favoriteRepository.deleteFromFavorite(id)

        }
    }

}