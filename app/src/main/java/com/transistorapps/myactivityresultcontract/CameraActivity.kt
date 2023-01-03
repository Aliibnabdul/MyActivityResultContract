package com.transistorapps.myactivityresultcontract

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

private const val DEFAULT_PHOTOS_LIMIT = 5
const val EXTRA_PHOTOS_KEY = "EXTRA_PHOTOS_KEY"
const val PHOTOS_LIMIT_KEY = "PHOTOS_LIMIT_KEY"

class CameraActivity : AppCompatActivity() {
    private var photosLimit: Int = DEFAULT_PHOTOS_LIMIT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        photosLimit = intent.getIntExtra(PHOTOS_LIMIT_KEY, DEFAULT_PHOTOS_LIMIT)
        Log.d("CameraActivity-TAG", "onCreate()\n" +
                "photosLimit: $photosLimit")
        findViewById<Button>(R.id.buttonGetResult).setOnClickListener {
            onDoneClick()
        }
    }

    private fun onDoneClick() {
        val resultIntent = Intent()
        val dataList = buildList {
            (1..photosLimit).forEach{
                add("Photo uri $it")
            }
        }
        resultIntent.putStringArrayListExtra(EXTRA_PHOTOS_KEY, ArrayList(dataList))
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}