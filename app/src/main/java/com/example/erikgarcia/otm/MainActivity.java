package com.example.erikgarcia.otm;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner resType;
    EditText zipCode;
    private Button  searchButton;
    private TextView advancedSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resType = (Spinner) findViewById(R.id.res_type);
        searchButton = (Button) findViewById(R.id.search_Button);
        zipCode = (EditText) findViewById(R.id.zip_code);
        advancedSearch = (TextView)findViewById(R.id.advancedSearch);
        advancedSearch.setPaintFlags(advancedSearch.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);


        setUpRestaurantSpinner();

    }

    //Creates and populates the drop down menu
    public void setUpRestaurantSpinner() {

        //Can add more later, just wanted to put some items in
        String[] typeOptions = new String[]{"All", "Mexican",
                                            "Italian",
                                            "Chinese"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, typeOptions);
        resType.setAdapter(adapter);
    }

    //Create the Advanced Search Options
    public void advancedSearch(View v){
        LinearLayout ll = (LinearLayout)findViewById(R.id.advancedSearchContainer);
        ImageView img = (ImageView)findViewById(R.id.advancedSearchArrow);

        switch (ll.getVisibility()){
            case View.GONE:
                ll.setVisibility(View.VISIBLE);
                img.setImageResource(R.drawable.arrow_up);
                break;
            case View.VISIBLE:
                ll.setVisibility(View.GONE);
                img.setImageResource(R.drawable.arrow_dn);
        }
    }

    //Starts the Login screen when "Sign in as Owner" button is pressed.
    public void signInAsOwner(View v) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    //Starts the sign up activity when "Sign up as an Owner" button is pressed.
    public void signUpAsOwner (View v) {
        Intent intent = new Intent(this,SignupActivity.class);
        startActivity(intent);
    }

    //Search Button reads in the zip and restaurant type
    //TODO create the restaurant search display activity and
    public void readInput(View v) {
        String zip = zipCode.getText().toString();
        String type = resType.getSelectedItem().toString();

        //Testing that i got the right result by logging
        Log.d("TEST", zip + " " + type);
    }


}
