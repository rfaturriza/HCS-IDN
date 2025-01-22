package com.rizz.test.feature.user.data.model

import org.junit.Test

import org.junit.Assert.*
class GithubUserTest {

    @Test
    fun `GithubUser properties are correctly assigned`() {
        val user = GithubUser(
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

        assertEquals("1", user.id)
        assertEquals("testuser", user.login)
        assertEquals("https://avatar.url", user.avatarUrl)
        assertEquals("https://url", user.url)
        assertEquals("https://html.url", user.htmlUrl)
        assertEquals("https://followers.url", user.followersUrl)
        assertEquals("https://following.url", user.followingUrl)
        assertEquals("https://gists.url", user.gistsUrl)
        assertEquals("https://starred.url", user.starredUrl)
        assertEquals("https://subscriptions.url", user.subscriptionsUrl)
        assertEquals("https://organizations.url", user.organizationsUrl)
        assertEquals("https://repos.url", user.reposUrl)
        assertEquals("https://events.url", user.eventsUrl)
        assertEquals("https://receivedevents.url", user.receivedEventsUrl)
        assertEquals("User", user.type)
        assertFalse(user.siteAdmin)
    }

    @Test
    fun `GithubUser properties are correctly updated`() {
        val user = GithubUser(
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

        user.login = "updateduser"
        user.avatarUrl = "https://updated.avatar.url"
        user.siteAdmin = true

        assertEquals("updateduser", user.login)
        assertEquals("https://updated.avatar.url", user.avatarUrl)
        assertTrue(user.siteAdmin)
    }
}