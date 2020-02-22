package com.example.iosfirebaseissue.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class CommentResponseModel(
    @PrimaryKey(autoGenerate = true)
    var primaryKeyId: Int?,
    @ColumnInfo(name = "author_association")
    @Json(name = "author_association")
    var authorAssociation: String?,
    @ColumnInfo(name = "body")
    @Json(name = "body")
    var body: String?,
    @ColumnInfo(name = "created_at")
    @Json(name = "created_at")
    var createdAt: String?,
    @ColumnInfo(name = "html_url")
    @Json(name = "html_url")
    var htmlUrl: String?,
    @ColumnInfo(name = "id")
    @Json(name = "id")
    var id: Int?,
    @ColumnInfo(name = "issue_url")
    @Json(name = "issue_url")
    var issueUrl: String?,
    @ColumnInfo(name = "node_id")
    @Json(name = "node_id")
    var nodeId: String,
    @ColumnInfo(name = "updated_at")
    @Json(name = "updated_at")
    var updatedAt: String?,
    @ColumnInfo(name = "url")
    @Json(name = "url")
    var url: String?
//    @ColumnInfo(name = "user")
//    @Json(name = "user")
//    var user: User?
)