package com.pratik.catchywall.utils

import android.app.DownloadManager
import android.content.Context
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Environment
import timber.log.Timber
import java.io.File


object Utils {

    @Throws(Exception::class)
    fun downloadTask(context: Context, url: String): Boolean {
        if (!url.startsWith("http")) {
            return false
        }
        val name = "temp.mcaddon"
        try {
            val file = File(Environment.getExternalStorageDirectory(), "Download")
            if (!file.exists()) {
                file.mkdirs()
            }
            val result = File((file.getAbsolutePath() + File.separator).toString() + name)
            val downloadManager =
                context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
            val request = DownloadManager.Request(Uri.parse(url))
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
            request.setDestinationUri(Uri.fromFile(result))
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            downloadManager?.enqueue(request)
            //mToast(mContext, "Starting download...");
            MediaScannerConnection.scanFile(
                context, arrayOf(result.toString()), null
            ) { path, uri -> }
        } catch (e: Exception) {
            Timber.tag(">>>>>").e(e.toString())
            //mToast(this, e.toString());
            return false
        }
        return true
    }

}