package io.github.nick11roberts.notesrs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // XML elements that will be used
    private EditText autoCucumberEditText;
    private Button autoCucumberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Now that the view is inflated, find the relevant elements in the XML
        autoCucumberEditText = (EditText)findViewById(R.id.autoCucumberEditText);
        autoCucumberButton = (Button)findViewById(R.id.autoCucumberButton);

        // Give the button an OnClickListener with an overridden onClick method
        autoCucumberButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Check if not (string has spaces)
                if(!autoCucumberEditText.getText().toString().isEmpty()) {

                    // Call the API

                    // Reset the EditText
                    autoCucumberEditText.getText().clear();
                    autoCucumberEditText.requestFocus();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

            // Start the SettingsActivity
            Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(myIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
