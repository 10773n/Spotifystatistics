package com.tig167.spotifystatistics.spotifystatistics;

public class Song {

    private String songName;
    private String songPicture;
    private String songArtist;
    private int songRank;

    public Song(String name, String picture, String artist, int rank){
        this.songName = name;
        this.songPicture = picture;
        this.songArtist = artist;
        this.songRank = rank;
    }

    public void setSongPicture(String picture) { this.songPicture = picture; }

    public String getSongPicture(){
        return songPicture;
    }

    public String getSongName(){
        return songName;
    }

    public String getSongArtist(){return songArtist;}

    public String toString(){
        return songName;
    }

}
