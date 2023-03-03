package com.example.vkgif.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkgif.data.Category
import com.example.vkgif.data.GifDTO
import com.example.vkgif.repo.GiphyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class GifListViewModel @Inject constructor(private val giphyRepo : GiphyRepo) : ViewModel() {


    private var _giphyList = MutableLiveData<List<GifDTO>>()
    val giphyList get() = _giphyList

    private var _categoryList = ArrayList<Category>()
    val categoryList get() = _categoryList
    private val listOfCategory = listOf(
        "Cat",
        "Dog",
        "Baby",
        "Smile",
        "Memes",
        "Haha",
        "Chuck",
        "Girl",
        "Brain"
    )


    init {
        listOfCategory.forEach {
            _categoryList.add(Category(it))
        }
        getGiphy()
    }

    private fun getGiphy() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val giphyListDef = async { giphyRepo.getGiphy().listOfGif }
            _giphyList.postValue(giphyListDef.await())

        } catch (e: Exception) {
            Log.d("GetGiphy", e.message.toString())
        }
    }

    fun getSearchGiphy(title: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val searchListDeffered: Deferred<ArrayList<GifDTO>> = if (title.isEmpty()) {
                async { giphyRepo.getGiphy().listOfGif }
            } else {
                async { giphyRepo.getSearchGiphy(title).searchList }
            }
            _giphyList.postValue(searchListDeffered.await())
        } catch (e: java.lang.Exception) {
            Log.d("Search", e.message.toString())
        }
    }

}