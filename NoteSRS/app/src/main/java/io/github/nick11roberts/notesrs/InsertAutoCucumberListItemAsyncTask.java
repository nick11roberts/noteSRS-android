package io.github.nick11roberts.notesrs;


import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import io.github.nick11roberts.myApi.MyApi;

/**
 * Created by nick on 10/3/15.
 */
public class InsertAutoCucumberListItemAsyncTask extends AsyncTask<SingleAutoCucumber, Void, String> {
    public InsertAutoCucumberListItemAsyncResponse delegate = null;
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(SingleAutoCucumber... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://notesrs-1087.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].getContext();
        String toBeCorrected = params[0].getToBeCorrected();
        String correction = params[0].getCorrection();

        try {
            return myApiService.insertAutoCucumberListItem(toBeCorrected, correction).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(delegate != null) {
            delegate.processFinish(result);
        }
    }
}