package com.rizz.test.feature.user.data.model

import org.junit.Test

import org.junit.Assert.*
class SearchGithubUserTest {

    @Test
    fun `SearchGithubUser properties are correctly assigned`() {
        val githubUser = GithubUser(
            id = "1",
            login = "testuser",
            avatarUrl = "https://avatar.url",
            url = "https://url",
            htmlUrl = "https://html.url",
            followersUrl = "https://followers.url",
            followingUrl = "https://following.url",
            gistsUrl = "https://gists.url",
            starredUrl = "https://starred.url",
            subscriptionsUrl = "https://subscriptions.url",
            organizationsUrl = "https://organizations.url",
            reposUrl = "https://repos.url",
            eventsUrl = "https://events.url",
            receivedEventsUrl = "https://receivedevents.url",
            type = "User",
            siteAdmin = false
        )

        val searchGithubUser = SearchGithubUser(
            items = listOf(githubUser),
            totalCount = 1,
            incompleteResults = false
        )

        assertEquals(1, searchGithubUser.totalCount)
        assertFalse(searchGithubUser.incompleteResults)
        assertEquals(1, searchGithubUser.items.size)
        assertEquals("testuser", searchGithubUser.items[0].login)
    }

    @Test
    fun `SearchGithubUser handles empty items list correctly`() {
        val searchGithubUser = SearchGithubUser(
            items = emptyList(),
            totalCount = 0,
            incompleteResults = false
        )

        assertEquals(0, searchGithubUser.totalCount)
        assertFalse(searchGithubUser.incompleteResults)
        assertTrue(searchGithubUser.items.isEmpty())
    }

    @Test
    fun `SearchGithubUser handles incomplete results correctly`() {
        val searchGithubUser = SearchGithubUser(
            items = emptyList(),
            totalCount = 0,
            incompleteResults = true
        )

        assertEquals(0, searchGithubUser.totalCount)
        assertTrue(searchGithubUser.incompleteResults)
        assertTrue(searchGithubUser.items.isEmpty())
    }
}