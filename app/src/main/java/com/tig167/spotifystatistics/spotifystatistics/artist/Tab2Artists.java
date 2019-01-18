package com.tig167.spotifystatistics.spotifystatistics.artist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tig167.spotifystatistics.spotifystatistics.LogInActvity;
import com.tig167.spotifystatistics.spotifystatistics.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab2Artists extends Fragment {

    private ListView listView;
    private RequestQueue mQueue;
    private String myIP = ""; // Put in your local IP-adress between the " " !

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2artists, container, false);

        // Refers to the listView we are going to use
        listView = rootView.findViewById(R.id.LVartists);
        // Creates a queue
        mQueue = Volley.newRequestQueue(getContext());

        // Runs the method of creating Artist objects and populating the listView.
        setupList();

        // Returns the view
        return rootView;
    }

    public void setupList(){
        // URL to the endpoint containing the JSON we want to parse
        String url = "http://" + myIP + ":8080/statistics/artist?artist_user_id=" + LogInActvity.loggedInUser.getId();
        // Creates a list for the Artist objects
        final List<Artist> artists = new ArrayList<Artist>();

        // A GET-request to the json from the url
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                // Listens to a response from the request
                new Response.Listener<JSONObject>() {

                    // If it gets a response it tries to:
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Get JSON array with the name artist
                            JSONArray jsonArray = response.getJSONArray("artists");

                            // For every JSON object in the array, pick out the variables, create an Artist object and add to the artists list
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonA = jsonArray.getJSONObject(i);
                                String name = jsonA.getString("artist_name");
                                String picture = jsonA.getString("artist_picture");
                                int rank = jsonA.getInt("artist_rank");

                                Artist newArtist = new Artist(name, picture, rank);
                                artists.add(newArtist);

                                // Create and sets a ListAdapter for user display containing artists
                                ListAdapter adapter = new ArtistListAdapter(getActivity(), artists);
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
