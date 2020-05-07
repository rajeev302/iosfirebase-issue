package com.example.iosfirebaseissue.repository

import android.content.Context
import com.example.flicker_search_photos.model.FlickerSearchTagApiResponseModel
import com.example.iosfirebaseissue.apiservice.ApiService
import com.example.iosfirebaseissue.database.database
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
            val issueList = CoroutineScope(coroutineContext).async {
                return@async ApiService().getIosFirebaseIssue(coroutineContext)
            }.await()
            CoroutineScope(coroutineContext).async {
                issueList?.let {
                    database.getDatabaseInstance(context).dao().inserAllIssues(it)
                }
            }.await()
            return issueList
        } else {
            return CoroutineScope(coroutineContext).async {
                    database.getDatabaseInstance(context).dao().getAllIssues()
            }.await()
        }
    }

    suspend fun getCommentList(context: Context, commentNumber: String, issueNodeId: String): List<CommentResponseModel>? {
        if (context.isInternetAvailable()){
            val commentList = CoroutineScope(coroutineContext).async {
                return@async ApiService().getCommentList(coroutineContext, commentNumber)
            }.await()
            CoroutineScope(coroutineContext).async {
                commentList?.let {
                    it.forEach { commentResponseModel ->
                        commentResponseModel.issueNodeId = issueNodeId
                    }
                    database.getDatabaseInstance(context).dao().insertAllComments(it)
                }
            }.await()
            return commentList
        } else {
            return CoroutineScope(coroutineContext).async {
                database.getDatabaseInstance(context).dao().getAllComments(issueNodeId)
            }.await()
        }
    }

    suspend fun getPhotosBySearchTerm(context: Context, tags: String, page: Int?): FlickerSearchTagApiResponseModel? {
        if (context.isInternetAvailable()){
            val issueList = CoroutineScope(coroutineContext).async {
                return@async ApiService().getPhotosBySearchTerm(coroutineContext, tags = tags, page = page)
            }.await()
            return issueList
        } else {
            return null
        }
    }
}