/*
 * Copyright (C) 2024 FortuneOS
 * SPDX-License-Identifier: Apache-2.0
 */

package org.fortune.craft.category;

import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceScreen;
import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CraftStatusBar extends SettingsPreferenceFragment
    implements OnPreferenceChangeListener {

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    addPreferencesFromResource(R.xml.craft_statusbar);

    PreferenceScreen prefSet = getPreferenceScreen();
  }

  @Override
  public boolean onPreferenceChange(Preference preference, Object objValue) {

    return false;
  }

  @Override
  public int getMetricsCategory() {
    return MetricsProto.MetricsEvent.FORTUNE;
  }
}
