package pe.paku.brakingbad.presentation.detail_character

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pe.paku.brakingbad.common.Constants
import pe.paku.brakingbad.common.Resource
import pe.paku.brakingbad.domain.usecases.get_character_by_id.GetCharacterByIdUseCase
import javax.inject.Inject

@HiltViewModel
class DetailCharacterViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(DetailCharacterState())
    val state : State<DetailCharacterState> = _state

    init {
        savedStateHandle.get<String>(Constants.PathScreen.PARAMS.PARAM_ID_CHARACTER)?.let {
            getDetailChracter(it)
        }
    }

    fun getDetailChracter(idChracter: String){
        getCharacterByIdUseCase.invoke(idCharacter = idChracter).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = DetailCharacterState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = DetailCharacterState(character = result.data)
                }
                is Resource.Error -> {
                    _state.value = DetailCharacterState(error = "Se encontró un error")
                }
            }
        }.launchIn(viewModelScope)
    }

}