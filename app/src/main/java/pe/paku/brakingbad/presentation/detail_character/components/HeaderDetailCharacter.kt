package pe.paku.brakingbad.presentation.detail_character.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import pe.paku.brakingbad.R
import pe.paku.brakingbad.domain.model.BadCharacterDetail
import pe.paku.brakingbad.presentation.ui.theme.OrangeAccent
import pe.paku.brakingbad.presentation.ui.theme.PurplePrimary

@Composable
fun HeaderDetailCharacter(
    characterDetail: BadCharacterDetail
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .weight(.3f)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = characterDetail.img,
                    builder = {
                        transformations(RoundedCornersTransformation(
                            topLeft = 20f,
                            topRight = 20f,
                            bottomLeft = 20f,
                            bottomRight = 20f)
                        )
                    }
                ),
                contentDescription = characterDetail.img
            )
            Box( modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20f))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 60f
                    )
                )
            )
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(4.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(
                    text = characterDetail.nickname,
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Text(
            text = characterDetail.name,
            modifier = Modifier
                .fillMaxWidth()
                .weight(.6f)
                .padding(8.dp)
        )
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