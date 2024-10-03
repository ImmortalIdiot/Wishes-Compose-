package com.immortalidiot.wishescompose.presentation.viewmodels

import android.content.Context
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.wishescompose.logic.ClipboardHandler
import com.immortalidiot.wishescompose.logic.EmojiGenerator
import com.immortalidiot.wishescompose.logic.WishGenerator
import com.immortalidiot.wishescompose.ui.models.GeneratorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(
    private val emojiGenerator: EmojiGenerator,
    private val wishGenerator: WishGenerator,
    private val clipboardHandler: ClipboardHandler,
    @ApplicationContext private val context: Context
) : ViewModel() {

    @Immutable
    sealed class State {
        data object Init : State()
        data object Success : State()
        data class Error(val message: String) : State()
    }

    var mutableStateFlow = MutableStateFlow<State>(State.Init)
        private set

    private val _uiState = MutableStateFlow(
        GeneratorModel(emojis = String())
    )

    val uiState: StateFlow<GeneratorModel> = _uiState.asStateFlow()

    fun resetState() = mutableStateFlow.update { State.Init }

    private fun updateStateWithError(errorMessage: String = DEFAULT_ERROR_MESSAGE) =
        mutableStateFlow.update { State.Error(errorMessage) }

    private fun updateStateWithSuccess() = mutableStateFlow.update { State.Success }

    fun changeNumberEmojis(emojis: String) {
        _uiState.update { uiState.value.copy(emojis = emojis) }
    }

    fun generateEmojisAndCopy(numberEmojis: String) {
        if (isInputValid(numberEmojis)) {
            val emojis = castStringToInt(numberEmojis)
            copyGeneratedWish {
                emojiGenerator.generate(emojis)
            }
        } else { updateStateWithError() }
    }

    fun generateDayWishAndCopy(numberEmojis: String) {
        if (isInputValid(numberEmojis)) {
            val emojis = castStringToInt(numberEmojis)
            copyGeneratedWish {
                wishGenerator.generateDayWish() + emojiGenerator.generate(emojis)
            }
        } else { updateStateWithError() }
    }

    fun generateNightWishAndCopy(numberEmojis: String) {
        if (isInputValid(numberEmojis)) {
            val emojis = castStringToInt(numberEmojis)
            copyGeneratedWish {
                wishGenerator.generateNightWish() + emojiGenerator.generate(emojis)
            }
        } else { updateStateWithError() }
    }

    private fun copyGeneratedWish(generateWish: suspend () -> String) {
        viewModelScope.launch {
            clipboardHandler.copy(context = context, copiedMessage = generateWish())
            updateStateWithSuccess()
        }
    }

    private fun isInputValid(emojis: String): Boolean = isNotEmptyField(emojis)

    private fun isNotEmptyField(string: String): Boolean = string.isNotEmpty()

    private fun castStringToInt(string: String): Int = string.toInt()

    companion object {
        private const val DEFAULT_ERROR_MESSAGE = "Введите количество эмоджи"
    }
}
