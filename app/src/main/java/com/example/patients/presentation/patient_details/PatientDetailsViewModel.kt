package com.example.patients.presentation.patient_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.patients.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PatientDetailsViewModel @Inject constructor(
    private  val  repository: PatientRepository
):ViewModel() {
    var name by mutableStateOf("")

    var state by mutableStateOf(PatientDetailsUiState())

    fun onEvent(event:PatientDetailEvents){
        when(event){
            is PatientDetailEvents.EnteredAge -> {
                state =state.copy(age = event.age)
            }
            is PatientDetailEvents.EnteredAssignedDoctor -> {
                state =state.copy(doctorAssigned = event.doctor)
            }
            is PatientDetailEvents.EnteredName -> {
                state =state.copy(name = event.name)
            }
            is PatientDetailEvents.EnteredPrescription -> {
                state =state.copy(prescription = event.prescription)
            }
            PatientDetailEvents.saveButton -> TODO()
            PatientDetailEvents.selectedFemale -> {
                state =state.copy(gender = 2)
            }
            PatientDetailEvents.selectedMale -> {
                state =state.copy(gender = 1)
            }
        }
    }


}