package com.rizz.test.feature.user.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizz.test.databinding.RowUserBinding
import com.rizz.test.feature.user.data.model.GithubUser

class UserRecyclerViewAdapter(private val githubUsers: List<GithubUser>): RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder>() {

    private var onCustomerClickListener : ( (githubUser: GithubUser) -> Unit )? = null

    fun setOnCustomerClickListener( onCustomerClickListener: ((githubUser: GithubUser)->Unit)): UserRecyclerViewAdapter{
        this.onCustomerClickListener = onCustomerClickListener
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return githubUsers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(githubUsers[position])
    }

    inner class ViewHolder(private val binding: RowUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(githubUser: GithubUser){
            binding.tvUserName.text = githubUser.login
            Glide.with(binding.root.context)
                .load(githubUser.avatarUrl)
                .into(binding.ivUser)
            binding.root.setOnClickListener {
                onCustomerClickListener?.invoke(githubUser)
            }
        }
    }
}