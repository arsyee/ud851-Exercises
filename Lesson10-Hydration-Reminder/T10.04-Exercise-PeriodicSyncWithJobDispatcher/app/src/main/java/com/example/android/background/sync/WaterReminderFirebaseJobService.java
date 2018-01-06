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

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.firebase.jobdispatcher.Trigger;

import android.os.AsyncTask;
import android.util.Log;

public class WaterReminderFirebaseJobService extends JobService {
    // COMPLETED (3) WaterReminderFirebaseJobService should extend from JobService

    String TAG = WaterReminderFirebaseJobService.class.getSimpleName();

    // COMPLETED (5) By default, jobs are executed on the main thread, so make an anonymous class extending
    //  AsyncTask called mBackgroundTask.
    AsyncTask mBackgroundTask;

    // COMPLETED (4) Override onStartJob
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.d(TAG, "onStartJob() entered");
        // COMPLETED (9) Execute the AsyncTask
        mBackgroundTask = new AsyncTask() {
            // COMPLETED (6) Override doInBackground
            @Override
            protected Object doInBackground(Object[] objects) {
                Log.d(TAG, "doInBackground() entered");
                // COMPLETED (7) Use ReminderTasks to execute the new charging reminder task you made, use
                // this service as the context (WaterReminderFirebaseJobService.this) and return null
                // when finished.
                ReminderTasks.executeTask(WaterReminderFirebaseJobService.this, ReminderTasks.ACTION_CHARGING_REMINDER);
                return null;
            }

            // COMPLETED (8) Override onPostExecute and called jobFinished. Pass the job parameters
            // and false to jobFinished. This will inform the JobManager that your job is done
            // and that you do not want to reschedule the job.
            @Override
            protected void onPostExecute(Object o) {
                Log.d(TAG, "onPostExecute() entered");
                jobFinished(jobParameters, false);
            }
        };
        mBackgroundTask.execute(jobParameters);
        // COMPLETED (10) Return true
        return true;
    }

    // COMPLETED (11) Override onStopJob
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob() entered");
        // COMPLETED (12) If mBackgroundTask is valid, cancel it
        if (mBackgroundTask != null) mBackgroundTask.cancel(true);
        // COMPLETED (13) Return true to signify the job should be retried
        return true;
    }

}
