package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentSearchBinding
import com.pratik.catchywall.presentation.adapters.SearchFragmentStateAdapter
import com.pratik.catchywall.presentation.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var fragmentSearchBinding: FragmentSearchBinding

//    private val searchViewModel by viewModels<SearchViewModel>()
    private val searchViewModel by activityViewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentSearchBinding = FragmentSearchBinding.inflate(
            inflater, container, false
        )
        return fragmentSearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSearchBinding.searchViewModel = searchViewModel

        fragmentSearchBinding.viewPagerSearch.adapter = SearchFragmentStateAdapter(this)

        TabLayoutMediator(
            fragmentSearchBinding.tabLayoutSearch, fragmentSearchBinding.viewPagerSearch
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = resources.getString(R.string.photos)
                }
                1 -> {
                    tab.text = resources.getString(R.string.user)
                }
                2 -> {
                    tab.text = resources.getString(R.string.collection)
                }
            }
        }.attach()

        searchViewModel.userSearchQuery.observe(viewLifecycleOwner) {
            Timber.d("USER QUERY $it")
        }

//        viewLifecycleOwner.lifecycleScope.launch {
//        }

    }

}