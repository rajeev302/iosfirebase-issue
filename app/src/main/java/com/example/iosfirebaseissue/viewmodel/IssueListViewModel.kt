package com.example.iosfirebaseissue.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.iosfirebaseissue.repository.Respository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class IssueListViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val repository = Respository()

    fun getIosFirebaseIssue(success: (message: String) -> Unit, failure: (message: String) -> Unit) = launch {
        repository.getIosFirebaseIssue()?.let {
            success.invoke(it.first().commentsUrl?:"")
        }?:run {
            failure.invoke("failed to get message")
        }
    }
}