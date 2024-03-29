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
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.databinding.FragmentCollectionBinding
import com.pratik.catchywall.presentation.adapters.CollectionListAdapter
import com.pratik.catchywall.presentation.callbacks.CollectionItemUserClickListener
import com.pratik.catchywall.presentation.callbacks.CollectionWallpaperListClickListener
import com.pratik.catchywall.presentation.viewmodels.CollectionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CollectionFragment : Fragment(R.layout.fragment_collection), CollectionItemUserClickListener,
    CollectionWallpaperListClickListener {

    private lateinit var fragmentCollectionBinding: FragmentCollectionBinding
    private val collectionViewModel by viewModels<CollectionViewModel>()

    private lateinit var collectionListAdapter: CollectionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCollectionBinding = FragmentCollectionBinding.inflate(inflater, container, false)
        return fragmentCollectionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentCollectionBinding.rvCollectionList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            collectionListAdapter =
                CollectionListAdapter(this@CollectionFragment, this@CollectionFragment)
            adapter = collectionListAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            collectionViewModel.collectionList.collectLatest { collectionList ->
                collectionListAdapter.submitData(collectionList)
            }
        }

    }

    override fun collectionItemUserClick(userModel: User) {
        findNavController().navigate(
            MainHostFragmentDirections.actionMainHostFragmentToUserProfileFragment2(userModel)
        )
    }

    override fun collectionWallpaperListClick(collectionId: String) {
        findNavController().navigate(
            MainHostFragmentDirections.actionMainHostFragmentToCollectionWallpaperListFragment(
                collectionId
            )
        )
    }
}