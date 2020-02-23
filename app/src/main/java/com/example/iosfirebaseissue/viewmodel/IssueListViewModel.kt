package com.example.iosfirebaseissue.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.iosfirebaseissue.database.database
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
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
    val issueList: MutableList<IosFirebaseIssueResponseModel> = mutableListOf()

    fun getIosFirebaseIssue(context: Context, success: () -> Unit, failure: (message: String) -> Unit) = launch {
        repository.getIosFirebaseIssue(context)?.let {
            issueList.clear()
            issueList.addAll(it)
            success.invoke()
        }?:run {
            failure.invoke("failed to get message")
        }
    }

    fun updateCommentLocalStorage(context: Context) = launch{
        issueList.forEach {
            repository.getCommentList(context, it.number.toString(), it.nodeId)
        }
    }
}