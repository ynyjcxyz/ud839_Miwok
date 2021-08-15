package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word(String defaultTranslation,String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefault(){
        return this.mDefaultTranslation;
    }

    public String getMiwok(){
        return this.mMiwokTranslation;
    }
}
