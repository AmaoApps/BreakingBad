package pe.paku.brakingbad.presentation.list_characters

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.presentation.list_characters.components.ListItemCharacter
import pe.paku.brakingbad.presentation.ui.theme.PurplePrimary

@Composable
fun ListCharacterScreen(
    navController: NavController,
    viewModel: ListCharacterViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(Constants.TiTLE_LIST_CHARACTERS)
                }
            )
        },
        content = {
            bodyListCharacterScreen(navController = navController, state = state)
        }
    )



}

@Composable
fun bodyListCharacterScreen(navController:NavController, state: ListCharacterState){
    Column(modifier = Modifier.fillMaxSize()) {
        //TopAppBar(title = { Text(text = Constants.TiTLE_LIST_CHARACTERS) }, backgroundColor = PurplePrimary )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.characters){ character ->
                    ListItemCharacter(character = character, onItemClick = {
                        println("Pulsaste al character con ruta -> " + Constants.PathScreen.DETAIL_CHARACTER_SCREEN + "/" + character.charId)
                        navController.navigate(route = Constants.PathScreen.DETAIL_CHARACTER_SCREEN + "/" + character.charId)
                    })
                }
            }
            if(state.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            if(state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}