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

public class FamilyFragment extends Fragment {
    private AudioManager mAudioManager;
    View rootView;
    private MediaPlayer mediaPlayer;
    ArrayList<Word>wordsForFamily=new ArrayList<Word>();

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener= new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                FamilyFragment.this.releaseMediaPlayer();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.words_list,container,false);


    //Create and Setup the {@link AudioService} to request audio focus
    mAudioManager=(AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        wordsForFamily.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        wordsForFamily.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        wordsForFamily.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        wordsForFamily.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        wordsForFamily.add(new Word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        wordsForFamily.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        wordsForFamily.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        wordsForFamily.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        wordsForFamily.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        wordsForFamily.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

    WordAdapterCustom wordAdapterCustom = new WordAdapterCustom(getActivity(),wordsForFamily,R.color.category_family);

    ListView familyListView = (ListView) rootView.findViewById(R.id.words_List);
        familyListView.setAdapter(wordAdapterCustom);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            releaseMediaPlayer();

            int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                //We have audio focus now
                mediaPlayer = MediaPlayer.create(getActivity(), wordsForFamily.get(position).getMediaInfo());
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
    public void onStop(){
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
