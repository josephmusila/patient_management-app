package com.example.patients.presentation.patientList

import android.icu.text.CaseMap.Title
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

//hhttps://youtu.be/w_3G5InWYxU?t=4806

@Composable
fun DeleteDialog(
    title: String,
    message:String,
    onDialogDismiss:()->Unit,
    onConfirmButtonClicked:()->Unit
){
    AlertDialog(
        title = {
                Text(text = title, fontSize = 18.sp)
        },
        text = {
               Text(text = message, fontSize = 14.sp)
        },
        onDismissRequest = {  onDialogDismiss()},
        confirmButton = {
            TextButton(onClick = { onConfirmButtonClicked() }) {
                Text(text = "Yes")

            }
        },
        dismissButton =  {
            TextButton(onClick = { onDialogDismiss() }) {
                Text(text = "No")

            }
        },
        )
}