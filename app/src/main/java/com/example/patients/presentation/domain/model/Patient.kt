package com.example.patients.presentation.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.patients.utils.Constants.PATIENT_TABLE

@Entity(tableName = PATIENT_TABLE)
data class Patient(
    val name:String,
    val age:String,
    val gender:Int,
    val doctorAssigned:String,
    val prescription:String,
    @PrimaryKey(autoGenerate = true)
    val patientId:Int?=null
)
