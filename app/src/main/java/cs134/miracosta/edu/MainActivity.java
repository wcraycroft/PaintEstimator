package cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import cs134.miracosta.edu.Model.InteriorRoom;

public class MainActivity extends AppCompatActivity {

    // View references
    private EditText lengthEditText;
    private EditText widthEditText;
    private EditText heightEditText;
    private EditText doorsEditText;
    private EditText windowsEditText;
    private TextView gallonsTextView;
    // Formatter
    DecimalFormat oneDP = new DecimalFormat("0.0");
    // Model
    private InteriorRoom room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link controller variables to View
        lengthEditText = findViewById(R.id.lengthEditText);
        widthEditText = findViewById(R.id.widthEditText);
        heightEditText = findViewById(R.id.heightEditText);
        doorsEditText = findViewById(R.id.doorsEditText);
        windowsEditText = findViewById(R.id.windowsEditText);
        gallonsTextView = findViewById(R.id.gallonsTextView);
        // Instantiate Model
        room = new InteriorRoom(0, 0, 0.0, 0.0, 0.0);
    }

    public void computeGallons(View v) {

        double length = 0.0;
        double width =0.0;
        double height = 0.0;
        int doors = 0;
        int windows = 0;

        try {
            length = Double.parseDouble(lengthEditText.getText().toString());
            width = Double.parseDouble(widthEditText.getText().toString());
            height = Double.parseDouble(heightEditText.getText().toString());
            doors = Integer.parseInt(doorsEditText.getText().toString());
            windows = Integer.parseInt(windowsEditText.getText().toString());
        } catch (NumberFormatException e) {}

        // Update model
        room.setLength(length);
        room.setWidth(width);
        room.setHeight(height);
        room.setDoors(doors);
        room.setWindows(windows);

        // Output gallons
        gallonsTextView.setText(String.format("Interior surface area: %s feet.\nGallons needed: %s",
                oneDP.format(room.wallSurfaceArea()), oneDP.format(room.gallonsOfPaintRequired())));
    }

    public void switchToHelp(View v) {

        double length = 0.0;
        double width = 0.0;
        double height = 0.0;
        int doors = 0;
        int windows = 0;

        try {
            length = Double.parseDouble(lengthEditText.getText().toString());
            width = Double.parseDouble(widthEditText.getText().toString());
            height = Double.parseDouble(heightEditText.getText().toString());
            doors = Integer.parseInt(doorsEditText.getText().toString());
            windows = Integer.parseInt(windowsEditText.getText().toString());
        } catch (NumberFormatException e) {
        }

        // Update model
        room.setLength(length);
        room.setWidth(width);
        room.setHeight(height);
        room.setDoors(doors);
        room.setWindows(windows);

        // Create intent and share data
        Intent helpIntent = new Intent(this, HelpActivity.class);
        helpIntent.putExtra("GallonsRequired", String.format("Estimated Paint Required: %s gallons",
                oneDP.format(room.gallonsOfPaintRequired())));

        // Start helpActivity
        startActivity(helpIntent);
    }
}
