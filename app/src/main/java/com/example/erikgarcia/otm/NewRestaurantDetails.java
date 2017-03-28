package com.example.erikgarcia.otm;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class NewRestaurantDetails extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;
    Button menuSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(R.color.textColor));

        menuSwitch = (Button) findViewById(R.id.switchToMenu);

        loadFragment(new FragmentResDetials());
        menuSwitch.setText("Switch to Menu View");

        menuSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (menuSwitch.getText().toString()){
                    case"Switch to Menu View" :
                        loadFragment(new FragmentResMenu());
                        menuSwitch.setText("Switch to Details View");
                        break;
                    case "Switch to Details View":
                        loadFragment(new FragmentResDetials());
                        menuSwitch.setText("Switch to Menu View");
                }

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void loadFragment(android.support.v4.app.Fragment frag){
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.restaurantDetails, frag);
        ft.commit();
    }

    private void switchPosition(){

    }

    public void time(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View timePickerLayout = getLayoutInflater().inflate(R.layout.time_picker, null);
        builder.setView(timePickerLayout);

        final AlertDialog alert = builder.create();
        alert.show();

        final TimePicker time = (TimePicker) alert.findViewById(R.id.timePicker);
        final TextView textView = (TextView) v;

        Button save = (Button) alert.findViewById(R.id.timePickerSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int h = time.getCurrentHour(), m = time.getCurrentMinute();
                int hour = h % 12;
                if (hour == 0) {
                    hour = 12;
                }
                textView.setText(String.format("%2d:%02d %s", hour == 0 ? 12 : hour,
                        m, h < 12 ? "am" : "pm"));

                switch (textView.getId()) {
                    case R.id.sunOpen:
                        textView.append("  -");
                        break;
                    case R.id.monOpen:
                        textView.append("  -");
                        break;
                    case R.id.tuesOpen:
                        textView.append("  -");
                        break;
                    case R.id.wedOpen:
                        textView.append("  -");
                        break;
                    case R.id.thuOpen:
                        textView.append("  -");
                        break;
                    case R.id.friOpen:
                        textView.append("  -");
                        break;
                    case R.id.satOpen:
                        textView.append("  -");
                }

                String setTime = h + ":" + m;
                if (setTime.equals("") || setTime.equals(null)) {
                    textView.setText("Closed");
                }

                switchText(v, textView);

                alert.dismiss();
            }
        });

        Button closed = (Button) alert.findViewById(R.id.timePickerClosed);
        closed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Closed");
                switchText(v, textView);
                alert.dismiss();
            }
        });
    }

    private void switchText(View v, TextView t) {

        final TextView sunOpen = (TextView) findViewById(R.id.sunOpen);
        final TextView monOpen = (TextView) findViewById(R.id.monOpen);
        final TextView tuesOpen = (TextView) findViewById(R.id.tuesOpen);
        final TextView wedOpen = (TextView) findViewById(R.id.wedOpen);
        final TextView thuOpen = (TextView) findViewById(R.id.thuOpen);
        final TextView friOpen = (TextView) findViewById(R.id.friOpen);
        final TextView satOpen = (TextView) findViewById(R.id.satOpen);

        switch (v.getId()) {
            case R.id.sunOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.sunClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.sunClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.sunClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.sunClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    sunOpen.setText("Closed");
                }
                //Save Values Here
                break;
            case R.id.monOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.monClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.monClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.monClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.monClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    monOpen.setText("Closed");
                }
                //Save Values Here
                break;
            case R.id.tuesOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.tuesClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.tuesClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.tuesClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.tuesClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    tuesOpen.setText("Closed");
                }
                //Save Values Here
                break;
            case R.id.wedOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.wedClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.wedClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.wedClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.wedClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    wedOpen.setText("Closed");
                }
                //Save Values Here
                break;
            case R.id.thuOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.thuClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.thuClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.thuClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.thuClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    thuOpen.setText("Closed");
                }
                //Save Values Here
                break;
            case R.id.friOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.friClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.friClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.friClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.friClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    friOpen.setText("Closed");
                }
                //Save Values Here
                break;
            case R.id.satOpen:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.satClose).setVisibility(View.GONE);
                }
                if (!t.getText().toString().equals("Closed")) {
                    findViewById(R.id.satClose).setVisibility(View.VISIBLE);
                }
                //Save Values Here
                break;
            case R.id.satClose:
                if (t.getText().toString().equals("Closed")) {
                    findViewById(R.id.satClose).setVisibility(View.GONE);
                    t.setText("12:00 pm");
                    satOpen.setText("Closed");
                }
        }
    }

    public void cancel(View v) {

        //Clear the Autosaves Here

        finish();

    }

    public void next(View v) {
        //Save All Date

        menuSwitch = (Button)this.findViewById(R.id.switchToMenu);

        loadFragment(new FragmentResMenu());
        menuSwitch.setText("Switch to Details View");


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("NewRestaurantDetails Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mClient.disconnect();
    }
}
