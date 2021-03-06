package com.example.iosfirebaseissue.apiservice

import android.net.Network
import com.example.iosfirebaseissue.constants.Constants
import com.example.iosfirebaseissue.manager.NetworkManager
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import com.example.iosfirebaseissue.service.Service
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext

class ApiService{
    suspend fun getIosFirebaseIssue(coroutineContext: CoroutineContext): List<IosFirebaseIssueResponseModel>? = CoroutineScope(coroutineContext).async {
        val apiService = NetworkManager.makeRetrofitObject(Service::class.java, Constants.BASE_URL)
        val callResult = apiService.getIosFireBaseIssue()
        callResult.execute().body()
    }.await()

    suspend fun getCommentList(coroutineContext: CoroutineContext, commentNumber: String): List<CommentResponseModel>? = CoroutineScope(coroutineContext).async {
        val apiService = NetworkManager.makeRetrofitObject(Service::class.java, Constants.BASE_URL)
        val callResult = apiService.getCommentList(commentNumber)
        callResult.execute().body()
    }.await()
}