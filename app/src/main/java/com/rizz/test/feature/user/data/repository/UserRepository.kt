package com.rizz.test.feature.user.data.repository

import androidx.lifecycle.LiveData
import com.rizz.test.core.network.Result
import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser

interface UserRepository {
    suspend fun requestUsers(): LiveData<Result<List<GithubUser>>>

    suspend fun requestUser(username: String): LiveData<Result<DetailGithubUser>>

    suspend fun searchUsers(
        query: String
    ): LiveData<Result<List<GithubUser>>>
}