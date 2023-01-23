package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentSearchBinding
import com.pratik.catchywall.presentation.adapters.SearchFragmentStateAdapter

class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var fragmentSearchBinding: FragmentSearchBinding

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

        fragmentSearchBinding.viewPagerSearch.adapter = SearchFragmentStateAdapter(this, "")

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

    }

}