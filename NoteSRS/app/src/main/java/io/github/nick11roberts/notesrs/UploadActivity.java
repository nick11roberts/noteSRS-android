package io.github.nick11roberts.notesrs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UploadActivity extends AppCompatActivity {

    // XML elements that will be used
    private EditText newWordEditText;
    private EditText newCorrectionEditText;
    private Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // Now that the view is inflated, find the relevant elements in the XML
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

                    // Reset the EditTexts
                    newWordEditText.getText().clear();
                    newCorrectionEditText.getText().clear();
                    newWordEditText.requestFocus();

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
}
