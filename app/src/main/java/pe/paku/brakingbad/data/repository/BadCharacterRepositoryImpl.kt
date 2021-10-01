package pe.paku.brakingbad.data.repository

import pe.paku.brakingbad.data.remote.BreakingBadApi
import pe.paku.brakingbad.data.remote.dto.BadCharacterDTO
import pe.paku.brakingbad.domain.repository.BadCharacterRepository
import javax.inject.Inject

class BadCharacterRepositoryImpl @Inject constructor(
    private val api : BreakingBadApi
) : BadCharacterRepository {
    override suspend fun getListCharacters(): List<BadCharacterDTO> {
        return api.getCharacters()
    }

    override suspend fun getBadCharacter(idCharacter: String): List<BadCharacterDTO> {
        return api.getCharacterById(idCharacter = idCharacter)
    }

}