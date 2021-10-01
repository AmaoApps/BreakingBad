package pe.paku.brakingbad.domain.usecases.get_character_by_id

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.paku.brakingbad.common.Resource
import pe.paku.brakingbad.domain.model.BadCharacter
import pe.paku.brakingbad.domain.model.BadCharacterDetail
import pe.paku.brakingbad.domain.repository.BadCharacterRepository
import pe.paku.brakingbad.domain.repository.converters.toBadCharacter
import pe.paku.brakingbad.domain.repository.converters.toBadCharacterDetail
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: BadCharacterRepository
) {

    operator fun invoke(idCharacter: String) : Flow<Resource<BadCharacterDetail>> = flow {
        try {

            emit(Resource.Loading())
            val character = repository.getBadCharacter(idCharacter = idCharacter)
            if(character.size>0){
                emit(Resource.Success<BadCharacterDetail>(character.get(0).toBadCharacterDetail()))
            } else{
                emit(Resource.Error<BadCharacterDetail>("No se pudo obtener "))
            }


        } catch (e: HttpException){
            emit(Resource.Error<BadCharacterDetail>("Ocurrió un problema inesperado"))
        } catch (e: IOException){
            emit(Resource.Error<BadCharacterDetail>("Ocurrió un problema de conexión al servidor... Intente nuevamente"))
        }
    }

}