package com.tig167.spotifystatistics.spotifystatistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Tab2Artists extends Fragment {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2artists, container, false);

        listView = rootView.findViewById(R.id.LVartists);

        setupList(rootView);

        return rootView;
    }

    public void setupList(View view){
        List<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("DROELOE"));
        artists.add(new Artist("August burns red"));
        artists.add(new Artist("Crystal castles"));
        artists.add(new Artist("Dunderpatrullen"));
        artists.add(new Artist("Parkway drive"));

        //Lookup ListView

        //Create adapter
        ListAdapter adapter = new ArrayAdapter<Artist>(getActivity(),android.R.layout.simple_list_item_1,artists);

        listView.setAdapter(adapter);

    }
}
