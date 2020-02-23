package com.example.iosfirebaseissue.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iosfirebaseissue.R
import com.example.iosfirebaseissue.adapter.CommentListAdapter
import com.example.iosfirebaseissue.viewmodel.CommentListViewmodel
import kotlinx.android.synthetic.main.activity_comment_list.*

class CommentListActivity : AppCompatActivity() {

    companion object {
        const val COMMENT_NUMBER = "commentNumber"
        const val ISSUES_NODE_ID = "nodeId"
    }

    var commentUrl: String? = null
    var issueNodeId: String? = null
    private lateinit var viewmodel: CommentListViewmodel
    private lateinit var recyclerView: RecyclerView
    private lateinit var commentListAdapter: CommentListAdapter
    private lateinit var noCommentAvailable: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_list)
        viewmodel = ViewModelProvider(this).get(CommentListViewmodel::class.java)
        commentUrl = intent.getStringExtra(COMMENT_NUMBER)
        issueNodeId = intent.getStringExtra(ISSUES_NODE_ID)
        setupUi()
        fireApiCall()
    }

    private fun setupUi(){
        recyclerView = comment_list_recycler_view
        noCommentAvailable = no_comment_available
        progressBar = comment_progress_bar
        commentListAdapter = CommentListAdapter(this, viewmodel.commentList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = commentListAdapter
    }

    private fun fireApiCall(){
        commentUrl?.let {
            viewmodel.getCommentList(this, it, issueNodeId?:"", {
                progressBar.visibility = View.GONE
                if (viewmodel.commentList.size>0){
                    noCommentAvailable.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    commentListAdapter.notifyDataSetChanged()
                } else {
                    noCommentAvailable.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
            }, {
                progressBar.visibility = View.GONE
                noCommentAvailable.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            })
        }
    }
}
