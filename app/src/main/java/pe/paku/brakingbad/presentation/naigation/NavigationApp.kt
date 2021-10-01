package pe.paku.brakingbad.presentation.naigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.presentation.detail_character.DetailCharacterScreen
import pe.paku.brakingbad.presentation.list_characters.ListCharacterScreen

@Composable
fun NavigationApp(){
    val navigation = rememberNavController()

    NavHost(navController = navigation, startDestination = Constants.PathScreen.LIST_CHARACTER_SCREEN){
        composable(route = Constants.PathScreen.LIST_CHARACTER_SCREEN){
            ListCharacterScreen(navController = navigation)
        }
        composable(route = Constants.PathScreen.DETAIL_CHARACTER_SCREEN + "/{idCharacter}"){
            DetailCharacterScreen()
        }
    }

}