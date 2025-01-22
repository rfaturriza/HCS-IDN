package com.rizz.test.feature.user.data.remote.source

import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser
import com.rizz.test.feature.user.data.remote.services.GithubService
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class GithubRemoteDataSourceImpl @Inject constructor(
    private val service: GithubService,
) : GithubRemoteDataSource {
    override suspend fun requestUsers(): List<GithubUser> {
        try {
            val response = service.getUsers()
            return withContext(coroutineContext) {
                response.body() ?: emptyList()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun requestUser(username: String): DetailGithubUser? {
        try {
            val response = service.getUser(username)
            return withContext(coroutineContext) {
                response.body()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun searchUsers(
        query: String
    ): List<GithubUser> {
        try {
            val response = service.searchUsers(
                query
            )
            return withContext(coroutineContext) {
                response.body()?.items ?: emptyList()
            }
        } catch (e: Exception) {
            throw e
        }
    }
}