package com.rizz.test.feature.user.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_users")
data class GithubUser(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    var avatarUrl: String,
)