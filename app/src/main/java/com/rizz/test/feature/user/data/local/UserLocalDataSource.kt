package com.rizz.test.feature.user.data.local

import com.rizz.test.feature.user.data.model.GithubUser

interface UserLocalDataSource {

    suspend fun requestUsers(): List<GithubUser>
    suspend fun saveUsers(githubUsers: Array<GithubUser>)
    suspend fun saveUser(githubUser: GithubUser)

}