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

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback because your Audio Focus was
                        // temporarily stolen, but will be back soon.
                        // i.e. for a phone call
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Stop playback, because you lost the Audio Focus.
                        // i.e. the user started some other playback app
                        // Remember to unregister your controls/buttons here.
                        // And release the kra — Audio Focus!
                        // You’re done.
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback, because you hold the Audio Focus
                        // again!
                        // i.e. the phone call ended or the nav directions
                        // are finished
                        // If you implement ducking and lower the volume, be
                        // sure to return it to normal here, as well.
                        mMediaPlayer.start();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    releaseMediaPlayer();
                }
            };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("one", "lutti",
                R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("two", "otiiko",
                R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("three", "tolookosu",
                R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("four", "oyyisa",
                R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("five", "massokka",
                R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("six", "temmokka",
                R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("seven", "kenekaku",
                R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("eight", "kawinta",
                R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("nine", "wo'e",
                R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("ten", "na'aacha",
                R.drawable.number_ten, R.raw.number_ten));

        /**
         * 第一个参数是上下文，就是当前的Activity;
         * 第二个参数是android sdk中自己内置的一个布局，
         * 它里面只有一个TextView，这个参数是表明我们数组中每一条数据的布局是这个view，
         * 就是将每一条数据都显示在这个view上面;
         * 第三个参数就是我们要显示的数据。listView会根据这三个参数，遍历adapterData里面的每一条数据，读出一条，
         * 显示到第二个参数对应的布局中，这样就形成了我们看到的listView;
         */
        WordAdapter itemsAdapter = new WordAdapter(this,
                numbers,
                R.color.category_numbers);
        //此处对应ListView视图，作为容器（列表），用于装载&显示数据，
        // 容器内的具体数据（列表项Item）则是由适配器（Adapter）提供
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                releaseMediaPlayer();
                // parent是识别是哪个listview；
                // view是当前listview的item的view的布局，就是可以用这个view，获取里面的控件的id后操作控件
                // position是当前item在listview中适配器里的位置
                // id是当前item在listview里的第几行的位置
                Word word = numbers.get(position);

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this,
                            word.getSoundResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }
}
