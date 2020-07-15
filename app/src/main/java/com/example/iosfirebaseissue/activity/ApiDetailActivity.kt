package com.example.iosfirebaseissue.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.iosfirebaseissue.BuildConfig
import com.example.iosfirebaseissue.R
import com.example.iosfirebaseissue.viewmodel.ApiDetailViewModel
import kotlinx.android.synthetic.main.activity_api_detail.*

class ApiDetailActivity : AppCompatActivity() {

    private lateinit var textView: TextView
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
            textView.text = "Version code = ${BuildConfig.VERSION_CODE.toString()} \n" +
                    "version name = ${BuildConfig.VERSION_NAME} \n" + "base url = ${BuildConfig.BASE_URL}\n" +
                    "analytics api key = ${BuildConfig.ANALYTICS_API_KEY}\n" +
                    "analytics secret key=${BuildConfig.ANALYTICS_API_SECRET}\n"



//            val queue = Volley.newRequestQueue(this)
//            val url = NetworkManager.getBaseUrl()
//            val stringRequest = StringRequest(
//                Request.Method.GET, url,
//                Response.Listener<String> { response ->
//                    textView.loadData(response, "text/html; charset=utf-8", "UTF-8");
//                },
//                Response.ErrorListener {  })
//            queue.add(stringRequest)


        }
    }
}
