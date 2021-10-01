package pe.paku.brakingbad.presentation.detail_character

import pe.paku.brakingbad.domain.model.BadCharacterDetail

data class DetailCharacterState (
    val isLoading: Boolean = false,
    val character: BadCharacterDetail? = null,
    val error: String = ""
)