package com.daniru.tastystreeteats;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find NavHostFragment
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);

        if (navHostFragment != null) {
            // Get NavController
            NavController navController = navHostFragment.getNavController();

            // Set up BottomNavigationView with NavController
            BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
            NavigationUI.setupWithNavController(bottomNav, navController);
        }
    }
}