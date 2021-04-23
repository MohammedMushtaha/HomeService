package com.voise.homeservisegraduateproject.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.ui.ui.home.HomeFragment;
import com.voise.homeservisegraduateproject.ui.ui.moreApp.MoreFragment;
import com.voise.homeservisegraduateproject.ui.ui.order.PlaceholderFragment;
import com.voise.homeservisegraduateproject.ui.ui.userSetting.UserSettingFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_notifications1)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment(getApplication())).commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                         getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment(getApplication())).commit();

                        return true;
                    case R.id.navigation_order:
                         getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new PlaceholderFragment(getApplication())).commit();

                        return true;
                    case R.id.navigation_notifications:
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new UserSettingFragment(getApplication())).commit();

                        return true;
                    case R.id.navigation_more:
                        Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new MoreFragment(getApplication())).commit();

                        return true;
                }
                return false;
            }
        });
    }

}