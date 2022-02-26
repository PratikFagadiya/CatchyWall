package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentUserProfileBinding
import com.pratik.catchywall.presentation.adapters.UserFragmentStateAdapter
import android.content.Intent
import android.net.Uri

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    lateinit var fragmentUserProfileBinding: FragmentUserProfileBinding

    private val userProfileModel by lazy {
        arguments?.let {
            UserProfileFragmentArgs.fromBundle(it).userProfileMode
        }
    }

    override
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentUserProfileBinding = FragmentUserProfileBinding.inflate(inflater, container, false)
        fragmentUserProfileBinding.fragment = this
        return fragmentUserProfileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentUserProfileBinding.userDetail = userProfileModel

        fragmentUserProfileBinding.viewPager.adapter =
            UserFragmentStateAdapter(this, fragmentUserProfileBinding.userDetail?.username)

        TabLayoutMediator(
            fragmentUserProfileBinding.tabLayout, fragmentUserProfileBinding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Photos"
                1 -> tab.text = "Likes"
                2 -> tab.text = "Collections"
            }
        }.attach()

    }

    fun onWebProfileClick(profileUrl: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(profileUrl))
        startActivity(browserIntent)
    }

}