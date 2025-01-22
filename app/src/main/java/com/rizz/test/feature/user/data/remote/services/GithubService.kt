package com.rizz.test.feature.user.data.remote.services

import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser
import com.rizz.test.feature.user.data.model.SearchGithubUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("/${GithubEndPoints.USERS}")
    suspend fun getUsers(): Response<List<GithubUser>>

    @GET("/${GithubEndPoints.USERS}/{username}")
    suspend fun getUser(@Path("username") username: String): Response<DetailGithubUser>

    @GET("/${GithubEndPoints.SEARCH_USERS}")
    suspend fun searchUsers(
        @Query("q") query: String
    ): Response<SearchGithubUser>
}