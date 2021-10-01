package pe.paku.brakingbad.presentation.list_characters

import pe.paku.brakingbad.domain.model.BadCharacter

data class ListCharacterState (
    val isLoading: Boolean = false,
    val characters: List<BadCharacter> = emptyList(),
    val error: String = ""
)