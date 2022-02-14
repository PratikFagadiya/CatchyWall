package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentUserProfileCollectionsBinding
import com.pratik.catchywall.presentation.adapters.UserProfileCollectionListAdapter
import com.pratik.catchywall.presentation.viewmodels.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileCollectionsFragment : Fragment(R.layout.fragment_user_profile_collections) {

    lateinit var fragmentUserProfileCollectionsBinding: FragmentUserProfileCollectionsBinding

    lateinit var userProfileCollectionListAdapter: UserProfileCollectionListAdapter

    private val userprofileViewModel by viewModels<UserProfileViewModel>()

    private val userName by lazy {
        arguments?.getString("username")
    }

    fun newInstance(username: String?): UserProfileCollectionsFragment {
        val args = Bundle()
        val fragment = UserProfileCollectionsFragment()
        args.putString("username", username)
        fragment.arguments = args
        return fragment
    }

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

        fragmentUserProfileCollectionsBinding.rvUserProfileCollections.apply {
            layoutManager = LinearLayoutManager(context)
            userProfileCollectionListAdapter = UserProfileCollectionListAdapter()
            adapter = userProfileCollectionListAdapter
        }

        // TODO: 14-02-2022 Complete this
        userprofileViewModel.getUserProfileCollectionsList(userName!!)
            .observe(viewLifecycleOwner, { userProfileCollectionList ->
                userProfileCollectionListAdapter.submitData(
                    viewLifecycleOwner.lifecycle,
                    userProfileCollectionList
                )
            })
    }

}