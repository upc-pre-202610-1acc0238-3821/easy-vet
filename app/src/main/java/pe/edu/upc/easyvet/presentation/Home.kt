package pe.edu.upc.easyvet.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyvet.R
import pe.edu.upc.easyvet.presentation.theme.AppTheme

@Composable
fun Home(modifier: Modifier = Modifier) {
    val categories = listOf(
        Category(painter = painterResource(R.drawable.dogcategory), name = "Dog"),
        Category(painter = painterResource(R.drawable.catcategory), name = "Cat"),
        Category(painter = painterResource(R.drawable.birdcategory), name = "Bird"),
        Category(painter = painterResource(R.drawable.fishcategory), name = "Fish")


    )
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Categories", fontWeight = FontWeight.Bold)
        LazyRow {
            items(categories) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = it.painter,
                        contentDescription = it.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(text = it.name)
                }
            }
        }

    }
}

@Preview
@Composable
fun HomePreview() {
    AppTheme {
        Home()
    }

}

data class Category(
    val painter: Painter,
    val name: String
)