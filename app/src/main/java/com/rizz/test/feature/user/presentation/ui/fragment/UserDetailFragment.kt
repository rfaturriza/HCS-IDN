package com.rizz.test.feature.user.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import com.bumptech.glide.Glide
import com.rizz.test.R
import com.rizz.test.core.network.Status
import com.rizz.test.core.presentation.BaseFragment
import com.rizz.test.databinding.FragmentUserDetailBinding
import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser
import com.rizz.test.feature.user.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment() {
    private val viewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentUserDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = getString(R.string.user_detail)
        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        viewModel.getSelectedUser().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    showLoading()
                    binding.llUserDetail.visibility = View.GONE
                }
                Status.ERROR -> {
                    it.message
                    dismissLoading()
                }

                Status.SUCCESS -> {
                    dismissLoading()
                    binding.llUserDetail.visibility = View.VISIBLE
                    it.data?.let { data ->
                        initView(data)
                    }
                }
            }
        }

        viewModel.requestUser()

    }

    private fun initView(githubUser: DetailGithubUser) = binding.apply {
        Glide.with(requireContext())
            .load(githubUser.avatarUrl)
            .into(ivAvatar)
        tvUserName.text = githubUser.login
        tvName.text = githubUser.name
        tvCompany.text = githubUser.company
        tvLocation.text = githubUser.location
        tvEmail.text = githubUser.email
        tvBio.text = githubUser.bio
        tvPublicGists.text = getString(R.string.public_gists, githubUser.publicGists.toString())
        tvPublicRepos.text = getString(R.string.public_repos, githubUser.publicRepos.toString())
        tvFollowers.text = getString(R.string.followers, githubUser.followers.toString())
        tvFollowing.text = getString(R.string.following, githubUser.following.toString())
    }
}
