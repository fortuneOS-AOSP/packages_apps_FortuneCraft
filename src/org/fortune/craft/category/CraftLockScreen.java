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
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CraftLockScreen extends SettingsPreferenceFragment
    implements Preference.OnPreferenceChangeListener {

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    addPreferencesFromResource(R.xml.craft_lockscreen);

    ContentResolver resolver = getActivity().getContentResolver();
    final PreferenceScreen prefScreen = getPreferenceScreen();
    Resources resources = getResources();
  }

  public boolean onPreferenceChange(Preference preference, Object newValue) {
    ContentResolver resolver = getActivity().getContentResolver();

    return false;
  }

  @Override
  public int getMetricsCategory() {
    return MetricsProto.MetricsEvent.FORTUNE;
  }
}
