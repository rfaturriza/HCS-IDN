package com.rizz.test.feature.user.di

import com.rizz.test.feature.user.data.local.UserLocalDataSource
import com.rizz.test.feature.user.data.local.UserLocalDataSourceImpl
import com.rizz.test.feature.user.data.remote.services.GithubService
import com.rizz.test.feature.user.data.remote.source.GithubRemoteDataSource
import com.rizz.test.feature.user.data.remote.source.GithubRemoteDataSourceImpl
import com.rizz.test.feature.user.data.repository.UserRepository
import com.rizz.test.feature.user.data.repository.UserRepositoryImpl
import com.rizz.test.feature.user.domain.UserUseCase
import com.rizz.test.feature.user.domain.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class UserModule {
    @Singleton
    @Provides
    fun provideGithubServiceAPI(retrofit: Retrofit.Builder): GithubService =
        retrofit
            .build()
            .create(GithubService::class.java)

    @Singleton
    @Provides
    fun provideGithubRemoteDataSource(githubService: GithubService): GithubRemoteDataSource =
        GithubRemoteDataSourceImpl(githubService)

    @Singleton
    @Provides
    fun provideGithubLocalDataSource(): UserLocalDataSource = UserLocalDataSourceImpl()

    @Singleton
    @Provides
    fun provideUserRepository(githubRemoteDataSource: GithubRemoteDataSource, githubLocalDataSource: UserLocalDataSource): UserRepository =
        UserRepositoryImpl(
            githubRemoteDataSource,
            githubLocalDataSource,
        )

    @Singleton
    @Provides
    fun provideUserUseCase(userRepository: UserRepository): UserUseCase =
        UserUseCaseImpl(userRepository)
}