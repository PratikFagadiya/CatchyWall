package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentSearchCollectionBinding
import com.pratik.catchywall.presentation.adapters.SearchCollectionListAdapter
import com.pratik.catchywall.presentation.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class SearchCollectionFragment : Fragment(R.layout.fragment_search_collection) {

    lateinit var fragmentSearchCollectionBinding: FragmentSearchCollectionBinding
    val searchViewModel by activityViewModels<SearchViewModel>()
    lateinit var searchCollectionListAdapter: SearchCollectionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSearchCollectionBinding =
            FragmentSearchCollectionBinding.inflate(inflater, container, false)
        return fragmentSearchCollectionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSearchCollectionBinding.rvSearchCollection.apply {
            layoutManager = LinearLayoutManager(context)
            searchCollectionListAdapter = SearchCollectionListAdapter()
            adapter = searchCollectionListAdapter
        }

        searchViewModel.userSearchQuery.observe(viewLifecycleOwner) {
            it?.let { query ->
                lifecycleScope.launch {

                    searchViewModel.searchCollectionList(query).collectLatest { collectionList ->
                        Timber.d("Search Data $collectionList")
                        searchCollectionListAdapter.submitData(collectionList)
                    }
                }
            }
        }
    }

}