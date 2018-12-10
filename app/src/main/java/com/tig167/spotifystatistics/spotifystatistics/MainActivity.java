package com.tig167.spotifystatistics.spotifystatistics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupList();
    }

    private List<Artist> artists;

    public void setupList(){
        //populate list
        artists = new ArrayList<Artist>();
        artists.add(new Artist("DROELOE"));
        artists.add(new Artist("August burns red"));
        artists.add(new Artist("Crystal castles"));
        artists.add(new Artist("Dunderpatrullen"));
        artists.add(new Artist("Parkway drive"));

        //Lookup ListView
        listView=(ListView)findViewById(R.id.LVartists);

        //Create adapter
        adapter = new ArrayAdapter<Artist>(this,android.R.layout.simple_list_item_1,artists);

        listView.setAdapter(adapter);

    }
}
