package com.a9mm.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = this.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigation);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.orders:
                            Toast.makeText(HomeMainActivity.this, "orders", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.goOut:
                            Toast.makeText(HomeMainActivity.this, "goOut", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.gold:
                            Toast.makeText(HomeMainActivity.this, "gold", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.videos:
                            Toast.makeText(HomeMainActivity.this, "videos", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
            };

}