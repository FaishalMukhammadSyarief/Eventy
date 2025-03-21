package com.zhalz.eventy.di

import com.zhalz.eventy.data.repository.AuthRepositoryImpl
import com.zhalz.eventy.data.repository.DivisionRepositoryImpl
import com.zhalz.eventy.data.repository.EventRepositoryImpl
import com.zhalz.eventy.data.repository.SessionRepositoryImpl
import com.zhalz.eventy.domain.repository.AuthRepository
import com.zhalz.eventy.domain.repository.DivisionRepository
import com.zhalz.eventy.domain.repository.EventRepository
import com.zhalz.eventy.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl) : AuthRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(sessionRepositoryImpl: SessionRepositoryImpl) : SessionRepository

    @Singleton
    @Binds
    abstract fun bindEventRepository(eventRepositoryImpl: EventRepositoryImpl) : EventRepository

    @Singleton
    @Binds
    abstract fun bindDivisionRepository(divisionRepositoryImpl: DivisionRepositoryImpl) : DivisionRepository

}