package com.example.patients.presentation.patient_details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patients.ui.theme.RoyalBlue
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PatientDetailScreen(
    viewModel: PatientDetailsViewModel = hiltViewModel(),
    onBackClicked: () -> Unit
    ) {
    val focusRequester= remember {
        FocusRequester()
    }
    val focusManager= LocalFocusManager.current

    val state=  viewModel.state

    LaunchedEffect(key1 = Unit ){
        delay(100)
        focusRequester.requestFocus()
    }

    Scaffold(
        topBar = {
            TopBar(onBackClicked = onBackClicked)
        }
    ) {
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(it)
        ) {
            OutlinedTextField(

                modifier = Modifier
                    .focusRequester(focusRequester)
                    .fillMaxWidth(),
                value = state.name,
                onValueChange ={newValue ->
                    viewModel.onEvent(PatientDetailEvents.EnteredName(newValue))},
                label = { Text(text = "Name")},
                textStyle=MaterialTheme.typography.bodySmall,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Next)}
                )
                )
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier=Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f),
                    value = state.age,
                    onValueChange ={newValue ->
                        viewModel.onEvent(PatientDetailEvents.EnteredAge(newValue))},
                    label = { Text(text = "Age")},
                    textStyle=MaterialTheme
                        .typography
                        .bodySmall,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                            keyboardActions = KeyboardActions(
                            onNext = {focusManager.moveFocus(FocusDirection.Next)}
                            )
                )
                Spacer(modifier = Modifier.size(10.dp))
                RadioGroup(
                    onClick = {  viewModel.onEvent(PatientDetailEvents.selectedMale)},
                    modifier =Modifier.padding(horizontal = 10.dp) ,
                    selected = state.gender == 1,
                    text = "Male",
                    )
                RadioGroup(
                    onClick = { viewModel.onEvent(PatientDetailEvents.selectedFemale) },
                    modifier =Modifier.padding(horizontal = 10.dp) ,
                    selected = state.gender == 2,
                    text = "Female",
                )

            }
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = state.doctorAssigned,
                onValueChange ={newValue ->
                    viewModel.onEvent(PatientDetailEvents.EnteredAssignedDoctor(newValue))},
                label = { Text(text = "Assigned Doctor's Name")},
                textStyle=MaterialTheme.typography.bodySmall,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Next)}
                )
            )
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                value = state.prescription,
                onValueChange ={newValue ->
                    viewModel.onEvent(PatientDetailEvents.EnteredPrescription(newValue))},
                label = { Text(text = "Prescription")},
                textStyle=MaterialTheme.typography.bodySmall,
                singleLine = true,

            )
            Spacer(modifier = Modifier.size(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {  }) {
                Text(text = "Save",
                    style = MaterialTheme.typography.headlineSmall,
                    color=Color.White
                    )

            }
        }
    }
}

@Composable
fun RadioGroup(
    onClick:()->Unit,
    modifier:Modifier,
    selected:Boolean,
    text:String
) {
    Row(
        modifier = modifier.clickable { onClick },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary
            ),
        )
        
        Text(text = text, style = MaterialTheme.typography.bodySmall)
        
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBackClicked:()->Unit) {
    TopAppBar(
        colors = TopAppBarDefaults
            .smallTopAppBarColors(RoyalBlue),
        title = {
        Text(text = "Patient's Details Screen",
            color = Color.White,
        fontSize = 16.sp
        )
    },
    navigationIcon = {
        IconButton(onClick = { onBackClicked() }) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back")
        }
    }

    )
    
}