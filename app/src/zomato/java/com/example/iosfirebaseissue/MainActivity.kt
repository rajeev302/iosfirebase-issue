package com.example.iosfirebaseissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iosfirebaseissue.adapter.ImageListAdapter
import com.example.iosfirebaseissue.viewmodel.MainViewModel
import kotlinx.android.synthetic.zomato.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageListAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupUi()
        setupRecyclerView()
    }

    private fun setupUi(){
        recyclerView = search_result_recycler_view
        progressBar = progress_bar
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPhotosBySearchTerm(this, null, {
            progressBar.visibility = View.GONE
            adapter.notifyDataSetChanged()
        }, {
            Toast.makeText(this, "failed to load the data", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRecyclerView(){
        val layoutManager = GridLayoutManager(this, 2)
        adapter = ImageListAdapter(this, viewModel.flickrPhotoResponseList, viewModel.totalPageFetched, viewModel.totalPage, viewModel.perPage)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}
