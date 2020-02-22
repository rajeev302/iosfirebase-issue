package com.example.iosfirebaseissue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iosfirebaseissue.R
import com.example.iosfirebaseissue.model.CommentResponseModel
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel

class CommentListAdapter(
    val context: Context,
    val dataSet: MutableList<CommentResponseModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataSet.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val issueHolder = holder as IssueListViewHolder
        issueHolder.commentUserName.text = dataSet[position].user?.login
        issueHolder.commentBody.text = dataSet[position].body
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_comment_list, parent, false)
        return IssueListViewHolder(itemView)
    }

    inner class IssueListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentUserName: TextView = itemView.findViewById(R.id.comment_user_name)
        val commentBody: TextView = itemView.findViewById(R.id.comment_body)
    }
}