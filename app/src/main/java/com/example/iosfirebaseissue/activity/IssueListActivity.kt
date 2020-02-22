package com.example.iosfirebaseissue.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val intent = Intent(this, CommentListActivity::class.java)
        intent.putExtra(CommentListActivity.COMMENT_NUMBER, viewModel.issueList[position].number.toString())
        startActivity(intent)
    }

    private fun fireApiCall(){
        viewModel.getIosFirebaseIssue(this, {
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
