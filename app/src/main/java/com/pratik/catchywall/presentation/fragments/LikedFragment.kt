package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentLikedBinding

class LikedFragment : Fragment(R.layout.fragment_liked) {

    lateinit var fragmentLikedBinding: FragmentLikedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentLikedBinding = FragmentLikedBinding.inflate(inflater, container, false)
        return fragmentLikedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}