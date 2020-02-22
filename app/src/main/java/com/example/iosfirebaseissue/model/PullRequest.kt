package com.example.iosfirebaseissue.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PullRequest(
    @Json(name = "diff_url")
    var diffUrl: String?,
    @Json(name = "html_url")
    var htmlUrl: String?,
    @Json(name = "patch_url")
    var patchUrl: String?,
    @Json(name = "url")
    var url: String?
)