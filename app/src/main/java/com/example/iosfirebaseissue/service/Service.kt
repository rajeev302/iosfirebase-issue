package com.example.iosfirebaseissue.service

import com.example.flicker_search_photos.model.FlickerSearchTagApiResponseModel
import com.example.iosfirebaseissue.constants.Constants
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("issues")
    fun getIosFireBaseIssue(): Call<List<IosFirebaseIssueResponseModel>>

    @GET("issues/{commentNumber}/comments")
    fun getCommentList(@Path("commentNumber")commentNumber: String): Call<List<CommentResponseModel>>

    @GET("rest/?&tags=dogs&format=json&nojsoncallback=1")
    fun getPhotosBySearchTerm(@Query("method") method: String = Constants.FLICKR_SEARCH_METHOD,
                              @Query("api_key") api_key: String = Constants.FLICKR_API_KEY,
                              @Query("tags")tags: String,
                              @Query("page")page: Int?,
                              @Query("format") format: String = "json",
                              @Query("nojsoncallback")nojsoncallback: String = "1"): Call<FlickerSearchTagApiResponseModel>
}