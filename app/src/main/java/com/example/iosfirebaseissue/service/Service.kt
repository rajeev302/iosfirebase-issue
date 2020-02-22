package com.example.iosfirebaseissue.service

import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("issues")
    fun getIosFireBaseIssue(): Call<List<IosFirebaseIssueResponseModel>>

    @GET("issues/{commentNumber}/comments")
    fun getCommentList(@Path("commentNumber")commentNumber: String): Call<List<CommentResponseModel>>
}