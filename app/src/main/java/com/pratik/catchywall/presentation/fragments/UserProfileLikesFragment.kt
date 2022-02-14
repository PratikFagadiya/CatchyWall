package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.databinding.FragmentUserProfileLikesBinding
import com.pratik.catchywall.presentation.adapters.UserProfileLikesListAdapter
import com.pratik.catchywall.presentation.viewmodels.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileLikesFragment : Fragment(R.layout.fragment_user_profile_likes) {

    lateinit var fragmentUserProfileLikesBinding: FragmentUserProfileLikesBinding
    private val userProfileViewModel by viewModels<UserProfileViewModel>()

    lateinit var userProfileLikesListAdapter: UserProfileLikesListAdapter

    fun newInstance(username: String?): UserProfileLikesFragment {
        val args = Bundle()
        val fragment = UserProfileLikesFragment()
        args.putString("username", username)
        fragment.arguments = args
        return fragment
    }

    private val userName by lazy {
        arguments?.getString("username")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentUserProfileLikesBinding =
            FragmentUserProfileLikesBinding.inflate(inflater, container, false)
        return fragmentUserProfileLikesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentUserProfileLikesBinding.rvUserProfileLikes.apply {
            layoutManager = LinearLayoutManager(context)
            userProfileLikesListAdapter = UserProfileLikesListAdapter()
            adapter = userProfileLikesListAdapter
        }

        userProfileViewModel.getUserProfileLikesList(userName!!).observe(viewLifecycleOwner,
            { userProfileLikesList ->
                userProfileLikesListAdapter.submitData(
                    viewLifecycleOwner.lifecycle,
                    userProfileLikesList
                )
            })

    }
}