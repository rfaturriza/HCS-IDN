package com.rizz.test.feature.user.data.repository

import androidx.lifecycle.liveData
import com.rizz.test.core.network.Result
import com.rizz.test.feature.user.data.local.UserLocalDataSource
import com.rizz.test.feature.user.data.remote.source.GithubRemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) :
    UserRepository {

    override suspend fun requestUsers() = liveData {
        emit(Result.loading())
        try {

//            var response = localDataSource.requestUsers()

//            if (response.isEmpty()) {
            val response = remoteDataSource.requestUsers()
//                localDataSource.saveUsers(response.toTypedArray())
//            }

            emit(Result.success(response))

        } catch (exception: Exception) {
            emit(Result.error(exception.message ?: ""))
        }
    }

    override suspend fun requestUser(username: String) = liveData {
        emit(Result.loading())
        try {
            val response = remoteDataSource.requestUser(username)
            emit(Result.success(response))

        } catch (exception: Exception) {
            emit(Result.error(exception.message ?: ""))
        }
    }

    override suspend fun searchUsers(
        query: String
    ) = liveData {
        emit(Result.loading())
        try {
            val response = remoteDataSource.searchUsers(query)
            emit(Result.success(response))

        } catch (exception: Exception) {
            emit(Result.error(exception.message ?: ""))
        }
    }
}