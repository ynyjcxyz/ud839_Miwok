package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mSoundResourceId;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

//the first constructors that contain only two parameters
    public Word(String defaultTranslation,String miwokTranslation,
                int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundResourceId = soundResourceId;
    }
//the second constructors contain three parameters
    public Word(String defaultTranslation,String miwokTranslation,
                int defaultImageResourceId,
                int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = defaultImageResourceId;
        mSoundResourceId = soundResourceId;
    }

    public String getDefault(){
        return this.mDefaultTranslation;
    }

    public String getMiwok(){
        return this.mMiwokTranslation;
    }

    public int getImageResourceId() { return this.mImageResourceId; }

    public int getSoundResourceId(){return this.mSoundResourceId;}

    //judge whether there is an image for this word or not
    public boolean hasImage(){ return mImageResourceId != NO_IMAGE_PROVIDED; }

    /**
    private boolean hasImage(int imageResourceId) {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
    */

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mSoundResourceId=" + mSoundResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}