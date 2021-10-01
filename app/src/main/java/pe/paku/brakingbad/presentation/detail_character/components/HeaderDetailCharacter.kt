package pe.paku.brakingbad.presentation.detail_character.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pe.paku.brakingbad.R
import pe.paku.brakingbad.domain.model.BadCharacterDetail

@Composable
fun HeaderDetailCharacter(
    characterDetail: BadCharacterDetail
){
    Row(modifier = Modifier
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = characterDetail.name)
        if(characterDetail.isFavorite)
            Image(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = characterDetail.name,
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            ) else
            Image(
                painter = painterResource(id = R.drawable.ic_heart_unfill),
                contentDescription = characterDetail.name,
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
    }
}