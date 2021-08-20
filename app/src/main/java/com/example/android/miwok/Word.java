package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

//the first constructors that contain only two parameters
    public Word(String defaultTranslation,String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
//the second constructors contain three parameters
    public Word(String defaultTranslation,String miwokTranslation,int defaultImageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = defaultImageResourceId;
    }

    public String getDefault(){
        return this.mDefaultTranslation;
    }

    public String getMiwok(){
        return this.mMiwokTranslation;
    }

    public int getImageResourceId() { return this.mImageResourceId; }

    //judge whether there is an image for this word or not
    public boolean hasImage(){ return mImageResourceId != NO_IMAGE_PROVIDED; }

    /**
    private boolean hasImage(int imageResourceId) {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
    */
}