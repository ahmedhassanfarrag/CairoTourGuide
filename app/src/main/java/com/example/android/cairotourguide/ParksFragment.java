package com.example.android.cairotourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.placeslist, container, false);
        // Create an ArrayList of places objects
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.park_name1), R.drawable.family_park, getString(R.string.park_name1), R.drawable.family_park, getString(R.string.park_INFO1), getString(R.string.park_name1), getString(R.string.phone_park_1)));
        places.add(new Place(getString(R.string.park_name2), R.drawable.gabalaya_park_and_aquarium, getString(R.string.park_name_without_space), R.drawable.gabalaya_park_and_aquarium, getString(R.string.park_INFO2), getString(R.string.park_name_without_space), getString(R.string.phone_park_2)));
        places.add(new Place(getString(R.string.park_name3), R.drawable.azhar_park, getString(R.string.park_name3), R.drawable.azhar_park, getString(R.string.park_INFO3), getString(R.string.park_name3), getString(R.string.phone_park_3)));


        // Create an placeAdapter, whose data source is a list of
        //  places . The adapter knows how to create list item views for each item
        // in the list.

        PlaceAdapter AdaptorForPlace = new PlaceAdapter(getActivity(), places, R.color.category_parks);

        // Get a reference to the ListView, and attach the adapter to the listView.

        final ListView ListView = (ListView) rootView.findViewById(R.id.list);

        ListView.setAdapter(AdaptorForPlace);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link place} object at the given position the user clicked on.
                Place location = places.get(position);
                // get Category activity .
                Intent info = new Intent(getActivity(), Category.class);
                info.putExtra(getString(R.string.put_extra_1), location.getmMuseumName());
                info.putExtra(getString(R.string.put_extra_3), location.getmMuseumImage());
                info.putExtra(getString(R.string.put_extra_2), location.getmMuseumInfo());
                info.putExtra(getString(R.string.put_extra_4), location.getmLocation());
                info.putExtra(getString(R.string.put_extra_5), location.getmNumber());
                startActivity(info);

            }
        });
        return rootView;
    }

}
