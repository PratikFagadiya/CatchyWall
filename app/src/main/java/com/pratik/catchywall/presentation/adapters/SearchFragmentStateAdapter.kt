package com.pratik.catchywall.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pratik.catchywall.presentation.fragments.*

class SearchFragmentStateAdapter(fragment: Fragment, private val username: String?) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SearchPhotosFragment()
            1 -> SearchUserFragment()
            2 -> SearchCollectionFragment()
            else -> SearchPhotosFragment()
        }
    }

}