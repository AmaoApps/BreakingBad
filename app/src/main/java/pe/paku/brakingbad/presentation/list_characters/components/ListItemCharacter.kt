package pe.paku.brakingbad.presentation.list_characters.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pe.paku.brakingbad.domain.model.BadCharacter

@Composable
fun ListItemCharacter(
    character: BadCharacter,
    onItemClick: (BadCharacter) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
           Text(
               text = character.name,
               style = MaterialTheme.typography.h5,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Start
           )
           Text(
               text = character.nickname,
               style = MaterialTheme.typography.body2,
               textAlign = TextAlign.Start
           )
        }


    }
}
