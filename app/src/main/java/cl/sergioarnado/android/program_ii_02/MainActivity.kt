package cl.sergioarnado.android.program_ii_02

import android.content.pm.Checksum
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaInstance
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicioUI()


        }
    }
}

data class mercaderia(
    val nombre: String,

)

@Preview(showSystemUi = true)
@Composable
fun PantallaInicioUI(){

    val contexto = LocalContext.current

    val mercaderia = listOf<mercaderia>(
        mercaderia("Aceite"),
        mercaderia("Fideos"),
        mercaderia("Sal"),
        mercaderia("Azucar"),
    )

    Text(
        text = contexto.getString(R.string.app_name),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 25.sp,
        modifier = Modifier.fillMaxWidth()

        )

    Column {
        Spacer(modifier = Modifier.height(100.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "Logo"
            )
        }

        LazyColumn(
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 230.dp)
        ) {
            items(mercaderia) { mercaderia ->//Pa iterar
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween, // alineacion
                        modifier = Modifier.fillMaxWidth() // ocupar ancho de la linea
                    ) {

                        Text(mercaderia.nombre.toString())


                    }
                }
            }
        }
    }
}

@Composable
fun AppCompras(
    navcontroller:NavHostController = rememberNavController()

){
    NavHost(
        navController = navcontroller,
        startDestination = "inicio"
    ){
        composable("inicio"){
            PageInicioUI()

        }
        composable("configuracion") {
            PageConfiguracionUI()

        }


    }

}

@Composable
fun PageInicioUI(){

}

@Composable
fun PageConfiguracionUI(
    

){



}
@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") {
            fun App(
                navController: NavHostController = rememberNavController()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable("inicio") {
                        HomePageUI(
                            onButtonSettingsClicked = {
                                navController.navigate("settings")
                            }
                        )
                    }
                    composable("settings") {
                        SettingsPageUI(
                            onBackButtonClicked = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }(
                onButtonSettingsClicked = {
                    navController.navigate("settings")
                }
            )
        }
        composable("settings") {
            SettingsPageUI(
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun  HomePageUI (
    onClick: () -> Unit = {}

){

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green).
        clickable {  }
    )
}

@Composable
fun  SettingsPageUI (
    onClick: () -> Unit = {}

){

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green).
        clickable {  }
    )
}
