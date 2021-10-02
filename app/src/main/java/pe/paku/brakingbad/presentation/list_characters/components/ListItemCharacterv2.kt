package pe.paku.brakingbad.presentation.list_characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import pe.paku.brakingbad.R
import pe.paku.brakingbad.domain.model.BadCharacter
import pe.paku.brakingbad.presentation.ui.theme.PurplePrimary


@Composable
fun ListItemCharacterv2(
    character: BadCharacter,
    onItemClick: (BadCharacter) -> Unit
){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onItemClick(character) }
    ) {
        val (imgCharacter, infoCharacter, iconFavorite) = createRefs()
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
                .height(64.dp)
                .width(64.dp)
                .constrainAs(imgCharacter) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Column(
            modifier = Modifier
                .constrainAs(iconFavorite) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
            },
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            if (character.isFavorite)
                Image(
                    painter = painterResource(R.drawable.ic_heart),
                    contentDescription = character.name,
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                ) else
                Image(
                    painter = painterResource(R.drawable.ic_heart_unfill),
                    contentDescription = character.name,
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                )
        }
        Column(
            modifier = Modifier
                .padding(6.dp)
                .constrainAs(infoCharacter) {
                    top.linkTo(parent.top)
                    start.linkTo(imgCharacter.end)
                    end.linkTo(iconFavorite.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                },
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = character.nickname,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Start
            )
        }
    }
}
