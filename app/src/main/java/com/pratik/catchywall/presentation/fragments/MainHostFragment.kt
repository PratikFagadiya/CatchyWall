package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentMainHostBinding
import com.pratik.catchywall.presentation.adapters.ChildFragmentStateAdapter

class MainHostFragment : Fragment(R.layout.fragment_main_host) {

    lateinit var fragmentMainHostBinding: FragmentMainHostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentMainHostBinding = FragmentMainHostBinding.inflate(inflater, container, false)
        return fragmentMainHostBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentMainHostBinding.viewPager.adapter = ChildFragmentStateAdapter(this)

        TabLayoutMediator(
            fragmentMainHostBinding.tabLayout, fragmentMainHostBinding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Collection"
            }
        }.attach()

        fragmentMainHostBinding.floatingSearch.setOnClickListener {
            findNavController().navigate(
                MainHostFragmentDirections.actionMainHostFragmentToSearchFragment("")
            )
        }

        fragmentMainHostBinding.imgLikes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainHostFragment_to_likedFragment)
        }

        fragmentMainHostBinding.imgMenu.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_mainHostFragment_to_mainMenuBottomSheetDialog)
        }
    }

}