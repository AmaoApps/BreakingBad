package pe.paku.brakingbad.domain.repository.converters

import pe.paku.brakingbad.data.remote.dto.BadCharacterDTO
import pe.paku.brakingbad.domain.model.BadCharacter
import pe.paku.brakingbad.domain.model.BadCharacterDetail

fun BadCharacterDTO.toBadCharacter(): BadCharacter {
    return BadCharacter(
        charId = charId,
        name = name,
        nickname = nickname,
        img = img,
        isFavorite = false
    )
}

fun BadCharacterDTO.toBadCharacterDetail(): BadCharacterDetail {
    return BadCharacterDetail(
        charId = charId,
        name = name,
        nickname = nickname,
        img = img,
        occupation = occupation,
        status = status,
        portrayed = portrayed,
        isFavorite = false
    )
}