package com.example.erikgarcia.otm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText usernameEntry;
    private EditText passwordEntry;
    private Button   nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));

        usernameEntry = (EditText) findViewById(R.id.username_input);
        passwordEntry = (EditText) findViewById(R.id.password_input);
        nextButton = (Button) findViewById(R.id.next_button);
    }

    /*
       Grabs the username and password and stores them into these variables
       when the next button is pressed. haven't done anything with them though
    */
    public void readInput(View v) {
        String username = usernameEntry.getText().toString();
        String password = passwordEntry.getText().toString();

        if(username.equals("Admin") && password.equals("Password")){
            Intent i = new Intent(this, RestaurantCreate.class);
            startActivity(i);
        }

        //remove later
        Intent i = new Intent(this, RestaurantCreate.class);
        startActivity(i);

        Log.d("HELLO", username);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
