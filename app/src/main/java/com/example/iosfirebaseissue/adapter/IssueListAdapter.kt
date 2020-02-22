package com.example.iosfirebaseissue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iosfirebaseissue.R
import com.example.iosfirebaseissue.model.IosFirebaseIssueResponseModel

class IssueListAdapter(
    val context: Context,
    val dataSet: MutableList<IosFirebaseIssueResponseModel>,
    val callback: IssueListAdapterCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataSet.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val issueHolder = holder as IssueListViewHolder
        issueHolder.issueTitle.text = dataSet[position].title?.trim()?.trimStart()
        issueHolder.issueBody.text = dataSet[position].body?.trimEnd()?.trimStart() ?: "--"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_issue_list_row, parent, false)
        return IssueListViewHolder(itemView)
    }

    inner class IssueListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val issueTitle: TextView = itemView.findViewById(R.id.issue_title)
        val issueBody: TextView = itemView.findViewById(R.id.issue_body)

        init {
            itemView.setOnClickListener {
                callback.rowClicked(adapterPosition)
            }
        }
    }

    interface IssueListAdapterCallback {
        fun rowClicked(position: Int)
    }
}