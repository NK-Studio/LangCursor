package com.github.lauvsong.langcursor.settings

import com.intellij.ui.ColorPanel
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel

class AppSettingsComponent {
    val mainPanel: JPanel by lazy {
        FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Cursor color (English): "), EnglishCursorColor, 1, false)
            .addLabeledComponent(JBLabel("Cursor color (Other): "), NotEnglishCursorColor, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    val EnglishCursorColor: ColorPanel = ColorPanel()
    val NotEnglishCursorColor: ColorPanel = ColorPanel()
}