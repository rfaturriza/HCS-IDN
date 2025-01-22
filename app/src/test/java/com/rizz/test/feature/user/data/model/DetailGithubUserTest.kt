package com.rizz.test.feature.user.data.model

import org.junit.Test

import org.junit.Assert.*
class DetailGithubUserTest {

    @Test
    fun `DetailGithubUser properties are correctly assigned`() {
        val user = DetailGithubUser(
            id = "1",
            login = "testuser",
            avatarUrl = "https://avatar.url",
            name = "Test User",
            company = "Test Company",
            blog = "https://blog.url",
            location = "Test Location",
            email = "test@example.com",
            hireable = true,
            bio = "Test Bio",
            twitterUsername = "testuser",
            publicRepos = 10,
            publicGists = 5,
            followers = 100,
            following = 50,
            createdAt = "2023-01-01T00:00:00Z",
            updatedAt = "2023-01-02T00:00:00Z"
        )

        assertEquals("1", user.id)
        assertEquals("testuser", user.login)
        assertEquals("https://avatar.url", user.avatarUrl)
        assertEquals("Test User", user.name)
        assertEquals("Test Company", user.company)
        assertEquals("https://blog.url", user.blog)
        assertEquals("Test Location", user.location)
        assertEquals("test@example.com", user.email)
        assertTrue(user.hireable!!)
        assertEquals("Test Bio", user.bio)
        assertEquals("testuser", user.twitterUsername)
        assertEquals(10, user.publicRepos)
        assertEquals(5, user.publicGists)
        assertEquals(100, user.followers)
        assertEquals(50, user.following)
        assertEquals("2023-01-01T00:00:00Z", user.createdAt)
        assertEquals("2023-01-02T00:00:00Z", user.updatedAt)
    }

    @Test
    fun `DetailGithubUser properties are correctly updated`() {
        val user = DetailGithubUser(
            id = "1",
            login = "testuser",
            avatarUrl = "https://avatar.url",
            name = "Test User",
            company = "Test Company",
            blog = "https://blog.url",
            location = "Test Location",
            email = "test@example.com",
            hireable = true,
            bio = "Test Bio",
            twitterUsername = "testuser",
            publicRepos = 10,
            publicGists = 5,
            followers = 100,
            following = 50,
            createdAt = "2023-01-01T00:00:00Z",
            updatedAt = "2023-01-02T00:00:00Z"
        )

        user.login = "updateduser"
        user.avatarUrl = "https://updated.avatar.url"
        user.hireable = false

        assertEquals("updateduser", user.login)
        assertEquals("https://updated.avatar.url", user.avatarUrl)
        assertFalse(user.hireable!!)
    }

    @Test
    fun `DetailGithubUser handles null values correctly`() {
        val user = DetailGithubUser(
            id = "1",
            login = "testuser",
            avatarUrl = null,
            name = null,
            company = null,
            blog = null,
            location = null,
            email = null,
            hireable = null,
            bio = null,
            twitterUsername = null,
            publicRepos = null,
            publicGists = null,
            followers = null,
            following = null,
            createdAt = null,
            updatedAt = null
        )

        assertNull(user.avatarUrl)
        assertNull(user.name)
        assertNull(user.company)
        assertNull(user.blog)
        assertNull(user.location)
        assertNull(user.email)
        assertNull(user.hireable)
        assertNull(user.bio)
        assertNull(user.twitterUsername)
        assertNull(user.publicRepos)
        assertNull(user.publicGists)
        assertNull(user.followers)
        assertNull(user.following)
        assertNull(user.createdAt)
        assertNull(user.updatedAt)
    }
}