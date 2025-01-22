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
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "html_url")
    var htmlUrl: String,
    @ColumnInfo(name = "followers_url")
    var followersUrl: String,
    @ColumnInfo(name = "following_url")
    var followingUrl: String,
    @ColumnInfo(name = "gists_url")
    var gistsUrl: String,
    @ColumnInfo(name = "starred_url")
    var starredUrl: String,
    @ColumnInfo(name = "subscriptions_url")
    var subscriptionsUrl: String,
    @ColumnInfo(name = "organizations_url")
    var organizationsUrl: String,
    @ColumnInfo(name = "repos_url")
    var reposUrl: String,
    @ColumnInfo(name = "events_url")
    var eventsUrl: String,
    @ColumnInfo(name = "received_events_url")
    var receivedEventsUrl: String,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "site_admin")
    var siteAdmin: Boolean
)