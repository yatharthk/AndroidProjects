package com.example.android.miwok;

import android.view.View;

public class Word {
    private String mDefautTranslation;
    private String mMiwokTransalation;
    private int mImageSrc=-1;
    private int mediaInfo;

    public Word(String defaultTranslation,String miworkTranslation,int mediaInfoId){
        this.mDefautTranslation=defaultTranslation;
        this.mMiwokTransalation=miworkTranslation;
        this.mediaInfo=mediaInfoId;
    }

    public Word(String defaultTranslation,String miworkTranslation,int imageSrc,int mediaInfoId){
        this.mDefautTranslation=defaultTranslation;
        this.mMiwokTransalation=miworkTranslation;
        this.mImageSrc=imageSrc;
        this.mediaInfo=mediaInfoId;


    }
    public String getDefautTranslation(){
        return  this.mDefautTranslation;
    }

    public String getMiwokTransalation(){
        return this.mMiwokTransalation;
    }

    public int getmImageSrc(){return  this.mImageSrc; }

    public int getMediaInfo(){return  this.mediaInfo; }

    public boolean hasImage(){
        if(this.mImageSrc>0)
            return true;
        else
            return false;
    }
}
