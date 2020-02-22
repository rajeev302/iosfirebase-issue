package com.example.iosfirebaseissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.iosfirebaseissue.viewmodel.IssueListViewModel

class IssueListActivity : AppCompatActivity() {

    private lateinit var viewModel: IssueListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(IssueListViewModel::class.java)
    }
}
