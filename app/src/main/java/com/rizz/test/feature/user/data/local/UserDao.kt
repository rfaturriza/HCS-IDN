package com.rizz.test.feature.user.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rizz.test.feature.user.data.model.GithubUser

@Dao
interface UserDao {

    @Insert
    suspend fun insertAll(githubUsers: Array<GithubUser>)

    @Query("SELECT * from github_users")
    fun getUsers(): List<GithubUser>

    @Update
    fun update(githubUser: GithubUser)
}