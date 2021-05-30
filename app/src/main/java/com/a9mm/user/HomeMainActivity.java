package com.a9mm.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a9mm.user.fragments_home.FragmentGoOut;
import com.a9mm.user.fragments_home.FragmentGold;
import com.a9mm.user.fragments_home.FragmentOrder;
import com.a9mm.user.fragments_home.FragmentVideo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeMainActivity extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationView bottomNavigation;

    DrawerLayout drawerLayout;
    ImageView navigationBar,iv_logout;
    LinearLayout ll_First,ll_Second,ll_Third,ll_Fourth,ll_Fifth,ll_Sixth,ll_Seventh;
    NavigationView navigationView;
    TextView tv_logout;

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
        onSetNavigationDrawerEvents();
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

    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        //drawerLayout.openDrawer(GravityCompat.END);

        navigationBar = (ImageView) findViewById(R.id.navigationBar);
        ll_First = (LinearLayout) findViewById(R.id.ll_First);
        ll_Second = (LinearLayout) findViewById(R.id.ll_Second);
        ll_Third = (LinearLayout) findViewById(R.id.ll_Third);
        ll_Fourth = (LinearLayout) findViewById(R.id.ll_Fourth);
        ll_Fifth = (LinearLayout) findViewById(R.id.ll_Fifth);
        ll_Sixth = (LinearLayout) findViewById(R.id.ll_Sixth);
        ll_Seventh = (LinearLayout) findViewById(R.id.ll_Seventh);

        iv_logout = (ImageView) findViewById(R.id.iv_logout);
        tv_logout = (TextView) findViewById(R.id.tv_logout);

        navigationBar.setOnClickListener(this);
        ll_First.setOnClickListener(this);
        ll_Second.setOnClickListener(this);
        ll_Third.setOnClickListener(this);
        ll_Fourth.setOnClickListener(this);
        ll_Fifth.setOnClickListener(this);
        ll_Sixth.setOnClickListener(this);
        ll_Seventh.setOnClickListener(this);
        iv_logout.setOnClickListener(this);
        tv_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.ll_First:
                showToast("ll_First");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Second:
                showToast("ll_Second");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Third:
                showToast("ll_Third");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Fourth:
                showToast("ll_Fourth");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Fifth:
                showToast("ll_Fifth");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Sixth:
                showToast("ll_Sixth");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Seventh:
                showToast("ll_Seventh");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.iv_logout:
                showToast("iv_logout");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.tv_logout:
                showToast("tv_logout");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            default:
                showToast("Default");
                drawerLayout.closeDrawer(navigationView, true);
                break;

        }
    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView, true);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}