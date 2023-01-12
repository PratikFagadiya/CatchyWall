package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentCollectionWallpaperListBinding
import com.pratik.catchywall.presentation.adapters.CollectionWallpaperListAdapter
import com.pratik.catchywall.presentation.viewmodels.CollectionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CollectionWallpaperListFragment : Fragment(R.layout.fragment_collection_wallpaper_list) {

    private lateinit var fragmentCollectionWallpaperListBinding: FragmentCollectionWallpaperListBinding

    private val collectionViewModel by viewModels<CollectionViewModel>()
    private lateinit var collectionWallpaperListAdapter: CollectionWallpaperListAdapter

    private val collectionId by lazy {
        arguments?.let {
            CollectionWallpaperListFragmentArgs.fromBundle(it).collectionId
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentCollectionWallpaperListBinding =
            FragmentCollectionWallpaperListBinding.inflate(inflater, container, false)
        return fragmentCollectionWallpaperListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("MYCOLLECTIONIDS", "onViewCreated: $collectionId")

        fragmentCollectionWallpaperListBinding.rvCollectionWallpaper.apply {
            layoutManager = LinearLayoutManager(context)
            collectionWallpaperListAdapter = CollectionWallpaperListAdapter()
            adapter = collectionWallpaperListAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            collectionViewModel.getCollectionWallpaperList(collectionId!!)
                .collectLatest { collectionWallpaperList ->
                    collectionWallpaperListAdapter.submitData(collectionWallpaperList)
                }
        }
    }

}