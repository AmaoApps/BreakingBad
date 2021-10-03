package pe.paku.brakingbad.presentation.detail_character.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.paku.brakingbad.common.Constants


@Composable
fun ItemDetailCharacter(
    itemLabel: String,
    description: List<String>
){
    val valueDescription : StringBuilder = StringBuilder(Constants.EMPTY_STRING)
    description.forEach {
        if(valueDescription.toString() == Constants.EMPTY_STRING) valueDescription.append(it) else valueDescription.append(", $it")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = itemLabel,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(3f)
        )
        Text(
            text = valueDescription.toString(),
            maxLines = 5,
            modifier = Modifier
                .weight(7f)
        )

    }
}