package com.tig167.spotifystatistics.spotifystatistics;

public class Artist {

    private String artistName;
    private String artistPicture;
    private int artistRank;

    public Artist(String name, String picture, int rank){
        this.artistName = name;
        this.artistPicture = picture;
        this.artistRank = rank;
    }

    public void setArtistPicture(String picture) {
        this.artistPicture = picture;
    }

    public String getArtistPicture(){
        return artistPicture;
    }

    public String getArtistName(){
        return artistName;
    }

    public String toString(){
        return artistName;
    }

}
