package com.a9mm.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.a9mm.user.fragments_home.FragmentGoOut;
import com.a9mm.user.fragments_home.FragmentGold;
import com.a9mm.user.fragments_home.FragmentOrder;
import com.a9mm.user.fragments_home.FragmentVideo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        //to hide statusbar
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentOrder()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.orders:
                            selectedFragment = new FragmentOrder();
                            break;
                        case R.id.goOut:
                            selectedFragment = new FragmentGoOut();
                            break;
                        case R.id.gold:
                            selectedFragment = new FragmentGold();
                            break;
                        case R.id.videos:
                            selectedFragment = new FragmentVideo();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
                    return true;
                }
            };

}