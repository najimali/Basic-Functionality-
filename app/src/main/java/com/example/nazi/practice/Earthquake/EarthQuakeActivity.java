package com.example.nazi.practice.Earthquake;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nazi.practice.R;
import com.example.nazi.practice.Soonami.Event;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class EarthQuakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<EarthCustomClass>> {
    private EarthAdapter mAdapter;
    private static String Log_Tag=EarthQuakeActivity.class.getSimpleName();
    /** URL for earthquake data from the USGS dataset */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        // Start the AsyncTask to fetch the earthquake data
        //EarthQuakeLoader task = new EarthQuakeLoader();
        //task.execute(USGS_REQUEST_URL);


        //Find a referenece to the (@link ListView) to the layout
        ListView earthQuake_listView=findViewById(R.id.listView);

        // Create a new adapter that takes an empty list of earthquakes as input
        mAdapter = new EarthAdapter(this, new ArrayList<EarthCustomClass>());

        //Set the adapter on the (@link ListView) so that
        //list can be populated in the user interface.
        earthQuake_listView.setAdapter(mAdapter);
        Log.v(Log_Tag," initLoader ");
        getSupportLoaderManager().initLoader(1,null,this).forceLoad();

        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected earthquake.
        earthQuake_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Find the current earthquake that was clicked on
                EarthCustomClass currentEarthquake=mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });



    }

    @NonNull
    @Override
    public Loader<List<EarthCustomClass>> onCreateLoader(int id,  Bundle args) {
        // TODO: Create a new loader for the given URL
        Log.v(Log_Tag," onCreateLoader ");
        return new EarthQuakeLoader(this,USGS_REQUEST_URL);

    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<EarthCustomClass>> loader, List<EarthCustomClass> data) {
        // TODO: Update the UI with the result
        Log.v(Log_Tag," onLoadFinished ");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<EarthCustomClass>> loader) {
        // TODO: Loader reset, so we can clear out our existing data.
        Log.v(Log_Tag," onLoaderReset ");
        mAdapter.clear();
    }

    private static class EarthQuakeLoader extends AsyncTaskLoader<List<EarthCustomClass>>
    {
        String mURL;
        public EarthQuakeLoader(@NonNull Context context,String url) {

            super(context);
            this.mURL=url;
        }
        //This is on a background thread.
        @Override
        public List<EarthCustomClass> loadInBackground() {
            Log.v(Log_Tag," loadInBakground");
            if (mURL == null)
            { return null; }
            List<EarthCustomClass> result = QueryUtils.fetchEarthQuakeData(mURL);
            return result;

        }

        @Override
        protected void onStartLoading() {
            Log.v(Log_Tag," onStartLoading");
            forceLoad();
        }
    }


    }

    /**
     * {@link AsyncTask} to perform the network request on a background thread, and then
     * update the UI with the list of earthquakes in the response.
     *
     * AsyncTask has three generic parameters: the input type, a type used for progress updates, and
     * an output type. Our task will take a String URL, and return an Earthquake. We won't do
     * progress updates, so the second generic is just Void.
     *
     * We'll only override two of the methods of AsyncTask: doInBackground() and onPostExecute().
     * The doInBackground() method runs on a background thread, so it can run long-running code
     * (like network activity), without interfering with the responsiveness of the app.
     * Then onPostExecute() is passed the result of doInBackground() method, but runs on the
     * UI thread, so it can use the produced data to update the UI.
     */
   /* private class EarthQuakeAsync extends AsyncTask<String,Void,List<EarthCustomClass>>
    {
        *//**
         * This method runs on a background thread and performs the network request.
         * We should not update the UI from a background thread, so we return a list of
         * {@link EarthCustomClass}s as the result.
         *//*
        @Override
        protected List<EarthCustomClass> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null)
            { return null; }
            List<EarthCustomClass> result = QueryUtils.fetchEarthQuakeData(urls[0]);
            return result;
        }
        *//**
         * This method runs on the main UI thread after the background work has been
         * completed. This method receives as input, the return value from the doInBackground()
         * method. First we clear out the adapter, to get rid of earthquake data from a previous
         * query to USGS. Then we update the adapter with the new list of earthquakes,
         * which will trigger the ListView to re-populate its list items.
         *//*

        @Override
        protected void onPostExecute(List<EarthCustomClass> data) {

            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }

        }
    }*/
    //Create a fake list of earthquake location
    //  ArrayList<EarthCustomClass> array_earthquake= QueryUtils.extractEarthCustomClass();

       /* array_earthquake.add(new EarthCustomClass("7.2","88km N of Yelizovo, Russia","Sat Jan 30 2016 "));
        array_earthquake.add(new EarthCustomClass("6.1","94km SSE of Taron, Papua New Guinea","Tue Jan 26 2016"));*/


