package pe.paku.brakingbad.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.data.local.prefs.PrefsDataStore
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = Constants.Prefs.DATA_STORAGE_NAME)

class PrefsDataStoreImpl @Inject constructor(
    @ApplicationContext context: Context
) : PrefsDataStore{

    private val dataPrefs = context.dataStore

    override suspend fun setFavoriteCharacter(idCharacter: String, favorite: Boolean) {
        val keyfavorite = booleanPreferencesKey(idCharacter)
        dataPrefs.edit { prefs ->
            prefs[keyfavorite] = favorite
        }
    }

    override fun isFavoriteCharacter(idCharacter: String): Flow<Boolean> {
        val keyfavorite = booleanPreferencesKey(idCharacter)
        return dataPrefs.data.map { prefs ->
            prefs[keyfavorite] ?: false
        }
    }



}
