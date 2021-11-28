package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapterCustom extends ArrayAdapter<Word> {

    private int mBackgroudThemeColor;
    public WordAdapterCustom(Activity context, ArrayList<Word> words,int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.mBackgroudThemeColor=color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            //this line will set the background for the whole activity screen which can hide the padding.
            //not using fot this case
//            listItemView.setBackgroundColor(mBackgroudThemeColor);
        }


        //Get the @link word object at this position in the list
        final Word word = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the english word from the current Word object and
        // set this text on the default TextView
        defaultTranslationTextView.setText(word.getDefautTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok name from the current Word object and
        // set this text on the miwok TextView
        miwokTranslationTextView.setText(word.getMiwokTransalation());




        ImageView imageView= (ImageView)listItemView.findViewById(R.id.imageLeft);
        if(word.hasImage()){
            imageView.setImageResource(word.getmImageSrc());
            imageView.setVisibility(ImageView.VISIBLE);
        }
        else{imageView.setVisibility(ImageView.GONE);}


        View textContainer=listItemView.findViewById(R.id.list_view_text_container);
        //this line make sures the context got the color and is set for use in activity
        int color= ContextCompat.getColor(this.getContext(),mBackgroudThemeColor);
        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
