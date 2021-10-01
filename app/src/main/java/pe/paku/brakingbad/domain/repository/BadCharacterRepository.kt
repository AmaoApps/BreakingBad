package pe.paku.brakingbad.domain.repository

import pe.paku.brakingbad.data.remote.dto.BadCharacterDTO

interface BadCharacterRepository {

    suspend fun getListCharacters() : List<BadCharacterDTO>

    suspend fun getBadCharacter(idCharacter: String) : List<BadCharacterDTO>

}