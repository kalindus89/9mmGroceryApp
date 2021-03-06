package com.a9mm.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.a9mm.user.adapters.CatAdapter;
import com.a9mm.user.adapters.PlateAdapter;
import com.a9mm.user.retrofit_api.ApiClient;
import com.a9mm.user.retrofit_api.ApiInterface;
import com.a9mm.user.retrofit_api.Users;
import com.a9mm.user.sessions.SessionManager;
import com.a9mm.user.signin_signup_email.EmailLoginActivity;
import com.a9mm.user.models.PlateModel;
import com.a9mm.user.signin_singup_phone.PhoneLoginActivity;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Main_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PlateModel> plateModelList;
    private PlateAdapter plateAdapter;
    LinearLayout linear_email, linear_phone;
    Button skipToMainPage;
    SessionManager sessionManager;

    public static ApiInterface apiInterface;

    @Override
    protected void onStart() {
        super.onStart();

        if(sessionManager.isLogin()){
            Intent intent = new Intent(Login_Main_Activity.this, HomeMainActivity.class);
            startActivity(intent);
            finish();
            Animatoo.animateSlideLeft(this);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main_activity);

        //to hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sessionManager = new SessionManager(this);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        linear_email = (LinearLayout) findViewById(R.id.linear_email);
        linear_phone = (LinearLayout) findViewById(R.id.linear_phone);
        skipToMainPage = (Button) findViewById(R.id.buttonSkip);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);

        plateModelList = new ArrayList<>();

       /* Call<Users> categoryCall = apiInterface.getCategoriesPlate();
        categoryCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {


                // database column names and Model names must match: eg: both as to cat_title or cat_image

               System.out.println("aaaaaaaaaa "+response.body().getCategoryPlate().toString());
                plateModelList= response.body().getCategoryPlate();
                plateAdapter = new PlateAdapter(Login_Main_Activity.this, plateModelList);
                recyclerView.setAdapter(plateAdapter);
                plateAdapter.notifyDataSetChanged();
                autoScroll();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
            }
        });*/
       plateModelList.add(new PlateModel(R.drawable.buger_one));
        plateModelList.add(new PlateModel(R.drawable.buger_one));
        plateModelList.add(new PlateModel(R.drawable.buger_one));
        plateModelList.add(new PlateModel(R.drawable.buger_one));
        plateModelList.add(new PlateModel(R.drawable.buger_one));
        plateModelList.add(new PlateModel(R.drawable.buger_one));

        plateAdapter = new PlateAdapter(Login_Main_Activity.this, plateModelList);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();
        autoScroll();


      //
        //this function is for auto scrolling the listview
        linear_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Main_Activity.this, EmailLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideLeft(Login_Main_Activity.this);
                finish();
            }
        });

        linear_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Main_Activity.this, PhoneLoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideLeft(Login_Main_Activity.this);
                finish();
            }
        });

        skipToMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Main_Activity.this, HomeMainActivity.class);
                startActivity(intent);
                Animatoo.animateSlideLeft(Login_Main_Activity.this);
                finish();
            }
        });
    }

    public void autoScroll() {
        final int speedScroll = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {

                if (count == plateAdapter.getItemCount()) {
                    count = 0;
                }
                if (count < plateAdapter.getItemCount()) {
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this, speedScroll);
                }
            }
        };
        handler.postDelayed(runnable, speedScroll);
    }
}