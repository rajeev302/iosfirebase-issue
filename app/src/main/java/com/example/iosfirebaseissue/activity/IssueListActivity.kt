package com.example.iosfirebaseissue.activity

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iosfirebaseissue.BuildConfig
import com.example.iosfirebaseissue.R
import com.example.iosfirebaseissue.adapter.IssueListAdapter
import com.example.iosfirebaseissue.viewmodel.IssueListViewModel
import kotlinx.android.synthetic.main.activity_issue_list.*


class IssueListActivity : AppCompatActivity(), IssueListAdapter.IssueListAdapterCallback {

    private lateinit var viewModel: IssueListViewModel
    private lateinit var issueRecyclerView: RecyclerView
    private lateinit var issueAdapter: IssueListAdapter
    private lateinit var noDataAvailable: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list)

        Log.d("GlobalIssueListActivity", "appId --> " + BuildConfig.APPLICATION_ID)
        viewModel = ViewModelProvider(this).get(IssueListViewModel::class.java)
        setupUi()
        fireApiCall()
    }

    private fun setupUi(){
        issueRecyclerView = issue_recycler_view
        noDataAvailable = issue_no_data_available
        progressBar = issue_progress_bar
        issueAdapter = IssueListAdapter(this, viewModel.issueList, this)
        val layoutManager = LinearLayoutManager(this)
        issueRecyclerView.layoutManager = layoutManager
        issueRecyclerView.adapter = issueAdapter
    }

    override fun rowClicked(position: Int) {
        val intent = Intent()
        intent.setClassName(packageName, "$packageName.CommentsListActivity")
        intent.putExtra(CommentListActivity.COMMENT_NUMBER, viewModel.issueList[position].number.toString())
        intent.putExtra(CommentListActivity.ISSUES_NODE_ID, viewModel.issueList[position].nodeId)
        startActivity(intent)
    }

    private fun fireApiCall(){
        viewModel.getIosFirebaseIssue(this, {
//            viewModel.updateCommentLocalStorage(this)
            issueAdapter.notifyDataSetChanged()
            progressBar.visibility = View.GONE
            noDataAvailable.visibility = View.GONE
            issueRecyclerView.visibility = View.VISIBLE
        }, {
            progressBar.visibility = View.GONE
            noDataAvailable.visibility = View.VISIBLE
            issueRecyclerView.visibility = View.GONE
        })
    }
}
