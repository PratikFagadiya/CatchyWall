package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentUserProfilePhotosBinding
import com.pratik.catchywall.presentation.adapters.UserProfilePhotosListAdapter
import com.pratik.catchywall.presentation.viewmodels.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfilePhotosFragment : Fragment(R.layout.fragment_user_profile_photos) {

    private lateinit var fragmentUserProfilePhotosBinding: FragmentUserProfilePhotosBinding
    private val userProfileViewModel by viewModels<UserProfileViewModel>()

    lateinit var userProfilePhotosListAdapter: UserProfilePhotosListAdapter

    private val userName by lazy {
        arguments?.getString("username")
    }

    fun newInstance(username: String?): UserProfilePhotosFragment {
        val args = Bundle()
        val fragment = UserProfilePhotosFragment()
        args.putString("username", username)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentUserProfilePhotosBinding =
            FragmentUserProfilePhotosBinding.inflate(inflater, container, false)
        return fragmentUserProfilePhotosBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentUserProfilePhotosBinding.rvUserProfilePhotos.apply {
            layoutManager = LinearLayoutManager(context)
            userProfilePhotosListAdapter = UserProfilePhotosListAdapter()
            adapter = userProfilePhotosListAdapter
        }


        userProfileViewModel.getUserProfilePhotosList(userName!!)
            .observe(viewLifecycleOwner, { userProfilePhotosList ->
                userProfilePhotosListAdapter.submitData(
                    viewLifecycleOwner.lifecycle,
                    userProfilePhotosList
                )
            })
    }
}