package com.example.patients.data.repository

import com.example.patients.data.local.PatientDao
import com.example.patients.presentation.domain.model.Patient
import com.example.patients.repository.PatientRepository
import kotlinx.coroutines.flow.Flow

class PatientRepositoryImpl (private val dao: PatientDao):PatientRepository{
    override suspend fun addorUpdatePatient(patient: Patient) {
        dao.addOrUpdatePatient(patient)
    }

    override suspend fun deletePatient(patient: Patient) {
        dao.deletePatient(patient)
    }

    override suspend fun getPatientById(patientId: Int): Patient? {
        return dao.getPatientById(patientId)
    }

    override fun getAllPatients(): Flow<List<Patient>> {
        return  dao.gatAllPatient()
    }
}