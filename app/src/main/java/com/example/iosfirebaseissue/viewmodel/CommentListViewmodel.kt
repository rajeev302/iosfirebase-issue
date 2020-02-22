package com.example.iosfirebaseissue.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import com.example.iosfirebaseissue.repository.Respository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CommentListViewmodel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val repository = Respository()
    val commentList: MutableList<CommentResponseModel> = mutableListOf()

    fun getCommentList(context: Context, commentNumber: String, success: () -> Unit, failure: (message: String) -> Unit) = launch {
        repository.getCommentList(context, commentNumber)?.let {
            commentList.clear()
            commentList.addAll(it)
            success.invoke()
        }?:run {
            failure.invoke("failed to get message")
        }
    }
}