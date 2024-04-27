package com.miguelfagundez.herocalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miguelfagundez.herocalculator.events.CalculatorEvents
import com.miguelfagundez.herocalculator.events.CalculatorOperation
import com.miguelfagundez.herocalculator.state.CalculatorViewModel
import com.miguelfagundez.herocalculator.ui.components.CalculatorBox
import com.miguelfagundez.herocalculator.ui.components.CalculatorButton
import com.miguelfagundez.herocalculator.ui.theme.HeroCalculatorTheme
import com.miguelfagundez.herocalculator.ui.theme.LightGray
import com.miguelfagundez.herocalculator.ui.theme.MediumGray
import com.miguelfagundez.herocalculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroCalculatorTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                // Spacing between buttons
                val spacing = 8.dp

                // Calculator view
                CalculatorBox(
                    state = state,
                    action = viewModel::action,
                    btnSpacing = spacing,
                    info = Modifier
                        .fillMaxSize()
                        .background(MediumGray)
                        .padding(16.dp)
                )
            }
        }
    }
}