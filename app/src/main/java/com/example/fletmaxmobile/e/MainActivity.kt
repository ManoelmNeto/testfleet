package com.example.fletmaxmobile.e

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fletmaxmobile.e.ui.AppTheme
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
