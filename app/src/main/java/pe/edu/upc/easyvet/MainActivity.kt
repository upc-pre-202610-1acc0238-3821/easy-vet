package pe.edu.upc.easyvet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import pe.edu.upc.easyvet.presentation.Login
import pe.edu.upc.easyvet.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme  {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Login(Modifier.padding(innerPadding))
                }
            }
        }
    }
}