package com.tig167.spotifystatistics.spotifystatistics;

public class Artist {

    private String artistName;
    private int userId;
    private String artistPicture;
    private int rank;

    public Artist(String name, String picture, int rank){
        this.artistName = name;
        this.artistPicture = picture;
        this.rank = rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPicture(String picture) {
        this.artistPicture = picture;
    }

    public String getArtistName(){
        return artistName;
    }

    public String toString(){
        return artistName;
    }

}
