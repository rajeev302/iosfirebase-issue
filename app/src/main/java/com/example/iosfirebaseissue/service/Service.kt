package com.example.iosfirebaseissue.service

import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("issues")
    fun getIosFireBaseIssue(): Call<List<IosFirebaseIssueResponseModel>>
}