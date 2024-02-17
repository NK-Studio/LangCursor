package com.github.lauvsong.langcursor.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {

    private lateinit var settingsComponent : AppSettingsComponent

    override fun getDisplayName(): String =
        "LangCursor"

    override fun createComponent(): JComponent {
        settingsComponent = AppSettingsComponent()
        return settingsComponent.mainPanel
    }

    override fun isModified(): Boolean {
        val settings = AppSettingsState.instance

        return (settings.NotEnglishCursorColor != settingsComponent.NotEnglishCursorColor.selectedColor) || (settings.EnglishCursorColor != settingsComponent.EnglishCursorColor.selectedColor)
    }

    override fun apply() {
        val settings = AppSettingsState.instance
        settings.NotEnglishCursorColorAsRgb = settingsComponent.NotEnglishCursorColor.selectedColor?.rgb ?: settings.NotEnglishCursorColorAsRgb
        settings.EnglishCursorColorAsRgb = settingsComponent.EnglishCursorColor.selectedColor?.rgb ?: settings.EnglishCursorColorAsRgb
    }

    override fun reset() {
        val settings = AppSettingsState.instance
        settingsComponent.NotEnglishCursorColor.selectedColor = settings.NotEnglishCursorColor
        settingsComponent.EnglishCursorColor.selectedColor = settings.EnglishCursorColor

    }
}