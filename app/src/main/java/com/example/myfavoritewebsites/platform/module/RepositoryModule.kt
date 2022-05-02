package com.example.myfavoritewebsites.platform.module

import com.example.myfavoritewebsites.api.CoreHomeApi
import com.example.myfavoritewebsites.repository.AddUrlRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {
    @Provides
    fun UrlRepositoryProvider(apiService: CoreHomeApi):
        AddUrlRepository = AddUrlRepository(apiService)
}
