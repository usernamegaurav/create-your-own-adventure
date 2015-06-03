package com.example.android.sunshine.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create some dummy data for the ListView.  Here's a sample weekly forecast
        String[] data = {
                "Mon 6/01 - Sunny 31/17",
                "Tue 6/02 - Sunny 32/20",
                "Wed 6/03 - Sunny 29/16",
                "Thu 6/04 - Cloudy 28/19",
                "Fri 6/05 - Cloudy 25/16",
                "Sat 6/06 - Foggy 20/15",
                "Sun 6/07 - Rainy 18/10",
        };

        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

        // Now that we have some dummy forecast data, create an ArrayAdapter.
        // The ArrayAdapter will take data from a source (like our dummy forecast) and
        // use it to populate the ListView it's attached to.
        ArrayAdapter<String> forecastAdapter = new ArrayAdapter<String>(
                getActivity(), // The current context
                R.layout.list_item_forecast, // The name of the layout ID
                R.id.list_item_forecast_textview, // The ID of the textView to populate
                weekForecast); // forecast data

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
