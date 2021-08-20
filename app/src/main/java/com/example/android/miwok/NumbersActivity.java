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
package com.example.android.miwok;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("one","lutti",R.drawable.number_one));
        numbers.add(new Word("two","otiiko",R.drawable.number_two));
        numbers.add(new Word("three","tolookosu",R.drawable.number_three));
        numbers.add(new Word("four","oyyisa",R.drawable.number_four));
        numbers.add(new Word("five","massokka",R.drawable.number_five));
        numbers.add(new Word("six","temmokka",R.drawable.number_six));
        numbers.add(new Word("seven","kenekaku",R.drawable.number_seven));
        numbers.add(new Word("eight","kawinta",R.drawable.number_eight));
        numbers.add(new Word("nine","wo'e",R.drawable.number_nine));
        numbers.add(new Word("ten","na'aacha",R.drawable.number_ten));

        /**
         * 第一个参数是上下文，就是当前的Activity;
         * 第二个参数是android sdk中自己内置的一个布局，它里面只有一个TextView，这个参数是表明我们数组中每一条数据的布局是这个view，
         * 就是将每一条数据都显示在这个view上面;
         * 第三个参数就是我们要显示的数据。listView会根据这三个参数，遍历adapterData里面的每一条数据，读出一条，
         * 显示到第二个参数对应的布局中，这样就形成了我们看到的listView;
         */
        WordAdapter itemsAdapter = new WordAdapter(this,numbers,R.color.category_numbers);
        //此处对应ListView视图，作为容器（列表），用于装载&显示数据，容器内的具体数据（列表项Item）则是由适配器（Adapter）提供
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        /**
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView); //find rootView and store in rootView
        TextView wordView = new TextView(this); //create a TextViews object and store in wordView
        wordView.setText(numbers.get(0)); //let TextView display the String that stored in the list
        rootView.addView(wordView); //add wordView as child of rootView
        */

        /**
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
        for(int index = 0; index < numbers.size(); index++){
            TextView wordView = new TextView(this);
            wordView.setText(numbers.get(index));
            rootView.addView(wordView);
        }
        */


        /**
        int index = 0;
        while (index < numbers.size()) {
            TextView wordView = new TextView(this);
            wordView.setText(numbers.get(index));
            rootView.addView(wordView);
            index++;
        }
        */

        /**
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(0));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(1));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(2));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(3));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(4));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(5));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(6));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(7));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(8));
        Log.v("NumbersActivity","Word at index 0: " + numbers.get(9));
        */


        /**
        String[] englishNumbers = new String[10];
        englishNumbers[0] = "One";
        englishNumbers[1] = "Two";
        englishNumbers[2] = "Three";
        englishNumbers[3] = "Four";
        englishNumbers[4] = "Five";
        englishNumbers[5] = "Six";
        englishNumbers[6] = "Seven";
        englishNumbers[7] = "Eight";
        englishNumbers[8] = "Nine";
        englishNumbers[9] = "Ten";

        Log.v("NumbersActivity","Word at index 0: " + englishNumbers[0]);
        Log.v("NumbersActivity","Word at index 1: " + englishNumbers[1]);
        Log.v("NumbersActivity","Word at index 2: " + englishNumbers[2]);
        Log.v("NumbersActivity","Word at index 3: " + englishNumbers[3]);
        Log.v("NumbersActivity","Word at index 4: " + englishNumbers[4]);
        Log.v("NumbersActivity","Word at index 5: " + englishNumbers[5]);
        Log.v("NumbersActivity","Word at index 6: " + englishNumbers[6]);
        Log.v("NumbersActivity","Word at index 7: " + englishNumbers[7]);
        Log.v("NumbersActivity","Word at index 8: " + englishNumbers[8]);
        Log.v("NumbersActivity","Word at index 9: " + englishNumbers[9]);
         */
    }
}
