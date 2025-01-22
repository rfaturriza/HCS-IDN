package com.rizz.test.feature.user.data.local

import com.rizz.test.core.persistence.DatabaseClient
import com.rizz.test.feature.user.data.model.GithubUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(): UserLocalDataSource {

    override suspend fun saveUser(githubUser: GithubUser)  = withContext(Dispatchers.IO){
        DatabaseClient.getInstance()
            .appDatabase
            .userDao()
            .update(githubUser)
    }

    override suspend fun requestUsers() = withContext(Dispatchers.IO){
        DatabaseClient.getInstance()
            .appDatabase
            .userDao().getUsers()
    }


    override suspend fun saveUsers(githubUsers: Array<GithubUser>) = withContext(Dispatchers.IO){
        DatabaseClient.getInstance()
            .appDatabase
            .userDao().insertAll(githubUsers)
    }

}