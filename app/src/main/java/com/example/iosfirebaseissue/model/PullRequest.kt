package com.example.iosfirebaseissue.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class PullRequest(
    @ColumnInfo(name = "diff_url")
    @Json(name = "diff_url")
    var diffUrl: String?,
    @ColumnInfo(name = "html_url")
    @Json(name = "html_url")
    var htmlUrl: String?,
    @ColumnInfo(name = "patch_url")
    @Json(name = "patch_url")
    var patchUrl: String?,
    @ColumnInfo(name = "url")
    @Json(name = "url")
    var url: String?
)