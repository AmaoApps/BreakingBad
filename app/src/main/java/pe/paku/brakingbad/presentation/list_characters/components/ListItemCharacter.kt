package pe.paku.brakingbad.presentation.list_characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import pe.paku.brakingbad.R
import pe.paku.brakingbad.domain.model.BadCharacter
import pe.paku.brakingbad.presentation.ui.theme.PurpleSecondary

@Composable
fun ListItemCharacter(
    character: BadCharacter,
    onItemClick: (BadCharacter) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onItemClick(character) },
        //horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(
                data = character.img,
                builder = {
                    transformations(CircleCropTransformation())
                    crossfade(true)
                }
            ),
            contentDescription = character.img,
            modifier = Modifier
                .weight(1f)
                .height(64.dp)
                .width(64.dp)
        )
        Column(
            modifier = Modifier
                .padding(6.dp)
                .weight(3f)
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
        if (character.isFavorite)
            Image(
                painter = painterResource(R.drawable.ic_heart),
                contentDescription = character.name,
                modifier = Modifier
                    .weight(1f)
                    .height(32.dp)
                    .width(32.dp)
            ) else
            Image(
                painter = painterResource(R.drawable.ic_heart_unfill),
                contentDescription = character.name,
                modifier = Modifier
                    .weight(0.5f)
                    .height(32.dp)
                    .width(32.dp)
            )



    }
}
