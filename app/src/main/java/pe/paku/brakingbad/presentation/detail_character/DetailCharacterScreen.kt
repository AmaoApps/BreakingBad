package pe.paku.brakingbad.presentation.detail_character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.presentation.detail_character.components.HeaderDetailCharacter

@Composable
fun DetailCharacterScreen(
    viewModel: DetailCharacterViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Column(modifier = Modifier
        .fillMaxSize())
    {
        TopAppBar(title = { Text(text = state.character?.let { state.character.name } ?: Constants.TiTLE_DETAIL_CHARACTERS )})
        state.character?.let {
            HeaderDetailCharacter(characterDetail = it)
        }
    }
}