package com.example.iosfirebaseissue.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IosFirebaseIssueResponseModel(
    @Json(name = "assignee")
    var assignee: Any?,
    @Json(name = "assignees")
    var assignees: List<Any?>?,
    @Json(name = "author_association")
    var authorAssociation: String?,
    @Json(name = "body")
    var body: String?,
    @Json(name = "closed_at")
    var closedAt: Any?,
    @Json(name = "comments")
    var comments: Int?,
    @Json(name = "comments_url")
    var commentsUrl: String?,
    @Json(name = "created_at")
    var createdAt: String?,
    @Json(name = "events_url")
    var eventsUrl: String?,
    @Json(name = "html_url")
    var htmlUrl: String?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "labels")
    var labels: List<Label?>?,
    @Json(name = "labels_url")
    var labelsUrl: String?,
    @Json(name = "locked")
    var locked: Boolean?,
    @Json(name = "milestone")
    var milestone: Any?,
    @Json(name = "node_id")
    var nodeId: String?,
    @Json(name = "number")
    var number: Int?,
    @Json(name = "pull_request")
    var pullRequest: PullRequest?,
    @Json(name = "repository_url")
    var repositoryUrl: String?,
    @Json(name = "state")
    var state: String?,
    @Json(name = "title")
    var title: String?,
    @Json(name = "updated_at")
    var updatedAt: String?,
    @Json(name = "url")
    var url: String?,
    @Json(name = "user")
    var user: User?
)