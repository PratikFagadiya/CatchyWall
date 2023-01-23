package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.data.model.Urls
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.databinding.FragmentHomeBinding
import com.pratik.catchywall.presentation.adapters.HomeListAdapter
import com.pratik.catchywall.presentation.callbacks.HomeWallpaperClickListener
import com.pratik.catchywall.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), HomeWallpaperClickListener {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

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
            homeListAdapter = HomeListAdapter(this@HomeFragment)
            adapter = homeListAdapter
        }

            viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.homePicList.collectLatest { homePicList ->
                homeListAdapter.submitData(homePicList)
            }
        }

    }

    override fun homeWallpaperClick(
        urls: Urls,
        user: User,
        id: String,
        name: String
    ) {
        findNavController().navigate(
            MainHostFragmentDirections.actionMainHostFragmentToWallpaperPreviewFragment(
                urls,
                user,
                id,
                name
            )
        )
    }

}