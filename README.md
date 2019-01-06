# Spotifystatistics

Statisfy is an Android application showing Spotify statistics (almost). Super cool!

The application is made for spotify users to be able to get their own top artist, songs and genres that has been played during long, medium or short term periods. The application is however only in making, the first version is only a test using placeholders taken from premade users.


## For developers


This application is made with android studio that is connecting to a localhost servlet. The application takes premade users and their music information to make toplists in the three different tabs - artist, songs and genres (the last one is coming soon). The servlet application is only a temporary solution. The goal is to integrate Spotifys API with the application to show real user data. To learn more about Spotify's API, go to : https://developer.spotify.com/documentation/android/#api-documentation

To log in you must choose one of the two users that excists at the moment: 

    username : 10773n
    password : hej123 
    
    or
    
    username : apelipell
    password : hejdå321

After you have logged in, the users top 5 will be shown in the respective tab. The data that is showed comes from a server that is connected via URL. The servlet application that is used is : https://github.com/apelipell/Servlet 

You can change the URL:s in Tab1Songs.java and Tab2Artists.java if you dont want to start and run the server via localhost, example JSON:

artist:   https://api.myjson.com/bins/11rc88 
song:     https://api.myjson.com/bins/qg3qg 

### Design guidelines

The design of the application goes in line with Spotifys colors and style. The main colors that should be used is already in res/values/colors.xml. Read more about Spotify's branding guidelines at : https://developer.spotify.com/branding-guidelines/ 
