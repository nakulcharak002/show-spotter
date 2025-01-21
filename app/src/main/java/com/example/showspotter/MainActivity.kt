package com.example.showspotter

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.showspotter.screens.AllMovieVideosScreen
import com.example.showspotter.screens.AllSeriesVideosScreen
import com.example.showspotter.screens.FavouriteScreen
import com.example.showspotter.screens.HomeScreen
import com.example.showspotter.screens.LoginScreen
import com.example.showspotter.screens.MovieDescScreen
import com.example.showspotter.screens.MovieTabScreen
import com.example.showspotter.screens.OnBoardingScreen
import com.example.showspotter.screens.Profile
import com.example.showspotter.screens.SearchingScreen
import com.example.showspotter.screens.SeriesDescScreen
import com.example.showspotter.screens.SeriesTabScreen
import com.example.showspotter.screens.SignUpDetailsScreen
import com.example.showspotter.screens.SignUpScreen
import com.example.showspotter.screens.WatchlistScreen
import com.example.showspotter.tmdbMVVM.Repository
import com.example.showspotter.tmdbMVVM.ViewModalFactory
import com.example.showspotter.tmdbMVVM.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.collections.listOf
import kotlin.getValue

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp(viewModel: ViewModel) {
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        val databaseReference = FirebaseDatabase.getInstance().reference
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
        var startDes = "onboarding"
        if (auth.currentUser != null) {
            startDes = "homescreen"
        }
        NavHost(
            navController = navController,
            startDestination = startDes,
            modifier = Modifier.fillMaxSize().background(Color.Black)
        ) {
            composable("onboarding") {
                OnBoardingScreen(goToLogInScreen = {
                    navController.navigate("loginscreen")
                },
                    goToSignUpScreen = {
                        navController.navigate("signupscreen")
                    },
                    goToHomeScreen = {
                        navController.navigate("homescreen")
                    })
            }

            composable("loginscreen") {
                LoginScreen(databaseReference,auth, openHomeScreen = {
                    navController.navigate("homescreen") {
                        popUpTo(0)

                    }
                }, scope, launcher)
            }

            composable("signupscreen") {
                SignUpScreen(databaseReference,auth,
                    goToHomeScreen = {
                        navController.navigate("homescreen") {
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

            composable("signupdetailsscreen") {
                SignUpDetailsScreen(databaseReference,auth, signSuccessGoToLoginScreen = {
                    navController.navigate("loginscreen")
                }, goToBackSignUpScreen = {
                    navController.navigate("signupscreen")
                })
            }

            composable("homescreen",
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { fullWidth -> fullWidth },
                        animationSpec = tween(200)
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { fullWidth -> -fullWidth },
                        animationSpec = tween(200)
                    )
                },
                popEnterTransition = {
                    slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(200))
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(200))
                }
            ) {
                HomeScreen(navController,viewModel = viewModel, auth, goToOnBoardingScreen = {
                    navController.navigate("onboarding") {
                        popUpTo(0)
                    }
                },
                    goToSeriesDescScreen = { id ->
                        navController.navigate("seriesdescscreen/$id")

                    },
                    goToMovieDescScreen = { id ->
                        navController.navigate("moviedescscreen/$id")
                    },
                    goToHomeScreen = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (currentDestination != "homescreen") {
                            navController.navigate("homescreen")
                        }
                    },
                    goToMovieTabScreen = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (currentDestination != "movietabscreen") {
                            navController.navigate("movietabscreen")
                        }
                    },
                    goToSeriesTabScreen = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (currentDestination != "seriestabscreen") {
                            navController.navigate("seriestabscreen")
                        }
                    },
                    goToSearchScreen = {
                        navController.navigate("searchscreen")
                    },
                    goToProfileScreen = {
                        navController.navigate("profilescreen")
                    })
            }

            composable("moviedescscreen/{id}",
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { fullWidth -> fullWidth },
                        animationSpec = tween(200)
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { fullWidth -> -fullWidth },
                        animationSpec = tween(200)
                    )
                },
                popEnterTransition = {
                    slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(200))
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(200))
                },
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) {
                val navBackStackEntry = it
                val id = navBackStackEntry.arguments?.getInt("id") ?: -1
                MovieDescScreen(databaseReference,auth,viewModel = viewModel,id= id, goToBackStack = {
                    navController.popBackStack()
                },
                    goToAllMovieVideosScreen = {
                        navController.navigate("allmovievideosscreen/$it")
                    })
            }



            composable("seriesdescscreen/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) {
                val navBackStackEntry = it
                val id = navBackStackEntry.arguments?.getInt("id") ?: -1
                SeriesDescScreen(databaseReference,auth,viewModel = viewModel, id, goToBackStack = {
                    navController.popBackStack()
                }, goToAllVideosScreen = {
                    navController.navigate("allseriesvideosscreen/$it")
                })
            }
            composable("allseriesvideosscreen/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) {
                val navBackStackEntry = it
                val id = navBackStackEntry.arguments?.getInt("id") ?: -1
                AllSeriesVideosScreen(viewModel, id, goBack = {
                    navController.popBackStack()
                })
            }

            composable("allmovievideosscreen/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) {
                val navBackStackEntry = it
                val id = navBackStackEntry.arguments?.getInt("id") ?: -1
                AllMovieVideosScreen(viewModel, id, goBack = {
                    navController.popBackStack()
                })
            }

            composable("movietabscreen") {
                MovieTabScreen(navController,viewModel, goToHomeScreen = {
                    val currentDestination = navController.currentBackStackEntry?.destination?.route
                    if (currentDestination != "homescreen") {
                        navController.navigate("homescreen")
                    }
                },
                    goToMovieTabScreen = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (currentDestination != "movietabscreen") {
                            navController.navigate("movietabscreen")
                        }
                    },
                    goToMovieDescScreen = { id ->
                        navController.navigate("moviedescscreen/$id")
                    },
                    goToSeriesTabScreen = {
                        navController.navigate("seriestabscreen")
                    },
                    goToSearchScreen = {
                        navController.navigate("searchscreen")
                    },
                    goToProfileScreen = {
                        navController.navigate("profilescreen")
                    })
            }

            composable("seriestabscreen") {
                SeriesTabScreen(navController,viewModel, goToHomeScreen = {
                    val currentDestination = navController.currentBackStackEntry?.destination?.route
                    if (currentDestination != "homescreen") {
                        navController.navigate("homescreen")
                    }
                },
                    goToMovieTabScreen = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (currentDestination != "movietabscreen") {
                            navController.navigate("movietabscreen")
                        }
                    },
                    goToSeriesDescScreen = { id ->
                        navController.navigate("seriesdescscreen/$id")
                    },
                    goToSeriesTabScreen = {
                        val currentDestination =
                            navController.currentBackStackEntry?.destination?.route
                        if (currentDestination != "seriestabscreen") {
                            navController.navigate("seriestabscreen")
                        }
                    },
                    goToSearchScreen = {
                        navController.navigate("searchscreen")
                    },
                    goToProfileScreen = {
                        navController.navigate("profilescreen")
                    })
            }

            composable("searchscreen") {
                SearchingScreen(viewModel, goToMovieDescScreen = { id ->
                    navController.navigate("moviedescscreen/$id")
                },
                    goToSeriesDescScreen = { id ->
                        navController.navigate("seriesdescscreen/$id")
                    })
            }

            composable("profilescreen"){
                Profile(databaseReference,context,auth, goToOnBoardingScreen = {
                    navController.navigate("onboarding"){
                        popUpTo(0)
                    }
                },
                    goToBackStack = {
                        navController.popBackStack()
                    },
                    goToFavouriteScreen = {
                        navController.navigate("favouritescreen")
                    },
                    goToWatchlistScreen = {
                        navController.navigate("watchlist")
                    })
            }

            composable("favouritescreen"){
                FavouriteScreen(viewModel,auth,databaseReference,goToBackStack={
                    navController.popBackStack()
                },goToMovieDescScreen = { id ->
                    navController.navigate("moviedescscreen/$id")
                },
                    goToSeriesDescScreen = {id->
                        navController.navigate("seriesdescscreen/$id")
                    })
            }

            composable("watchlist"){
                WatchlistScreen(auth,databaseReference,goToBackStack={
                    navController.popBackStack()
                },goToMovieDescScreen = { id ->
                    navController.navigate("moviedescscreen/$id")
                },
                    goToSeriesDescScreen = {id->
                        navController.navigate("seriesdescscreen/$id")
                    })
            }


        }
    }
