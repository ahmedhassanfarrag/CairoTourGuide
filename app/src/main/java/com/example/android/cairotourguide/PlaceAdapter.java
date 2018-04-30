package com.example.android.cairotourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PlaceAdapter extends ArrayAdapter<Place> {
    //Resource Id for the background color for this list of places .
    private int mColorResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int ColorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, places);
        mColorResourceId = ColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitem, parent, false);
        }

        // Get the Songs object located at this position in the list
        Place Placelocation = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID song name.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.cairo_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(Placelocation.getmPlaceName());


        // Find the ImageView in the list_item.xml layout with the ID artist icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.Image);
        // Get the image resource ID from the current Songs object and
        // set the image to iconView
        iconView.setImageResource(Placelocation.getmPlaceImage());
        // set the theme color for the list item
        View textColor = listItemView.findViewById(R.id.back_color);
        // Find the color that the resource Id map to.
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // set the background color for the text container view.
        textColor.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
