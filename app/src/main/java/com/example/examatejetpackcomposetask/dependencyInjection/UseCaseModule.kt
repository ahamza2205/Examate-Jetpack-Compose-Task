package com.example.examatejetpackcomposetask.dependencyInjection

import com.example.examatejetpackcomposetask.screens.connect.domain.GetStudyPartnersUseCase
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartnerRepository
import com.example.examatejetpackcomposetask.screens.home.domain.GetStudyUnitsUseCase
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnitRepository
import com.example.examatejetpackcomposetask.screens.questions.domain.GetOralQuestionsUseCase
import com.example.examatejetpackcomposetask.screens.questions.domain.GetWritingQuestionsUseCase
import com.example.examatejetpackcomposetask.screens.questions.domain.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetStudyUnitsUseCase(repository: StudyUnitRepository): GetStudyUnitsUseCase {
        return GetStudyUnitsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetStudyPartnersUseCase(repository: StudyPartnerRepository): GetStudyPartnersUseCase {
        return GetStudyPartnersUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetOralQuestionsUseCase(repository: QuestionRepository): GetOralQuestionsUseCase {
        return GetOralQuestionsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetWritingQuestionsUseCase(repository: QuestionRepository): GetWritingQuestionsUseCase {
        return GetWritingQuestionsUseCase(repository)
    }
}
