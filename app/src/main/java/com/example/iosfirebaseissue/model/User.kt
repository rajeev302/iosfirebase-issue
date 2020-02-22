package com.example.iosfirebaseissue.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class User(
    @ColumnInfo(name = "avatar_url")
    @Json(name = "avatar_url")
    var avatarUrl: String?,
    @ColumnInfo(name = "events_url")
    @Json(name = "events_url")
    var eventsUrl: String?,
    @ColumnInfo(name = "followers_url")
    @Json(name = "followers_url")
    var followersUrl: String?,
    @ColumnInfo(name = "following_url")
    @Json(name = "following_url")
    var followingUrl: String?,
    @ColumnInfo(name = "gists_url")
    @Json(name = "gists_url")
    var gistsUrl: String?,
    @ColumnInfo(name = "gravatar_id")
    @Json(name = "gravatar_id")
    var gravatarId: String?,
    @ColumnInfo(name = "html_url")
    @Json(name = "html_url")
    var htmlUrl: String?,
    @ColumnInfo(name = "id")
    @Json(name = "id")
    var id: Int?,
    @ColumnInfo(name = "login")
    @Json(name = "login")
    var login: String?,
    @ColumnInfo(name = "node_id")
    @Json(name = "node_id")
    var nodeId: String?,
    @ColumnInfo(name = "organizations_url")
    @Json(name = "organizations_url")
    var organizationsUrl: String?,
    @ColumnInfo(name = "received_events_url")
    @Json(name = "received_events_url")
    var receivedEventsUrl: String?,
    @ColumnInfo(name = "repos_url")
    @Json(name = "repos_url")
    var reposUrl: String?,
    @ColumnInfo(name = "site_admin")
    @Json(name = "site_admin")
    var siteAdmin: Boolean?,
    @ColumnInfo(name = "starred_url")
    @Json(name = "starred_url")
    var starredUrl: String?,
    @ColumnInfo(name = "subscriptions_url")
    @Json(name = "subscriptions_url")
    var subscriptionsUrl: String?,
    @ColumnInfo(name = "type")
    @Json(name = "type")
    var type: String?,
    @ColumnInfo(name = "url")
    @Json(name = "url")
    var url: String?
)