package com.example.iosfirebaseissue.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.webkit.WebView
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.iosfirebaseissue.R
import com.example.iosfirebaseissue.manager.NetworkManager
import com.example.iosfirebaseissue.viewmodel.ApiDetailViewModel
import kotlinx.android.synthetic.main.activity_api_detail.*

class ApiDetailActivity : AppCompatActivity() {

    private lateinit var textView: WebView
    private lateinit var button: Button
    private lateinit var viewModel: ApiDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_detail)
        viewModel = ViewModelProvider(this).get(ApiDetailViewModel::class.java)
        setupUi()
        setupClickListener()
    }

    private fun setupUi(){
        textView = api_detail_text_view
        button = fetch_api_details
    }

    private fun setupClickListener(){
        button.setOnClickListener {
            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = NetworkManager.getBaseUrl()

// Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textView.loadData(response, "text/html; charset=utf-8", "UTF-8");
                },
                Response.ErrorListener {  })

// Add the request to the RequestQueue.
            queue.add(stringRequest)

        }
    }
}
