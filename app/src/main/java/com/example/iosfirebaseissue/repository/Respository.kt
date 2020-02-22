package com.example.iosfirebaseissue.repository

import android.content.Context
import com.example.iosfirebaseissue.apiservice.ApiService
import com.example.iosfirebaseissue.extensions.isInternetAvailable
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext

class Respository: CoroutineScope {
    private val job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    suspend fun getIosFirebaseIssue(context: Context): List<IosFirebaseIssueResponseModel>? {
        if (context.isInternetAvailable()){
            return CoroutineScope(coroutineContext).async {
                return@async ApiService().getIosFirebaseIssue(coroutineContext)
            }.await()
        } else {
            return null
        }
    }

    suspend fun getCommentList(context: Context, commentNumber: String): List<CommentResponseModel>? {
        if (context.isInternetAvailable()){
            return CoroutineScope(coroutineContext).async {
                return@async ApiService().getCommentList(coroutineContext, commentNumber)
            }.await()
        } else {
            return null
        }
    }
}