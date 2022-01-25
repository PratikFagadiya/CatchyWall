package com.pratik.catchywall.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentHomeBinding
import com.pratik.catchywall.presentation.adapters.HomeListAdapter
import com.pratik.catchywall.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var fragmentHomeBinding: FragmentHomeBinding

    private val homeViewModel by viewModels<HomeViewModel>()

    lateinit var homeListAdapter: HomeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomeBinding.rvHomePics.apply {
            layoutManager = LinearLayoutManager(requireContext())
//            layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            homeListAdapter = HomeListAdapter()
            adapter = homeListAdapter
        }

        homeViewModel.homePicList.observe(viewLifecycleOwner, { homePicList ->
            homeListAdapter.submitData(viewLifecycleOwner.lifecycle, homePicList)
        })
    }

}