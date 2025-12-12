package com.utez.paseleguero.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.utez.paseleguero.ui.view.AuctionDetailScreen
import com.utez.paseleguero.ui.view.CreateAuctionScreen
import com.utez.paseleguero.ui.view.HomeScreen
import com.utez.paseleguero.ui.view.LoginScreen
import com.utez.paseleguero.ui.viewmodel.AuctionDetailViewModel
import com.utez.paseleguero.ui.viewmodel.HomeViewModel
import com.utez.paseleguero.ui.viewmodel.LoginViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            val loginVM = viewModel<LoginViewModel>()
            LoginScreen(navController = navController, viewModel = loginVM)
        }

        composable("home") {
            val homeVM = viewModel<HomeViewModel>()
            HomeScreen(
                viewModel = homeVM,
                onNavigateToCreate = { navController.navigate("create_auction") },
                onNavigateToDetail = { productId ->
                    navController.navigate("auction_detail/$productId")
                }
            )
        }

        composable("create_auction") {
            CreateAuctionScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(
            route = "auction_detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            val detailVM: AuctionDetailViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        @Suppress("UNCHECKED_CAST")
                        return AuctionDetailViewModel(productId) as T
                    }
                }
            )

            AuctionDetailScreen(
                viewModel = detailVM,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
