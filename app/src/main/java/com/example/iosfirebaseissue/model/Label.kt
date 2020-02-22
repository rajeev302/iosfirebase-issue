package com.example.iosfirebaseissue.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Label(
    @Json(name = "color")
    var color: String?,
    @Json(name = "default")
    var default: Boolean?,
    @Json(name = "description")
    var description: String?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "node_id")
    var nodeId: String?,
    @Json(name = "url")
    var url: String?
)