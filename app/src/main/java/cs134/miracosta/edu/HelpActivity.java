package cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    // Declare View elements
    private TextView helpGallonsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        // Link Views
        helpGallonsTextView = findViewById(R.id.helpGallonsTextView);

        // Receive Intent data
        Intent intent = getIntent();

        // Populate TextView
        helpGallonsTextView.setText(intent.getStringExtra("GallonsRequired"));
    }

    public void closeActivity(View v) {
        this.finish();
    }

}
