package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentWallpaperPreviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WallpaperPreviewFragment : Fragment(R.layout.fragment_wallpaper_preview) {

    private lateinit var fragmentWallpaperPreviewBinding: FragmentWallpaperPreviewBinding

    private val userName by lazy {
        arguments?.let {
            WallpaperPreviewFragmentArgs.fromBundle(it).userName
        }
    }

    private val id by lazy {
        arguments?.let {
            WallpaperPreviewFragmentArgs.fromBundle(it).id
        }
    }

    private val userModel by lazy {
        arguments?.let {
            WallpaperPreviewFragmentArgs.fromBundle(it).userModel
        }
    }

    private val urls by lazy {
        arguments?.let {
            WallpaperPreviewFragmentArgs.fromBundle(it).urlsModel
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentWallpaperPreviewBinding =
            FragmentWallpaperPreviewBinding.inflate(inflater, container, false)
        return fragmentWallpaperPreviewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentWallpaperPreviewBinding.urls = urls

        Toast.makeText(context, userName, Toast.LENGTH_SHORT).show()

    }

}