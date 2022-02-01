package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    lateinit var fragmentUserProfileBinding: FragmentUserProfileBinding

    private val userProfileModel by lazy {
        arguments?.get("userModel")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentUserProfileBinding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return fragmentUserProfileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Toast.makeText(activity,"$userProfileModel?")

    }
}