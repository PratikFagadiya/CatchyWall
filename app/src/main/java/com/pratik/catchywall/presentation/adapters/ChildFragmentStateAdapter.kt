package com.pratik.catchywall.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pratik.catchywall.presentation.fragments.CollectionFragment
import com.pratik.catchywall.presentation.fragments.HomeFragment

class ChildFragmentStateAdapter(fragment: Fragment) :

    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CollectionFragment()
            else -> HomeFragment()
        }
    }

}