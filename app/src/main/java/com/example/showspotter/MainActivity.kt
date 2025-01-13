package com.example.showspotter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.showspotter.screens.HomeScreen
import com.example.showspotter.screens.LoginScreen
import com.example.showspotter.screens.MovieDescScreen
import com.example.showspotter.screens.OnBoardingScreen
import com.example.showspotter.screens.SeriesDescScreen
import com.example.showspotter.screens.SignUpDetailsScreen
import com.example.showspotter.screens.SignUpScreen
import com.example.showspotter.tmdbMVVM.Repository
import com.example.showspotter.tmdbMVVM.ViewModalFactory
import com.example.showspotter.tmdbMVVM.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlin.collections.listOf
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val repository by lazy {
                Repository()
            }
            val viewModel: ViewModel by viewModels {
                ViewModalFactory(repository)
            }
            MyApp(viewModel)
        }
    }
}

@Composable
fun MyApp(viewModel: ViewModel) {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val navController = rememberNavController()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            GoogleSignInUtils.Companion.doGoogleSignIn(
                context = context,
                scope = scope,
                launcher = null,
                login = {
                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                }
            )
        }
    var startDes = "homescreen"
    if(auth.currentUser!=null){
        startDes = "homescreen"
    }
    NavHost(navController = navController, startDestination = startDes) {
        composable("onboarding") {
            OnBoardingScreen(goToLogInScreen = {
                navController.navigate("loginscreen")
            },
                goToSignUpScreen = {
                    navController.navigate("signupscreen")
                })
        }

        composable("loginscreen") {
            LoginScreen(auth, openHomeScreen = {
                navController.navigate("homescreen"){
                    popUpTo(0)
                }
            }, scope, launcher)
        }

        composable("signupscreen") {
            SignUpScreen(goToHomeScreen = {
                navController.navigate("homescreen"){
                    popUpTo(0)
                }
            },
                goToLoginScreen = {
                navController.navigate("loginscreen")
            },
                goToSignUpDetails = {
                        navController.navigate("signupdetailsscreen")
                },
                scope,
                launcher
            )
        }

        composable("signupdetailsscreen"){
            SignUpDetailsScreen(auth,signSuccessGoToLoginScreen = {
                navController.navigate("loginscreen")
            }, goToBackSignUpScreen = {
                navController.navigate("signupscreen")
            })
        }

        composable("homescreen"){
            HomeScreen(viewModel = viewModel,auth, goToOnBoardingScreen = {
                navController.navigate("onboarding"){
                    popUpTo(0)
                }
            },
                goToSeriesDescScreen = {id->
                    navController.navigate("seriesdescscreen/$id")
                },
                goToMovieDescScreen = {id->
                        navController.navigate("moviedescscreen/$id")
                })
        }

        composable("moviedescscreen/{id}",
                arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )){
            val navBackStackEntry = it
            val id= navBackStackEntry.arguments?.getInt("id") ?:-1
            MovieDescScreen(viewModel=viewModel,id)
        }
        composable("seriesdescscreen/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
            ){
            val navBackStackEntry = it
            val id= navBackStackEntry.arguments?.getInt("id") ?:-1
            SeriesDescScreen(viewModel=viewModel,id)
        }

    }
}
