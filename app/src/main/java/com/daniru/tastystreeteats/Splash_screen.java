package com.daniru.tastystreeteats;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Assuming EdgeToEdge is your custom implementation
        // Uncomment if applicable or remove this line if unnecessary
        // EdgeToEdge.enable(this);

        setContentView(R.layout.activity_splash_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Delay for 3 seconds (3000 ms)
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash_screen.this, startActivity.class);
            startActivity(intent);
            finish(); // Close the splash screen activity
        }, 3000);
    }
}
