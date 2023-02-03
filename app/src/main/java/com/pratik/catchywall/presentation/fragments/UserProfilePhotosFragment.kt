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
import com.pratik.catchywall.databinding.FragmentUserProfilePhotosBinding
import com.pratik.catchywall.presentation.adapters.UserProfilePhotosListAdapter
import com.pratik.catchywall.presentation.callbacks.SinglePhotoWallpaperClickListener
import com.pratik.catchywall.presentation.viewmodels.UserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserProfilePhotosFragment : Fragment(R.layout.fragment_user_profile_photos),
    SinglePhotoWallpaperClickListener {

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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentUserProfilePhotosBinding =
            FragmentUserProfilePhotosBinding.inflate(inflater, container, false)
        return fragmentUserProfilePhotosBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentUserProfilePhotosBinding.rvUserProfilePhotos.apply {
            layoutManager = LinearLayoutManager(context)
            userProfilePhotosListAdapter =
                UserProfilePhotosListAdapter(this@UserProfilePhotosFragment)
            adapter = userProfilePhotosListAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            userProfileViewModel.getUserProfilePhotosList(userName!!)
                .collectLatest { userProfilePhotosList ->
                    userProfilePhotosListAdapter.submitData(userProfilePhotosList)
                }
        }
    }

    override fun homeWallpaperClick(urls: Urls, user: User, id: String) {
        findNavController().navigate(
            UserProfileFragmentDirections.actionUserProfileFragment2ToWallpaperPreviewFragment(
                urls, user, id
            )
        )
    }
}