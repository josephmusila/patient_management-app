package com.example.patients.repository

import com.example.patients.presentation.domain.model.Patient
import kotlinx.coroutines.flow.Flow

interface PatientRepository {

    suspend fun addorUpdatePatient(patient: Patient)

    suspend fun deletePatient(patient: Patient)

    suspend fun getPatientById(patientId:Int):Patient?

    fun getAllPatients():Flow<List<Patient>>


}