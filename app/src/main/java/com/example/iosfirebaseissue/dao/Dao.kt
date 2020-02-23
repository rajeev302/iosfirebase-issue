package com.example.iosfirebaseissue.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel

@Dao
interface Dao {
    @Query("SELECT * FROM CommentResponseModel where issueNodeId = :issueNodeId")
    fun getAllComments(issueNodeId: String): List<CommentResponseModel>

    @Query("SELECT * FROM IosFirebaseIssueResponseModel")
    fun getAllIssues(): List<IosFirebaseIssueResponseModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllComments(comments: List<CommentResponseModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserAllIssues(issues: List<IosFirebaseIssueResponseModel>)

}