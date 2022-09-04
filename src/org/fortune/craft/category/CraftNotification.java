/*
 * Copyright (C) 2024 FortuneOS
 * SPDX-License-Identifier: Apache-2.0
 */

package org.fortune.craft.category;

import android.os.Bundle;
import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class CraftNotification extends SettingsPreferenceFragment {

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    addPreferencesFromResource(R.xml.craft_notifications);
  }

  @Override
  public int getMetricsCategory() {
    return MetricsProto.MetricsEvent.FORTUNE;
  }
}
