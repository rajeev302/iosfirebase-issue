package com.example.iosfirebaseissue.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class IosFirebaseIssueResponseModel(
//    @ColumnInfo(name = "assignee")
//    @Json(name = "assignee")
//    var assignee: Any?,
//    @ColumnInfo(name = "assignees")
//    @Json(name = "assignees")
//    var assignees: List<Any>?,
    @ColumnInfo(name = "author_association")
    @Json(name = "author_association")
    var authorAssociation: String?,
    @ColumnInfo(name = "body")
    @Json(name = "body")
    var body: String?,
//    @ColumnInfo(name = "closed_at")
//    @Json(name = "closed_at")
//    var closedAt: Any?,
    @ColumnInfo(name = "comments")
    @Json(name = "comments")
    var comments: Int?,
    @ColumnInfo(name = "comments_url")
    @Json(name = "comments_url")
    var commentsUrl: String?,
    @ColumnInfo(name = "created_at")
    @Json(name = "created_at")
    var createdAt: String?,
    @ColumnInfo(name = "events_url")
    @Json(name = "events_url")
    var eventsUrl: String?,
    @ColumnInfo(name = "html_url")
    @Json(name = "html_url")
    var htmlUrl: String?,
    @ColumnInfo(name = "id")
    @Json(name = "id")
    var id: Int?,
//    @ColumnInfo(name = "labels")
//    @Json(name = "labels")
//    var labels: List<Label>?,
    @ColumnInfo(name = "labels_url")
    @Json(name = "labels_url")
    var labelsUrl: String?,
    @ColumnInfo(name = "locked")
    @Json(name = "locked")
    var locked: Boolean?,
//    @ColumnInfo(name = "milestone")
//    @Json(name = "milestone")
//    var milestone: Any?,
    @PrimaryKey
    @ColumnInfo(name = "node_id")
    @Json(name = "node_id")
    var nodeId: String,
    @ColumnInfo(name = "number")
    @Json(name = "number")
    var number: Int?,
//    @ColumnInfo(name = "pull_request")
//    @Json(name = "pull_request")
//    var pullRequest: PullRequest?,
    @ColumnInfo(name = "repository_url")
    @Json(name = "repository_url")
    var repositoryUrl: String?,
    @ColumnInfo(name = "state")
    @Json(name = "state")
    var state: String?,
    @ColumnInfo(name = "title")
    @Json(name = "title")
    var title: String?,
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