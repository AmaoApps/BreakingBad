package pe.paku.brakingbad.presentation.list_characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pe.paku.brakingbad.common.Resource
import pe.paku.brakingbad.domain.usecases.get_characters.GetCharactersUseCase
import javax.inject.Inject

@HiltViewModel
class ListCharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ListCharacterState())
    val state : State<ListCharacterState> = _state

    init {
        getListCharacters()
    }

    private fun getListCharacters(){
        getCharactersUseCase.invoke().onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = ListCharacterState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ListCharacterState(characters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ListCharacterState(error = result.message ?: "Un error inesperado ha ocurrido...")
                }
            }
        }.launchIn(viewModelScope)
    }

}