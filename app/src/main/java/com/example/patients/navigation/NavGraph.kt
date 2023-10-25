package com.example.patients.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.patients.presentation.patientList.PatientListScreen
import com.example.patients.presentation.patient_details.PatientDetailScreen
import com.example.patients.presentation.patient_details.PatientDetailsViewModel
import com.example.patients.utils.Constants.PATIENT_DETAILS_ARG_KEY


sealed class Screen(val  route:String){
    object PatientList:Screen("patient_list_screen")
    object PatientDetails:Screen("patient_details_screen?$PATIENT_DETAILS_ARG_KEY={$PATIENT_DETAILS_ARG_KEY}")

    fun passPatientId(patientId:Int?):String{
        return "patient_details_screen?$PATIENT_DETAILS_ARG_KEY=$patientId"
    }
}

@Composable
fun NavGraphSetup(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.PatientList.route ){
        composable(
            route =Screen.PatientList.route,
        ){
            PatientListScreen(
                onFabClicked = {
                    navController.navigate(Screen.PatientDetails.route)
                },
                onItemClicked = {
                    navController.navigate(Screen.PatientDetails.passPatientId(it))
                }
            )
        }
        composable(
            route =Screen.PatientDetails.route,
            arguments = listOf(navArgument(name = "$PATIENT_DETAILS_ARG_KEY"){
                type = NavType.IntType
                defaultValue=-1
            })
        ){
//            val viewModel = viewModel<PatientDetailsViewModel>()
            PatientDetailScreen(
                onBackClicked = { navController.navigateUp() })
        }
    }
}