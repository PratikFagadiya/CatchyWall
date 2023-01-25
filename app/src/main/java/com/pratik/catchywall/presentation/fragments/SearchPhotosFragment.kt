package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.data.model.Urls
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.databinding.FragmentSearchPhotosBinding
import com.pratik.catchywall.presentation.adapters.SinglePhotoListAdapter
import com.pratik.catchywall.presentation.callbacks.SinglePhotoWallpaperClickListener
import com.pratik.catchywall.presentation.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class SearchPhotosFragment : Fragment(R.layout.fragment_search_photos),
    SinglePhotoWallpaperClickListener {

    lateinit var fragmentSearchPhotosBinding: FragmentSearchPhotosBinding
    private val searchViewModel by activityViewModels<SearchViewModel>()
    private lateinit var singlePhotoListAdapter: SinglePhotoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSearchPhotosBinding =
            FragmentSearchPhotosBinding.inflate(inflater, container, false)
        return fragmentSearchPhotosBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSearchPhotosBinding.rvSearchPhotoPics.apply {
            layoutManager = LinearLayoutManager(requireContext())
            singlePhotoListAdapter = SinglePhotoListAdapter(this@SearchPhotosFragment)
            adapter = singlePhotoListAdapter
        }

        searchViewModel.userSearchQuery.observe(viewLifecycleOwner) {
            it?.let { query ->
                lifecycleScope.launch {
                    searchViewModel.searchPhotoList(query).collectLatest { photoList ->
                        Timber.d("photoList $photoList")
                        singlePhotoListAdapter.submitData(photoList)
                    }
                }
            }
        }

    }

    override fun homeWallpaperClick(urls: Urls, user: User, id: String, name: String) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToWallpaperPreviewFragment(
                urls,
                user,
                id,
                name
            )
        )

    }
}