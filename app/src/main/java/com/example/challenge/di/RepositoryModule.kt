package com.example.challenge.di

import com.example.challenge.data.repository.connection.ConnectionsRepositoryImpl
import com.example.challenge.data.repository.datastore.DataStoreRepositoryImpl
import com.example.challenge.data.repository.log_in.LogInRepositoryImpl
import com.example.challenge.domain.repository.connection.ConnectionsRepository
import com.example.challenge.domain.repository.datastore.DataStoreRepository
import com.example.challenge.domain.repository.log_in.LogInRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class  RepositoryModule {

    @Binds
    abstract fun bindsDataStoreRepository(dataStoreRepositoryImpl: DataStoreRepositoryImpl) : DataStoreRepository

    @Binds
    abstract fun bindsLoginRepository(logInRepositoryImpl: LogInRepositoryImpl) : LogInRepository

    @Binds
    abstract fun bindsConnectionRepository(connectionsRepositoryImpl: ConnectionsRepositoryImpl) : ConnectionsRepository
}