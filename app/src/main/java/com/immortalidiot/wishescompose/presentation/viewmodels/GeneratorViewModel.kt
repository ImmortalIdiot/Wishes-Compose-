package com.immortalidiot.wishescompose.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.wishescompose.logic.ClipboardCopier
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
    private val clipboardCopier: ClipboardCopier,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        GeneratorModel(emojis = 0)
    )

    val uiState: StateFlow<GeneratorModel> = _uiState.asStateFlow()

    fun changeNumberEmojis(emojis: Int) {
        _uiState.update { uiState.value.copy(emojis = emojis) }
    }

    fun generateEmojisAndCopy(emojis: Int) {
        viewModelScope.launch {
            clipboardCopier.copy(
                context = context,
                copiedMessage = emojiGenerator.generate(emojis)
            )
        }
    }

    fun generateDayWishAndCopy(emojis: Int) {
        viewModelScope.launch {
            clipboardCopier.copy(
                context = context,
                copiedMessage = wishGenerator.generateDayWish() + emojiGenerator.generate(emojis)
            )
        }
    }

    fun generateNightWishAndCopy(emojis: Int) {
        viewModelScope.launch {
            clipboardCopier.copy(
                context = context,
                copiedMessage = wishGenerator.generateNightWish() + emojiGenerator.generate(emojis)
            )
        }
    }
}
