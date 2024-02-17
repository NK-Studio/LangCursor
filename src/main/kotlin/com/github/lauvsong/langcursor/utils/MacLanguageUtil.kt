package com.github.lauvsong.langcursor.utils

import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Pointer
import java.io.BufferedReader
import java.io.InputStreamReader

class MacLanguageUtil  {
    fun isEnglish(): Boolean{
        try {
            val classLoader: ClassLoader = MacLanguageUtil::class.java.getClassLoader()
            val file = classLoader.getResource("MacLanguageUtility")

            val command = file?.path

            val processBuilder = ProcessBuilder(command)
            val process = processBuilder.start()

            val reader = BufferedReader(InputStreamReader(process.inputStream))

            var line: String?
            while (reader.readLine().also { line = it } != null) {
                if (line.toString().contains("com.apple.keylayout.ABC") or line.toString().contains("com.apple.keylayout.US")) {
                    return true
                }
            }

            process.waitFor()
            process.destroy()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return true
    }

    companion object {
        val INSTANCE: MacLanguageUtil = MacLanguageUtil()
    }
}