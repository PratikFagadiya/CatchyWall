package com.pratik.catchywall.utils

import android.app.DownloadManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import com.pratik.catchywall.presentation.callbacks.Downloader

//class AndroidDownloader(
//    val context: Context
//) : Downloader {
//    private val downloadManager = context.getSystemService(DownloadManager::class.java)
//
////    override fun downloadFile(url: String): Long {
////        val request = DownloadManager.Request(url.toUri())
////            .setMimeType("image/*")
////            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
////            .setTitle("Downloading File....")
////
////    }
//}