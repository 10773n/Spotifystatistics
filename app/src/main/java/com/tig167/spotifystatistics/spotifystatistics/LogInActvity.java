package com.tig167.spotifystatistics.spotifystatistics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class LogInActvity extends AppCompatActivity {

    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login_button = (Button)findViewById(R.id.Blogin);
        // link button with tab1
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get log in- and password-values from log in fields in activity
                EditText usernameET = findViewById(R.id.ETusername);
                EditText passwordET = findViewById(R.id.ETpassword);
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                //Search for username/password in JSON-file in assets
                try{
                    JSONObject object = new JSONObject(loadJSONFromAssets());
                    JSONArray usersArray = object.getJSONArray("users");
                    ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();
                    HashMap<String, String> hashMap;

                    for(int i = 0; i < usersArray.length(); i++){
                        JSONObject userObject = usersArray.getJSONObject(i);
                        String userObjectUsername = userObject.getString("username");
                        String userObjectPassword = userObject.getString("password");

                        //If username and password exists in the JSON-file, then log in the user and move to TabbedActivity
                        if(userObjectUsername.equals(username)){
                            if (userObjectPassword.equals(password)){
                                startActivity(new Intent(LogInActvity.this, TabbedActivity.class));
                            }
                        }
                    }
                    //Pop-up, user not found
                    Toast.makeText(LogInActvity.this, "Incorrect username or password, try again!",
                            Toast.LENGTH_LONG).show();
                } catch(JSONException ex){
                    ex.printStackTrace();
                }

            }
        });

    }

    //read JSON-file from assets
    public String loadJSONFromAssets(){
        String json = null;
        try{
            InputStream is = this.getAssets().open("users.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
