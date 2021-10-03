package pe.paku.brakingbad.presentation.detail_character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.presentation.Greeting
import pe.paku.brakingbad.presentation.detail_character.components.HeaderDetailCharacter
import pe.paku.brakingbad.presentation.detail_character.components.ItemDetailCharacter
import pe.paku.brakingbad.presentation.list_characters.bodyListCharacterScreen
import pe.paku.brakingbad.presentation.ui.theme.BrakingbadTheme

@Composable
fun DetailCharacterScreen(
    navController: NavController,
    viewModel: DetailCharacterViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(state.character?.let { it.nickname }?: Constants.TiTLE_DETAIL_CHARACTERS)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },
        content = {
            bodyDetailCharacterScreen(state = state)
        }
    )


}

@Composable
fun bodyDetailCharacterScreen(state: DetailCharacterState){
    Column(modifier = Modifier
        .fillMaxSize())
    {
        state.character?.let {
            HeaderDetailCharacter(characterDetail = it)
            ItemDetailCharacter(
                itemLabel = Constants.DETAIL_CHARACTER_OCCUPATION,
                description = it.occupation
            )
            ItemDetailCharacter(
                itemLabel = Constants.DETAIL_CHARACTER_STATUS,
                description = listOf(it.status)
            )
            ItemDetailCharacter(
                itemLabel = Constants.DETAIL_CHARACTER_PORTRAYED,
                description = listOf(it.portrayed)
            )
        }
    }
}


