package com.example.iosfirebaseissue.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentResponseModel(
    @Json(name = "author_association")
    var authorAssociation: String?,
    @Json(name = "body")
    var body: String?,
    @Json(name = "created_at")
    var createdAt: String?,
    @Json(name = "html_url")
    var htmlUrl: String?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "issue_url")
    var issueUrl: String?,
    @Json(name = "node_id")
    var nodeId: String?,
    @Json(name = "updated_at")
    var updatedAt: String?,
    @Json(name = "url")
    var url: String?,
    @Json(name = "user")
    var user: UserX?
)