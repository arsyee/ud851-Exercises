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

package com.example.android.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class AddTaskActivity extends AppCompatActivity {

    // Declare a member variable to keep track of a task's selected mPriority
    private int mPriority;

    RadioButton rPriority1;
    RadioButton rPriority2;
    RadioButton rPriority3;
    Button bPriority1;
    Button bPriority2;
    Button bPriority3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        rPriority1 = (RadioButton) findViewById(R.id.radButton1);
        rPriority2 = (RadioButton) findViewById(R.id.radButton2);
        rPriority3 = (RadioButton) findViewById(R.id.radButton3);
        bPriority1 = (Button) findViewById(R.id.buttonP1);
        bPriority2 = (Button) findViewById(R.id.buttonP2);
        bPriority3 = (Button) findViewById(R.id.buttonP3);
        // Initialize to highest mPriority by default (mPriority = 1)
        ((RadioButton) findViewById(R.id.radButton1)).setChecked(true);
        mPriority = 1;
    }


    /**
     * onClickAddTask is called when the "ADD" button is clicked.
     * It retrieves user input and inserts that new task data into the underlying database.
     */
    public void onClickAddTask(View view) {
        // Not yet implemented
    }


    /**
     * onPrioritySelected is called whenever a priority button is clicked.
     * It changes the value of mPriority based on the selected button.
     */
    public void onPrioritySelected(View view) {
        if (view.equals(bPriority1)) {
            rPriority1.setChecked(true);
        } else if (view.equals(bPriority2)) {
            rPriority2.setChecked(true);
        } else if (view.equals(bPriority3)) {
            rPriority3.setChecked(true);
        }

        if (rPriority1.isChecked()) {
            mPriority = 1;
        } else if (rPriority2.isChecked()) {
            mPriority = 2;
        } else if (rPriority3.isChecked()) {
            mPriority = 3;
        }
    }
}
