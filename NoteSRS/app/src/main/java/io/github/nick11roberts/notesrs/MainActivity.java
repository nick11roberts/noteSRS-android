package io.github.nick11roberts.notesrs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements CorrectAsyncResponse {

    // XML elements that will be used
    private EditText autoCucumberEditText;
    private Button autoCucumberButton;
    private CoordinatorLayout coordinatorLayout;

    private final CorrectAsyncTask placeholderCorrectAsyncTask = new CorrectAsyncTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // For calling the API
        placeholderCorrectAsyncTask.delegate = this;

        // Now that the view is inflated, find the relevant elements in the XML
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_layout_main);
        autoCucumberEditText = (EditText)findViewById(R.id.autoCucumberEditText);
        autoCucumberButton = (Button)findViewById(R.id.autoCucumberButton);

        // Give the button an OnClickListener with an overridden onClick method
        autoCucumberButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Check if not (string has spaces)
                if(!autoCucumberEditText.getText().toString().isEmpty()) {

                    // Call the API
                    CorrectAsyncTask correctAsyncTask = new CorrectAsyncTask();
                    correctAsyncTask.delegate = placeholderCorrectAsyncTask.delegate;
                    correctAsyncTask.execute(new Pair<>(getApplicationContext(), autoCucumberEditText.getText().toString()));

                    // Reset the EditText focus and hide the keyboard
                    autoCucumberEditText.requestFocus();
                    try  {
                        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {

                    }

                } else {

                    // Notify the user that they must have some input to correct
                    autoCucumberEditText.setError(getResources().getString(R.string.empty_input));

                }

            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, UploadActivity.class);
                MainActivity.this.startActivity(myIntent);

                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        */
            }
        });

    }

    public void processFinish(String output){
        //this you will received result fired from async class of onPostExecute(result) method.
        if(autoCucumberEditText != null){
            autoCucumberEditText.setText(output);

            Snackbar.make(coordinatorLayout,
                    getResources().getString(R.string.text_corrected_notification),
                    Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
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

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
