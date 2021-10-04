package pe.paku.brakingbad.data.local.prefs

import kotlinx.coroutines.flow.Flow


interface PrefsDataStore {

    fun isFavoriteCharacter(idCharacter: String): Flow<Boolean>

    suspend fun setFavoriteCharacter(idCharacter: String, favorite: Boolean)

}