package com.example.myfavoritewebsites.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myfavoritewebsites.databinding.ActivityMainBinding
import com.example.myfavoritewebsites.models.url.AddUrlResponseModel
import com.example.myfavoritewebsites.viewmodel.AddUrlViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    private val viewModelUrl: AddUrlViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnGuardar?.setOnClickListener {
            addUrl(binding?.edUrl?.text.toString())
        }
        initLoginObserver()
    }

    // Callback
    private val urlAddResult = Observer<AddUrlResponseModel> { accessResponseModel ->
        if (accessResponseModel.alias != "") {
            Toast.makeText(this, "ya paso ${accessResponseModel.links.self}", Toast.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this, "an exception occurred, please try again", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun initLoginObserver() {
        viewModelUrl.urlRegisterLD.observe(this, urlAddResult)
    }

    fun addUrl(url: String) {
        viewModelUrl.addNewValidation(url)
    }
}
