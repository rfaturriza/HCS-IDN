package com.rizz.test.feature.user.data.model

import com.google.gson.annotations.SerializedName

data class SearchGithubUser(
    @SerializedName("items")
    val items: List<GithubUser>,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean
)