package com.tig167.spotifystatistics.spotifystatistics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab1Songs extends Fragment {

    private ListView listView;
    private RequestQueue mQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1songs, container, false);

        // Refers to the listView we are going to use
        listView = rootView.findViewById(R.id.LVsongs);
        // Creates a queue
        mQueue = Volley.newRequestQueue(getContext());

        // Runs the method of creating Song objects and populating the listView.
        setupList();
        // Returns the view
        return rootView;
    }

    public void setupList(){
        // URL to the endpoint containing the JSON we want to parse
        String url = "https://api.myjson.com/bins/we82g";
        // Creates a list for the Song objects
        final List<Song> songs = new ArrayList<Song>();

        // A GET-request to the json from the url
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                // Listens to a response from the request
                new Response.Listener<JSONObject>() {

                    // If it gets a response it tries to:
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Get JSON array with the name artist
                            JSONArray jsonArray = response.getJSONArray("song");

                            // For every JSON object in the array, pick out the variables, create a Song object and add to the songs list
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonA = jsonArray.getJSONObject(i);
                                String name = jsonA.getString("song_name");
                                String picture = jsonA.getString("song_picture");
                                String artist = jsonA.getString("song_artist");
                                int rank = jsonA.getInt("song_rank");

                                Song newSong = new Song(name, picture, artist, rank);
                                songs.add(newSong);

                                // Create and sets a ListAdapter for user display containing songss
                                ListAdapter adapter = new SongListAdapter(getActivity(), songs);
                                listView.setAdapter(adapter);
                            }
                            // If a JSONException is caught, print what went wrong
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // Puts the request from above in the queue
        mQueue.add(request);
    }
}
