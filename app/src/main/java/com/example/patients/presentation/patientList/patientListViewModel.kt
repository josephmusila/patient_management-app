package com.example.patients.presentation.patientList

import androidx.lifecycle.ViewModel
import com.example.patients.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class patientListViewModel @Inject constructor(
    private val repository: PatientRepository
):ViewModel(){

}