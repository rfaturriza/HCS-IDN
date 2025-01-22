package com.rizz.test.feature.user.presentation.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizz.test.core.network.Result
import com.rizz.test.feature.user.data.model.DetailGithubUser
import com.rizz.test.feature.user.data.model.GithubUser
import com.rizz.test.feature.user.domain.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val useCase: UserUseCase) : ViewModel() {

    private val allUsersLiveData = MediatorLiveData<Result<List<GithubUser>>>()
    private val selectedUserLiveData = MediatorLiveData<Result<DetailGithubUser>>()
    private var selectedGithubUser: GithubUser? = null

    fun requestUsers() {
        viewModelScope.launch {
            allUsersLiveData.addSource(useCase.requestUsers()) {
                allUsersLiveData.value = it
            }
        }
    }

    fun requestUser() {
        viewModelScope.launch {
            selectedUserLiveData.addSource(useCase.requestUser(selectedGithubUser!!.login)) {
                selectedUserLiveData.value = it
            }
        }
    }

    fun searchUsers(query: String) {
        viewModelScope.launch {
            allUsersLiveData.addSource(useCase.searchUsers(query)) {
                allUsersLiveData.value = it
            }
        }
    }

    fun getUsers(): MediatorLiveData<Result<List<GithubUser>>> {
        return allUsersLiveData
    }

    fun setSelectedUser(selectedGithubUser: GithubUser): UserViewModel {
        this.selectedGithubUser = selectedGithubUser
        return this
    }

    fun getSelectedUser(): MediatorLiveData<Result<DetailGithubUser>> {
        return selectedUserLiveData
    }

}