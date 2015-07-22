package com.example.android.sunshine.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    String mLocation;
    private final String FORECASTFRAGMENT_TAG = "FFTAG";

    @Override
    protected void onStart() {
        Log.i("MainActivity", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i("MainActivity", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
        String location = Utility.getPreferredLocation( this );
        // update the location in our second pane using the fragment manager
        if (location != null && !location.equals(mLocation)) {
            Log.i("MainActivity", "location ch");
            ForecastFragment ff = (ForecastFragment)getSupportFragmentManager().findFragmentByTag(FORECASTFRAGMENT_TAG);
            if ( null != ff ) {
                ff.onLocationChanged();
            }
            mLocation = location;
        }
    }

    @Override
    protected void onPause() {
        Log.i("MainActivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.ic_launcher);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment(), FORECASTFRAGMENT_TAG)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_map) {
            openPreferredLocationInMap();
            return true;        }

        return super.onOptionsItemSelected(item);
    }

    private void openPreferredLocationInMap() {
        String location = Utility.getPreferredLocation(this);
        Uri uri = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q", location)
                .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("Main Activity", "Couldn't call " + location + ", no receiving apps installed!");
        }

    }
}
