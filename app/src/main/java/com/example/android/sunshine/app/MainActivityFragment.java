package com.example.android.sunshine.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        String[] data = {
                "Mon 6/01 - Sunny 31/17",
                "Tue 6/02 - Sunny 32/20",
                "Wed 6/03 - Sunny 29/16",
                "Thu 6/04 - Cloudy 28/19",
                "Fri 6/05 - Cloudy 25/16",
                "Sat 6/06 - Foggy 20/15",
                "Sun 6/07 - Rainy 18/10",
        };

        List<String> weakForecast = new ArrayList<String>(Arrays.asList(data));
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
