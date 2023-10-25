package com.example.patients.di

import android.app.Application
import androidx.room.Room
import com.example.patients.data.local.PatientDatabase
import com.example.patients.data.repository.PatientRepositoryImpl
import com.example.patients.repository.PatientRepository
import com.example.patients.utils.Constants.PATIENT_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePatientDatabase(
        app:Application
    ):PatientDatabase{
            return Room.databaseBuilder(
                app,
                PatientDatabase::class.java,
                PATIENT_TABLE
            ).build()
    }

    @Provides
    @Singleton
    fun providePatientRepository(
        db:PatientDatabase
    ):PatientRepository{
        return PatientRepositoryImpl(dao = db.patientDao)
    }
}