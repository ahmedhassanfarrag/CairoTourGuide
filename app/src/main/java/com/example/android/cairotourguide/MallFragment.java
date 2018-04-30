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
public class MallFragment extends Fragment {


    public MallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.placeslist, container, false);
        // Create an ArrayList of places objects
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.mall_name1), R.drawable.cairo_festival_city_mall_, getString(R.string.mall_name1), R.drawable.cairo_festival_city_mall_, getString(R.string.mall_INFO1), getString(R.string.mall_name1), getString(R.string.phone_mall_1)));
        places.add(new Place(getString(R.string.mall_name2), R.drawable.city_stars_mall_, getString(R.string.mall_name2), R.drawable.city_stars_mall_, getString(R.string.mall_INFO2), getString(R.string.mall_name2), getString(R.string.phone_mall_2)));
        places.add(new Place(getString(R.string.mall_name3), R.drawable.mall_of_arabia_cairo_, getString(R.string.mall_name3), R.drawable.mall_of_arabia_cairo_, getString(R.string.mall_INFO3), getString(R.string.mall_name3), getString(R.string.phone_mall_3)));
        places.add(new Place(getString(R.string.mall_name4), R.drawable.egypt_mall, getString(R.string.mall_name4), R.drawable.egypt_mall, getString(R.string.mall_INFO4), getString(R.string.mall_name4), getString(R.string.phone_mall_4)));
        places.add(new Place(getString(R.string.mall_name5), R.drawable.genena_mall, getString(R.string.mall_name5), R.drawable.genena_mall, getString(R.string.mall_INFO5), getString(R.string.mall_name5), getString(R.string.phone_mall_5)));

        // Create an placeAdapter, whose data source is a list of
        //  places . The adapter knows how to create list item views for each item
        // in the list.

        PlaceAdapter AdaptorForPlace = new PlaceAdapter(getActivity(), places, R.color.category_mall);

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
