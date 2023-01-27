package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentWallpaperPreviewBinding
import com.pratik.catchywall.presentation.adapters.TagChipAdapter
import com.pratik.catchywall.presentation.callbacks.ChipTagClickListener
import com.pratik.catchywall.presentation.viewmodels.PhotoViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WallpaperPreviewFragment : Fragment(R.layout.fragment_wallpaper_preview),
    ChipTagClickListener {

    private lateinit var fragmentWallpaperPreviewBinding: FragmentWallpaperPreviewBinding
    private val photoViewModel by viewModels<PhotoViewModel>()
    lateinit var tagChipAdapter: TagChipAdapter

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

        fragmentWallpaperPreviewBinding.recyclerViewTag.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )
            tagChipAdapter = TagChipAdapter(this@WallpaperPreviewFragment)
            adapter = tagChipAdapter
        }

        setUpObserver()
    }

    private fun setUpObserver() {
        photoViewModel.run {
            photoDetail.observe(viewLifecycleOwner) {
                Timber.d("Photo View $it")
                tagChipAdapter.differ.submitList(it.tags)
            }
        }
    }

    fun onDownloadClick() {
        // TODO: download image from here
    }

    fun onLikeUnlikeClick() {
        // TODO: Like Unlike Click Listener
    }

    override fun chipTagClick(chipName: String) {
        Toast.makeText(context, chipName, Toast.LENGTH_SHORT).show()

        findNavController().navigate(
            WallpaperPreviewFragmentDirections.actionWallpaperPreviewFragmentToSearchFragment(chipName)
        )
    }

}