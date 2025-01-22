package com.rizz.test.feature.user.data.remote.source

import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser

interface GithubRemoteDataSource {
    suspend fun requestUsers(): List<GithubUser>
    suspend fun requestUser(username: String): DetailGithubUser?
    suspend fun searchUsers(
        query: String
    ): List<GithubUser>
}