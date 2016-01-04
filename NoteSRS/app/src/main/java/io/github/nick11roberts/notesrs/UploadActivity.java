package io.github.nick11roberts.notesrs;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class UploadActivity extends AppCompatActivity
        implements InsertAutoCucumberListItemAsyncResponse {

    // Strings to store correction state information
    private String word;
    private String correction;

    // XML elements that will be used
    private EditText newWordEditText;
    private EditText newCorrectionEditText;
    private Button uploadButton;
    private CoordinatorLayout coordinatorLayout;

    private final InsertAutoCucumberListItemAsyncTask placeholderInsertAsyncTask
            = new InsertAutoCucumberListItemAsyncTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // For calling the API
        placeholderInsertAsyncTask.delegate = this;

        // Now that the view is inflated, find the relevant elements in the XML
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_layout_upload);
        newWordEditText = (EditText)findViewById(R.id.newWordEditText);
        newCorrectionEditText = (EditText)findViewById(R.id.newCorrectionEditText);
        uploadButton = (Button)findViewById(R.id.uploadButton);

        // Give the button an OnClickListener with an overridden onClick method
        uploadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Check if not (string has spaces)
                if((!newWordEditText.getText().toString().contains(" ")
                        && !newWordEditText.getText().toString().isEmpty())
                        && (!newCorrectionEditText.getText().toString().contains(" ")
                        && !newCorrectionEditText.getText().toString().isEmpty())) {

                    // Call the API
                    InsertAutoCucumberListItemAsyncTask insertTask = new InsertAutoCucumberListItemAsyncTask();
                    insertTask.delegate = placeholderInsertAsyncTask.delegate;
                    insertTask.execute(
                            new SingleAutoCucumber(
                                    newWordEditText.getText().toString(),
                                    newCorrectionEditText.getText().toString(),
                                    getApplicationContext()
                            )
                    );

                    // Save the data
                    word = newWordEditText.getText().toString();
                    correction = newCorrectionEditText.getText().toString();

                    // Reset the EditTexts and keyboard
                    newWordEditText.getText().clear();
                    newCorrectionEditText.getText().clear();
                    newWordEditText.requestFocus();
                    try  {
                        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {

                    }

                } else {

                    if (newWordEditText.getText().toString().contains(" ")
                            || newWordEditText.getText().toString().isEmpty()) {

                        newWordEditText.setError(getResources().getString(R.string.invalid_input));

                    }

                    if (newCorrectionEditText.getText().toString().contains(" ")
                            || newCorrectionEditText.getText().toString().isEmpty()) {

                        newCorrectionEditText.setError(getResources().getString(R.string.invalid_input));

                    }

                }

            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void processFinish(String output){

        Snackbar.make(coordinatorLayout, word
                        + getResources().getString(R.string.text_uploaded_notification_mid)
                        + correction,
                Snackbar.LENGTH_LONG)
                .setAction("", null).show();

    }

}
