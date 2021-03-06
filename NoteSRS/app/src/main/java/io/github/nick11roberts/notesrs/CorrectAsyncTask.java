package io.github.nick11roberts.notesrs;


import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import io.github.nick11roberts.myApi.MyApi;

/**
 * Created by thomas on 10/3/15.
 */
public class CorrectAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    public CorrectAsyncResponse delegate = null;
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://notesrs-1087.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.correctText(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}