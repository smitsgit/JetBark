package com.example.androidtemplate

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger
import logcat.LogPriority

@HiltAndroidApp
class TemplateApp: Application() {
    override fun onCreate() {
        super.onCreate()

        // Log all priorities in debug builds, no-op in release builds.
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
    }
}