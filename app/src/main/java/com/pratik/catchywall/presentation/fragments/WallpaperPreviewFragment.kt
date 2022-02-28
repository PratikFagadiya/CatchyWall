package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentWallpaperPreviewBinding

class WallpaperPreviewFragment : Fragment(R.layout.fragment_wallpaper_preview) {

    lateinit var fragmentWallpaperPreviewBinding: FragmentWallpaperPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWallpaperPreviewBinding = FragmentWallpaperPreviewBinding.inflate(inflater,container,false)
        return fragmentWallpaperPreviewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}