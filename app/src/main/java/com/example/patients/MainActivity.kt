package com.example.patients

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.patients.navigation.NavGraphSetup
import com.example.patients.presentation.patientList.PatientListScreen
import com.example.patients.presentation.patient_details.PatientDetailScreen
import com.example.patients.presentation.patient_details.PatientDetailsViewModel
import com.example.patients.ui.theme.PatientsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatientsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavGraphSetup(navController = navController)
//                    val viewModel = viewModel<PatientDetailsViewModel>()
//                    PatientListScreen()
//                    PatientDetailScreen(viewModel)
                }
            }
        }
    }
}
