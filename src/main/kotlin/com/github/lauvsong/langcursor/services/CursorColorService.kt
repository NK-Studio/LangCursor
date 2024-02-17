package com.github.lauvsong.langcursor.services

import com.github.lauvsong.langcursor.settings.AppSettingsState
import com.github.lauvsong.langcursor.utils.CursorColorUtil

object CursorColorService {

    fun toNotEnglishCursorColor() {
        val settings = AppSettingsState.instance
        CursorColorUtil.setGlobalCursorColor(settings.NotEnglishCursorColor)
    }

    fun toEnglishCursorColor() {
        val settings = AppSettingsState.instance
        CursorColorUtil.setGlobalCursorColor(settings.EnglishCursorColor)
    }
}
