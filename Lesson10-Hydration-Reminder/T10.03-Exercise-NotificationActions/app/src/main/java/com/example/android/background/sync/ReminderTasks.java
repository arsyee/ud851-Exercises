/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.background.sync;

import android.content.Context;
import android.util.Log;

import com.example.android.background.utilities.NotificationUtils;
import com.example.android.background.utilities.PreferenceUtilities;

public class ReminderTasks {

    private static final String TAG = ReminderTasks.class.getSimpleName();

    public static final String ACTION_INCREMENT_WATER_COUNT = "increment-water-count";
    //  COMPLETED (2) Add a public static constant called ACTION_DISMISS_NOTIFICATION
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";

    public static void executeTask(Context context, String action) {
        Log.d(TAG, String.format("executeTask(%s)", action));
        if (ACTION_INCREMENT_WATER_COUNT.equals(action)) {
            Log.d(TAG, ACTION_INCREMENT_WATER_COUNT);
            incrementWaterCount(context);
        }
        if (ACTION_DISMISS_NOTIFICATION.equals(action)) {
            Log.d(TAG, ACTION_DISMISS_NOTIFICATION);
            //      COMPLETED (3) If the user ignored the reminder, clear the notification
            NotificationUtils.clearAllNotifications(context);
        }
    }

    private static void incrementWaterCount(Context context) {
        PreferenceUtilities.incrementWaterCount(context);
        //      COMPLETED (4) If the water count was incremented, clear any notifications
        NotificationUtils.clearAllNotifications(context);
    }
}