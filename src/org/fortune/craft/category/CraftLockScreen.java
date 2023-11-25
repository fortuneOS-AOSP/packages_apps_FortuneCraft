/*
 * Copyright (C) 2024 FortuneOS
 * SPDX-License-Identifier: Apache-2.0
 */

package org.fortune.craft.category;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.fortune.OmniJawsClient;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CraftLockScreen extends SettingsPreferenceFragment
    implements Preference.OnPreferenceChangeListener {

    private static final String KEY_WEATHER = "lockscreen_weather_enabled";

    private Preference mWeather;
    private OmniJawsClient mWeatherClient;

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    addPreferencesFromResource(R.xml.craft_lockscreen);

    ContentResolver resolver = getActivity().getContentResolver();
    final PreferenceScreen prefScreen = getPreferenceScreen();
    Resources resources = getResources();

    mWeather = (Preference) findPreference(KEY_WEATHER);
    mWeatherClient = new OmniJawsClient(getContext());
    updateWeatherSettings();
  }

  public boolean onPreferenceChange(Preference preference, Object newValue) {
    ContentResolver resolver = getActivity().getContentResolver();

    return false;
  }

  private void updateWeatherSettings() {
        if (mWeatherClient == null || mWeather == null) return;

        boolean weatherEnabled = mWeatherClient.isOmniJawsEnabled();
        mWeather.setEnabled(weatherEnabled);
        mWeather.setSummary(weatherEnabled ? R.string.lockscreen_weather_summary :
            R.string.lockscreen_weather_enabled_info);
    }

  @Override
  public int getMetricsCategory() {
    return MetricsProto.MetricsEvent.FORTUNE;
  }
}
