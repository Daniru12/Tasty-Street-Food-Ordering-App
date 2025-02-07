package com.daniru.tastystreeteats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daniru.tastystreeteats.databinding.ActivityChooselocationBinding;

public class ChooselocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge support (ensure this is available in your environment)
        EdgeToEdge.enable(this);

        // Inflate the layout and set content view
        setContentView(R.layout.activity_chooselocation);

        // Set up window insets to handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up the AutoCompleteTextView with a list of locations
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.listoflocation);

        // Create a list of location names
        String[] locationList = {"Colombo", "Gampaha", "Kandy", "Matara", "Kurunegala", "Jaffna", "Batticaloa", "Anuradhapura",
                "Badulla", "Vavuniya", "Puttalam", "Mannar", "Trincomalee", "Ratnapura", "Polonnaruwa",
                "Matale", "Kalutara", "Hambantota", "Kegalle", "Monaragala", "Nuwara Eliya", "Mullaitivu",
                "Kilinochchi", "Sabaragamuwa", "North Central", "Eastern", "Western", "Southern"};

        // Create an ArrayAdapter to bind the list of locations to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationList);

        // Set the adapter for the AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);

        // Set an item click listener to navigate when a location is selected
        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected location from the AutoCompleteTextView
            String selectedLocation = (String) parent.getItemAtPosition(position);

            // Pass the selected location to the MainActivity
            Intent intent = new Intent(ChooselocationActivity.this, MainActivity.class);
            intent.putExtra("selectedLocation", selectedLocation);
            startActivity(intent);
            finish(); // Optionally, finish the current activity
        });
    }
}
