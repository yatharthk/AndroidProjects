package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {

    View rootView;
    ArrayList<Word> wordsForColors = new ArrayList<Word>();
    private AudioManager mAudioManager;
    MediaPlayer mediaPlayer;


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT|| focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange== AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.words_list,container,false);

        mAudioManager=(AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        wordsForColors.add(new Word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        wordsForColors.add(new Word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        wordsForColors.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        wordsForColors.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        wordsForColors.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        wordsForColors.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));
        wordsForColors.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        wordsForColors.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapterCustom wordAdapterCustom = new WordAdapterCustom(getActivity(), wordsForColors,R.color.category_colors);
        ListView familyListView = (ListView) rootView.findViewById(R.id.words_List);
        familyListView.setAdapter(wordAdapterCustom);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), wordsForColors.get(position).getMediaInfo());
                    mediaPlayer.start();

                    //Setup a listener on the media player ,so that we can stop and release the media
                    // player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
        return rootView;
    }
    MediaPlayer.OnCompletionListener mOnCompletionListener= new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
            //release the audio focus here
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}




