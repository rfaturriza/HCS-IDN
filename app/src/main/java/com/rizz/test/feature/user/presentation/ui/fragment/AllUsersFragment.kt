package com.rizz.test.feature.user.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizz.test.R
import com.rizz.test.core.network.Status
import com.rizz.test.core.presentation.BaseFragment
import com.rizz.test.databinding.FragmentAllUsersBinding
import com.rizz.test.feature.user.data.model.GithubUser
import com.rizz.test.feature.user.presentation.ui.adapter.UserRecyclerViewAdapter
import com.rizz.test.feature.user.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllUsersFragment : BaseFragment() {
    private val viewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentAllUsersBinding
    private lateinit var adapter: UserRecyclerViewAdapter
    private var allUsers: List<GithubUser> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUsers().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> showLoading()
                Status.ERROR -> {
                    it.message
                    dismissLoading()
                }
                Status.SUCCESS -> {
                    dismissLoading()
                    it.data?.let { data ->
                        allUsers = data
                        drawUsersList(data)
                    }
                }
            }
        }

        viewModel.requestUsers()

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.searchUsers(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun drawUsersList(data: List<GithubUser>) = with(binding) {
        rvCustomers.layoutManager = LinearLayoutManager(context)
        adapter = UserRecyclerViewAdapter(data)
            .setOnCustomerClickListener {
                onUserSelected(it)
            }
        rvCustomers.adapter = adapter
    }

    private fun onUserSelected(selectedGithubUser: GithubUser) {
        viewModel.setSelectedUser(selectedGithubUser)
        view?.let { Navigation.findNavController(it).navigate(R.id.action_allCustomersFragment_to_customerDetailFragment) }
    }
}