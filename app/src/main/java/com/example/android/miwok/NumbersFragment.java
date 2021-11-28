package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class NumbersFragment extends Fragment {
    ArrayList<Word> words = new ArrayList<Word>();
    MediaPlayer mediaPlayer;
    AudioManager mAudioManager;
    View rootView;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
                mediaPlayer.seekTo(0);
            }
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                mediaPlayer.stop();
                releaseMediaPlayer();
            }
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
            }
        }
    };


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.words_list,container,false);
        // Inflate the layout for this fragment
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);



//        String [] numberNames= new String[10];
//        words[0]="one";words[1]="two";
//        words[2]="three";
//        words[3]="four"; words[4]="five";
//        words[5]="six"; words[6]="seven";
//        words[7]="eight"; words[8]="nine";
//        words[9]="ten";
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmpokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));


        displayText();
        return  rootView;

    }

    private MediaPlayer.OnCompletionListener mOnCompletionListener= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    private void displayText() {
        WordAdapterCustom wordAdapterCustom = new WordAdapterCustom(getActivity(), words, R.color.category_numbers);
        final ListView listView = (ListView) rootView.findViewById(R.id.words_List);
        listView.setAdapter(wordAdapterCustom);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Release the media player if it currently exists because we are ready to play the
                // different audio file.
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    //Create and setup the {@link MediapLayer} for audio resource associated with the
                    //current word.
                    mediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getMediaInfo());

                    //Start the audio file.
                    mediaPlayer.start();

                    //Setup a listener on the media player ,so that we can stop and release the media
                    // player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }

        });

    }



    @Override
    public void onStop() {
        super.onStop();
        //When activity is stopped ,  release the media player resources because,
        //we won't be playing any more sounds
        releaseMediaPlayer();

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            //release the audio focus here.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }
}