package com.example.iosfirebaseissue.repository

import com.example.iosfirebaseissue.apiservice.ApiService
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

    suspend fun getIosFirebaseIssue(): List<IosFirebaseIssueResponseModel>? {
        return CoroutineScope(coroutineContext).async {
            return@async ApiService().getIosFirebaseIssue(coroutineContext)
        }.await()
    }
}