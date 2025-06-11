package com.example.fletmaxmobile.data

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fletmaxmobile.data.ui.AppTheme
import com.example.fletmaxmobile.ui.AppNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavigationGraph()
            }
        }
    }
}
