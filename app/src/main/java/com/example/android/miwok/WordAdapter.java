package com.example.android.miwok;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context,
                       ArrayList<Word> words,
                       int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        /**
         private boolean hasImage(int imageResourceId) {
         return imageResourceId != -1;
         }
         */

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon_of_theme);
        int imageResourceId = currentWord.getImageResourceId();
        if (currentWord.hasImage()) {
            iconView.setVisibility(View.VISIBLE);
            iconView.setImageResource(imageResourceId);
        } else {
            iconView.setVisibility(View.GONE);
        }

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwok());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefault());

        View listItem = listItemView.findViewById(R.id.list_item);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        listItem.setBackgroundColor(color);

        /**
         The setBackgroundColor() method accepts an int that is supposed to be
         a color value in aarrggbb format.The resource ID R.color.category_numbers is also an int,
         but it is not a color value; instead it is the identifier of a color resource.
         Calling ContextCompat.getColor(getContext(),mColorResourceId)
         retrieves the actual color value corresponding to mColorResourceId.
         */

        return listItemView;
    }

}