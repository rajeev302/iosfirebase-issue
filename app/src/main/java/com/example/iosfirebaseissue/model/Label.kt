package com.example.iosfirebaseissue.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Label(
    @ColumnInfo(name = "color")
    @Json(name = "color")
    var color: String?,
    @ColumnInfo(name = "default")
    @Json(name = "default")
    var default: Boolean?,
    @ColumnInfo(name = "description")
    @Json(name = "description")
    var description: String?,
    @ColumnInfo(name = "id")
    @Json(name = "id")
    var id: Int?,
    @ColumnInfo(name = "name")
    @Json(name = "name")
    var name: String?,
    @ColumnInfo(name = "node_id")
    @Json(name = "node_id")
    var nodeId: String?,
    @ColumnInfo(name = "url")
    @Json(name = "url")
    var url: String?
)