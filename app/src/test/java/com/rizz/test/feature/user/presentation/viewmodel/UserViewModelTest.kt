package com.rizz.test.feature.user.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rizz.test.core.network.Result
import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser
import com.rizz.test.feature.user.domain.UserUseCase
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UserViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var useCase: UserUseCase
    private lateinit var viewModel: UserViewModel
    private lateinit var usersObserver: Observer<Result<List<GithubUser>>>
    private lateinit var userObserver: Observer<Result<DetailGithubUser>>

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        useCase = mockk()
        viewModel = UserViewModel(useCase)
        usersObserver = mockk(relaxed = true)
        userObserver = mockk(relaxed = true)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `requestUsers updates allUsersLiveData with success result`() = runTest {
        val users = listOf(GithubUser("1", "testuser", "https://avatar.url", "https://url", "https://html.url", "https://followers.url", "https://following.url", "https://gists.url", "https://starred.url", "https://subscriptions.url", "https://organizations.url", "https://repos.url", "https://events.url", "https://receivedevents.url", "User", false))
        val result = MutableLiveData<Result<List<GithubUser>>>().apply { value = Result.success(users) }
        coEvery { useCase.requestUsers() } returns result

        viewModel.getUsers().observeForever(usersObserver)
        viewModel.requestUsers()

        verify { result.value?.let { usersObserver.onChanged(it) } }
    }

    @Test
    fun `requestUser updates selectedUserLiveData with success result`() = runTest {
        val user = DetailGithubUser("1", "testuser", "https://avatar.url", "Test User", "Test Company", "https://blog.url", "Test Location", "test@example.com", true, "Test Bio", "testuser", 10, 5, 100, 50, "2023-01-01T00:00:00Z", "2023-01-02T00:00:00Z")
        val result = MutableLiveData<Result<DetailGithubUser>>().apply { value = Result.success(user) }
        coEvery { useCase.requestUser("testuser") } returns result

        viewModel.setSelectedUser(GithubUser("1", "testuser", "https://avatar.url", "https://url", "https://html.url", "https://followers.url", "https://following.url", "https://gists.url", "https://starred.url", "https://subscriptions.url", "https://organizations.url", "https://repos.url", "https://events.url", "https://receivedevents.url", "User", false))
        viewModel.getSelectedUser().observeForever(userObserver)
        viewModel.requestUser()

        verify { result.value?.let { userObserver.onChanged(it) } }
    }

    @Test
    fun `searchUsers updates allUsersLiveData with success result`() = runTest {
        val users = listOf(GithubUser("1", "testuser", "https://avatar.url", "https://url", "https://html.url", "https://followers.url", "https://following.url", "https://gists.url", "https://starred.url", "https://subscriptions.url", "https://organizations.url", "https://repos.url", "https://events.url", "https://receivedevents.url", "User", false))
        val result = MutableLiveData<Result<List<GithubUser>>>().apply { value = Result.success(users) }
        coEvery { useCase.searchUsers("test") } returns result

        viewModel.getUsers().observeForever(usersObserver)
        viewModel.searchUsers("test")

        verify { result.value?.let { usersObserver.onChanged(it) } }
    }
}