package com.tig167.spotifystatistics.spotifystatistics.song;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
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
This class makes it possible to create a listAdapter specific for song objects.
 */

public class SongListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Song> songItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public SongListAdapter(Activity activity, List<Song> songItems) {
        this.activity = activity;
        this.songItems = songItems;
    }

    @Override
    public int getCount() {
        return songItems.size();
    }

    @Override
    public Object getItem(int location) {
        return songItems.get(location);
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
            convertView = inflater.inflate(R.layout.song_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView songPicture = (NetworkImageView) convertView
                .findViewById(R.id.songPicture);
        TextView tv_song = (TextView) convertView.findViewById(R.id.tv_song);
        TextView tv_songArtist = (TextView) convertView.findViewById(R.id.tv_songArtist);

        // getting song data for the row
        Song s = songItems.get(position);

        Log.w("IMAGELOADER", imageLoader.toString());
        Log.w("SONG PICTURE", songPicture.toString());
        // set song pictureo
        songPicture.setImageUrl(s.getSongPicture(), imageLoader);

        // set song name
        tv_song.setText(s.getSongName());

        // set songs artist name
        tv_songArtist.setText(s.getSongArtist());

        return convertView;
    }

}