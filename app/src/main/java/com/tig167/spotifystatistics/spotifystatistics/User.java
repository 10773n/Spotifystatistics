package com.tig167.spotifystatistics.spotifystatistics;

public class User {

    private String username;
    private String password;
    private String id;


    public User(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getId() { return id; }
}
