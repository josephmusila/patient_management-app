package com.example.patients.presentation.patientList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patients.presentation.domain.model.Patient
import com.example.patients.ui.theme.RoyalBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PatientListScreen(
    onFabClicked:()->Unit,
    onItemClicked:(Int?)->Unit,
    viewModel: patientListViewModel = hiltViewModel()
){

    val patients= listOf<Patient>(
        Patient(
            name = "John Doe",
            age="25",
            gender=1,
            doctorAssigned = "Dr. Kareem",
            prescription = "Keep Drinking Water"
        ),
        Patient(
            name = "Marry Ann",
            age="34",
            gender=2,
            doctorAssigned = "Dr. Manuel",
            prescription = "Keep Drinking Fluids"
        )
    )

    Scaffold(
        topBar = {ListTopAppBar()},
        floatingActionButton = {ListFab(onClicked = {onFabClicked()})}
    ) {
    Box(
        modifier= Modifier
            .fillMaxSize()
            .padding(it),

        contentAlignment= Alignment.Center
        
    ) {
        LazyColumn(
            modifier=Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
           items(patients){
               patient->PatientItem(patient = patient,
               itemClick={onItemClicked(patient.patientId)},
               onDeleteConfirmed={})

           }
        }

        if(patients.isEmpty()){

            Box (
                modifier= Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Add Patient details \n by pressing add button",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }

    }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListTopAppBar(){
    TopAppBar(
        colors = TopAppBarDefaults
            .smallTopAppBarColors(RoyalBlue),
        title = {
            Text(text = "Patient Tracker",
                color=Color.White,
                style = MaterialTheme
                    .typography.headlineSmall
                    .copy(fontWeight = FontWeight.Bold)
                )
        }

    )
}

@Composable
fun ListFab(onClicked:()->Unit){
    FloatingActionButton(
        onClick = onClicked)
    {
        Icon(imageVector = Icons.Filled.Add, contentDescription ="Add patient button" )
    }
}