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
package com.example.android.version;


import android.os.Bundle;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * {@link MainActivity} shows a list of Android platform releases.
 * For each release, display the name, version number, and image.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of AndroidVersion objects
        ArrayList<AndroidVersion> androidVersions = new ArrayList<AndroidVersion>();
        androidVersions.add(new AndroidVersion("Donut", "1.6", R.drawable.donut));
        androidVersions.add(new AndroidVersion("Eclair", "2.0-2.1", R.drawable.eclair));
        androidVersions.add(new AndroidVersion("Froyo", "2.2-2.2.3", R.drawable.froyo));
        androidVersions.add(new AndroidVersion("GingerBread", "2.3-2.3.7", R.drawable.gingerbread));
        androidVersions.add(new AndroidVersion("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb));
        androidVersions.add(new AndroidVersion("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream));
        androidVersions.add(new AndroidVersion("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean));
        androidVersions.add(new AndroidVersion("KitKat", "4.4-4.4.4", R.drawable.kitkat));
        androidVersions.add(new AndroidVersion("Lollipop", "5.0-5.1.1", R.drawable.lollipop));
        androidVersions.add(new AndroidVersion("Marshmallow", "6.0-6.0.1", R.drawable.marshmallow));

        // Create an {@link AndroidVersionAdapter}, whose data source is a list of
        // {@link AndroidVersion}s. The adapter knows how to create list item views for each item
        // in the list.
        AndroidVersionAdapter flavorAdapter = new AndroidVersionAdapter(this, androidVersions);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_versions);
        listView.setAdapter(flavorAdapter);
    }
}
