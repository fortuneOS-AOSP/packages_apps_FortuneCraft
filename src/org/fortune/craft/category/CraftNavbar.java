/*
 * Copyright (C) 2024 FortuneOS
 * SPDX-License-Identifier: Apache-2.0
 */

package org.fortune.craft.category;

import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CraftNavbar extends SettingsPreferenceFragment implements OnPreferenceChangeListener {

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    addPreferencesFromResource(R.xml.craft_navigation);
  }

  @Override
  public boolean onPreferenceChange(Preference preference, Object newValue) {

    return false;
  }

  @Override
  public int getMetricsCategory() {
    return MetricsProto.MetricsEvent.FORTUNE;
  }
}
