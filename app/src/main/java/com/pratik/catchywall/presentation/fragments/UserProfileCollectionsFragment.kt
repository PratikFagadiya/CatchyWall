package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentUserProfileCollectionsBinding

class UserProfileCollectionsFragment : Fragment(R.layout.fragment_user_profile_collections) {

    lateinit var fragmentUserProfileCollectionsBinding: FragmentUserProfileCollectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentUserProfileCollectionsBinding =
            FragmentUserProfileCollectionsBinding.inflate(inflater, container, false)
        return fragmentUserProfileCollectionsBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}