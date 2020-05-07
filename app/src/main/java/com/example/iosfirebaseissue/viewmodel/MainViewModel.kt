package com.example.iosfirebaseissue.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.flicker_search_photos.model.FlickrPhotoResponseModel
import com.example.iosfirebaseissue.repository.Respository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val repository = Respository()
    val flickrPhotoResponseList: MutableList<FlickrPhotoResponseModel> = mutableListOf()
    var searchTag: String = "cat"
    var totalPageFetched: Int = 0
    var totalPage: Int = 0
    val perPage: Int = 100

    fun getPhotosBySearchTerm(context: Context, page: Int?, success: () -> Unit, failure: (message: String) -> Unit) = launch {
        repository.getPhotosBySearchTerm(context, searchTag, page = page)?.let {
            if (totalPageFetched == 0){
                flickrPhotoResponseList.clear()
            }
            totalPageFetched = it.photos?.page ?: 0
            totalPage = it.photos?.pages?.toInt() ?: 0
            it.photos?.flickrPhotoResponseModel?.let {
                flickrPhotoResponseList.addAll(it)
            }
            success.invoke()
        }?:run {
            failure.invoke("failed to get message")
        }
    }
}