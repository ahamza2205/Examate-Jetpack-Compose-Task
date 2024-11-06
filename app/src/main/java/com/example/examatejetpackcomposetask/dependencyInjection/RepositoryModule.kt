package com.example.examatejetpackcomposetask.dependencyInjection

import com.example.examatejetpackcomposetask.screens.connect.data.StudyPartnerRepositoryImpl
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartnerRepository
import com.example.examatejetpackcomposetask.screens.home.data.StudyUnitRepositoryImpl
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnitRepository
import com.example.examatejetpackcomposetask.screens.questions.data.QuestionRepositoryImpl
import com.example.examatejetpackcomposetask.screens.questions.domain.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideStudyUnitRepository(): StudyUnitRepository {
        return StudyUnitRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideStudyPartnerRepository(): StudyPartnerRepository {
        return StudyPartnerRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideQuestionRepository(): QuestionRepository {
        return QuestionRepositoryImpl()
    }
}
