package com.tig167.spotifystatistics.spotifystatistics.artist;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.tig167.spotifystatistics.spotifystatistics.AppController;
import com.tig167.spotifystatistics.spotifystatistics.R;

/*
This class makes it possible to create a listAdapter specific for artist objects.
 */

public class ArtistListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Artist> artistItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public ArtistListAdapter(Activity activity, List<Artist> artistItems) {
        this.activity = activity;
        this.artistItems = artistItems;
    }

    @Override
    public int getCount() {
        return artistItems.size();
    }

    @Override
    public Object getItem(int location) {
        return artistItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.artist_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView artistPicture = (NetworkImageView) convertView
                .findViewById(R.id.artistPicture);
        TextView tv_artist = (TextView) convertView.findViewById(R.id.tv_artist);

        // getting artist data for the row
        Artist a = artistItems.get(position);

        // set artist picture
        artistPicture.setImageUrl(a.getArtistPicture(), imageLoader);

        // set artist name
        tv_artist.setText(a.getArtistName());

        return convertView;
    }

}