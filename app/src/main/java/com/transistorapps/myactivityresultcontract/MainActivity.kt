package com.transistorapps.myactivityresultcontract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val SINGLE_IMAGE_LIMIT = 1
private const val MULTIPLE_IMAGES_LIMIT = 10

class MainActivity : AppCompatActivity() {
    private val photoPickerLauncher = registerForActivityResult(TakePhotosContract()) { uriList ->
        Log.d("MainActivity-TAG", "photoPickerLauncher\n" +
                "uriList: $uriList")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvTakeOnePhoto).setOnClickListener {
            photoPickerLauncher.launch(SINGLE_IMAGE_LIMIT)
        }
        findViewById<TextView>(R.id.tvTakeTenPhotos).setOnClickListener {
            photoPickerLauncher.launch(MULTIPLE_IMAGES_LIMIT)
        }
    }
}