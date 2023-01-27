package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentWallpaperPreviewBinding
import com.pratik.catchywall.presentation.viewmodels.PhotoViewModel
import dagger.hilt.android.AndroidEntryPoint
import hilt_aggregated_deps._com_pratik_catchywall_presentation_viewmodels_HomeViewModel_HiltModules_BindsModule
import timber.log.Timber

@AndroidEntryPoint
class WallpaperPreviewFragment : Fragment(R.layout.fragment_wallpaper_preview) {

    private lateinit var fragmentWallpaperPreviewBinding: FragmentWallpaperPreviewBinding
    private val photoViewModel by viewModels<PhotoViewModel>()

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
        fragmentWallpaperPreviewBinding.lifecycleOwner = this
        fragmentWallpaperPreviewBinding.fragment = this
        fragmentWallpaperPreviewBinding.urls = urls
        fragmentWallpaperPreviewBinding.user = userModel
        fragmentWallpaperPreviewBinding.viewmodel = photoViewModel

        photoViewModel.getPhotoDetail(id.toString())

        setUpObserver()
    }

    private fun setUpObserver() {
        photoViewModel.run {
            photoDetail.observe(viewLifecycleOwner) {
                Timber.d("Photo View $it")
            }
        }
    }

    fun onDownloadClick() {
        // TODO: download image from here
    }

    fun onLikeUnlikeClick() {
        // TODO: Like Unlike Click Listener
    }

}