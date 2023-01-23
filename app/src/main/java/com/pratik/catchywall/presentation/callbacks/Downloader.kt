package com.pratik.catchywall.presentation.callbacks

interface Downloader {

    fun downloadFile(url: String): Long

}