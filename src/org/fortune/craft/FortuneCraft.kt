/*
 * Copyright (C) 2024 FortuneOS
 * SPDX-License-Identifier: Apache-2.0
 */

package org.fortune.craft

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import com.android.internal.logging.nano.MetricsProto
import com.android.settings.R
import com.android.settings.SettingsPreferenceFragment

class FortuneCraft : SettingsPreferenceFragment() {

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        addPreferencesFromResource(R.xml.craft)
    }

    override fun getMetricsCategory(): Int {
        return MetricsProto.MetricsEvent.FORTUNE
    }

    companion object {
        fun lockCurrentOrientation(activity: Activity) {
            val currentRotation = activity.windowManager.defaultDisplay.rotation
            val orientation = activity.resources.configuration.orientation
            val frozenRotation: Int = when (currentRotation) {
                Surface.ROTATION_0 -> if (orientation == Configuration.ORIENTATION_LANDSCAPE)
                    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                else
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                Surface.ROTATION_90 -> if (orientation == Configuration.ORIENTATION_PORTRAIT)
                    ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
                else
                    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                Surface.ROTATION_180 -> if (orientation == Configuration.ORIENTATION_LANDSCAPE)
                    ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
                else
                    ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
                Surface.ROTATION_270 -> if (orientation == Configuration.ORIENTATION_PORTRAIT)
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                else
                    ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
                else -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            }
            activity.requestedOrientation = frozenRotation
        }
    }
}
