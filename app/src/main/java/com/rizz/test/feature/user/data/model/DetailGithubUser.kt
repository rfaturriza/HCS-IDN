package com.rizz.test.feature.user.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail_github_user")
data class DetailGithubUser(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    var avatarUrl: String?,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "company")
    var company: String?,
    @ColumnInfo(name = "blog")
    var blog: String?,
    @ColumnInfo(name = "location")
    var location: String?,
    @ColumnInfo(name = "email")
    var email: String?,
    @ColumnInfo(name = "hireable")
    var hireable: Boolean?,
    @ColumnInfo(name = "bio")
    var bio: String?,
    @ColumnInfo(name = "twitter_username")
    @SerializedName("twitter_username")
    var twitterUsername: String?,
    @ColumnInfo(name = "public_repos")
    @SerializedName("public_repos")
    var publicRepos: Int?,
    @ColumnInfo(name = "public_gists")
    @SerializedName("public_gists")
    var publicGists: Int?,
    @ColumnInfo(name = "followers")
    var followers: Int?,
    @ColumnInfo(name = "following")
    var following: Int?,
    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    var createdAt: String?,
    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    var updatedAt: String?,
)