package com.pratik.catchywall.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.catchywall.R
import com.pratik.catchywall.data.model.User
import com.pratik.catchywall.databinding.FragmentSearchUserBinding
import com.pratik.catchywall.presentation.adapters.UserListAdapter
import com.pratik.catchywall.presentation.callbacks.CollectionItemUserClickListener
import com.pratik.catchywall.presentation.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class SearchUserFragment : Fragment(R.layout.fragment_search_user),
    CollectionItemUserClickListener {

    lateinit var fragmentSearchUserBinding: FragmentSearchUserBinding

    private val searchViewModel by activityViewModels<SearchViewModel>()
    lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentSearchUserBinding = FragmentSearchUserBinding.inflate(inflater, container, false)
        return fragmentSearchUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSearchUserBinding.rvSearchUser.apply {
            userListAdapter = UserListAdapter(this@SearchUserFragment)
            layoutManager = LinearLayoutManager(context)
            adapter = userListAdapter
        }

        searchViewModel.userSearchQuery.observe(viewLifecycleOwner) {
            it?.let { query ->
                lifecycleScope.launch {
                    searchViewModel.searchUserList(query).collectLatest { userList ->
                        Timber.d("USerList $userList")
                        userListAdapter.submitData(userList)
                    }
                }
            }
        }

    }

    override fun collectionItemUserClick(userModel: User) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToUserProfileFragment2(
                userModel
            )
        )
    }




}