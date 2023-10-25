package com.example.patients.presentation.patient_details

sealed class PatientDetailEvents{
    data class EnteredName(val name:String):PatientDetailEvents()
    data class EnteredAge(val age:String):PatientDetailEvents()
    data class EnteredAssignedDoctor(val doctor:String):PatientDetailEvents()
    data class EnteredPrescription(val prescription:String):PatientDetailEvents()
    object selectedMale:PatientDetailEvents()
    object selectedFemale:PatientDetailEvents()
    object saveButton:PatientDetailEvents()
}
