package com.rizz.test.feature.user.domain

import com.rizz.test.feature.user.data.repository.UserRepository
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    UserUseCase {
    override suspend fun requestUsers() = userRepository.requestUsers()

    override suspend fun requestUser(username: String) = userRepository.requestUser(username)

    override suspend fun searchUsers(
        query: String
    ) = userRepository.searchUsers(query)
}