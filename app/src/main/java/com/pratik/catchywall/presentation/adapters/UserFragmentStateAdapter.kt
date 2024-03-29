package com.pratik.catchywall.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pratik.catchywall.presentation.fragments.UserProfileCollectionsFragment
import com.pratik.catchywall.presentation.fragments.UserProfileLikesFragment
import com.pratik.catchywall.presentation.fragments.UserProfilePhotosFragment

class UserFragmentStateAdapter(fragment: Fragment, private val username: String?) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UserProfilePhotosFragment().newInstance(username)
            1 -> UserProfileLikesFragment().newInstance(username)
            2 -> UserProfileCollectionsFragment().newInstance(username)
            else -> UserProfilePhotosFragment().newInstance(username)
        }
    }

}