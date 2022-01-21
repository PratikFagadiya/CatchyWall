package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentCollectionBinding
import com.pratik.catchywall.presentation.viewmodels.CollectionViewModel

class CollectionFragment : Fragment(R.layout.fragment_collection) {

    private var fragmentCollectionBinding: FragmentCollectionBinding? = null

    lateinit var collectionViewModel: CollectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCollectionBinding = FragmentCollectionBinding.inflate(inflater, container, false)

        return fragmentCollectionBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectionViewModel = ViewModelProvider(this)[CollectionViewModel::class.java]

        collectionViewModel.collectionList.observe(viewLifecycleOwner) { collectionList ->

            Log.i("TAG", "onViewCreated: $collectionList")

        }
    }
}