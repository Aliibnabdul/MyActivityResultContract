package com.transistorapps.myactivityresultcontract

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract

class TakePhotosContract : ActivityResultContract<Int, List<String>?>() {
    override fun createIntent(context: Context, input: Int): Intent {
        return Intent(context, CameraActivity::class.java).also {
            it.putExtra(PHOTOS_LIMIT_KEY, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): List<String>? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return intent?.getStringArrayListExtra(EXTRA_PHOTOS_KEY)
    }
}