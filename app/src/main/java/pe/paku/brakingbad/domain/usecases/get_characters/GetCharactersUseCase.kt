package pe.paku.brakingbad.domain.usecases.get_characters

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import pe.paku.brakingbad.common.Resource
import pe.paku.brakingbad.data.local.prefs.PrefsDataStore
import pe.paku.brakingbad.domain.model.BadCharacter
import pe.paku.brakingbad.domain.repository.BadCharacterRepository
import pe.paku.brakingbad.domain.repository.converters.toBadCharacter
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: BadCharacterRepository,
    private val prefStorage: PrefsDataStore
) {

    operator fun invoke() : Flow<Resource<List<BadCharacter>>> = flow {

        try {
            emit(Resource.Loading())
            val listCharacters = repository.getListCharacters().map { it.toBadCharacter() }
            listCharacters.forEach {
                it.isFavorite = prefStorage.isFavoriteCharacter(it.charId.toString()).first()
            }
            emit(Resource.Success<List<BadCharacter>>(listCharacters))
        } catch (e: HttpException){
            emit(Resource.Error<List<BadCharacter>>("Ocurrió un error inesperado"))
        } catch (e: IOException){
            emit(Resource.Error<List<BadCharacter>>("No se pudo conectar al Servidor... Intente nuevamente"))
        }



    }

}