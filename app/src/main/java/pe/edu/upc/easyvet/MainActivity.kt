package pe.edu.upc.easyvet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.edu.upc.easyvet.di.RepositoryModule.provideProductRepository
import pe.edu.upc.easyvet.presentation.home.ProductListViewModel
import pe.edu.upc.easyvet.presentation.navigation.Main
import pe.edu.upc.easyvet.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = ProductListViewModel(
            provideProductRepository()
        )
        setContent {
            AppTheme {
                Main()
            }
        }
    }
}