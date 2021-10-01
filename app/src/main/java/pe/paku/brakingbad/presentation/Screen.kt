package pe.paku.brakingbad.presentation

import pe.paku.brakingbad.common.Constants

sealed class Screen(val route: String) {
    class ListCharacterScreen : Screen(route = Constants.PathScreen.LIST_CHARACTER_SCREEN)
    class DetailCharacterScreen : Screen(route = Constants.PathScreen.DETAIL_CHARACTER_SCREEN)
}
