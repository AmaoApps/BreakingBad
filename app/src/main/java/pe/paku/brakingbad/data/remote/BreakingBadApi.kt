package pe.paku.brakingbad.data.remote

import pe.paku.brakingbad.data.remote.dto.BadCharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadApi {

    @GET("characters")
    suspend fun getCharacters() : List<BadCharacterDTO>

    @GET("characters/{idCharacter}")
    suspend fun getCharacterById(@Path("idCharacter") idCharacter: String) : List<BadCharacterDTO>

}