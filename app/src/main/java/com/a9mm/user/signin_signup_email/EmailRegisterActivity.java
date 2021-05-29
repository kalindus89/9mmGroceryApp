package com.a9mm.user.signin_signup_email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.a9mm.user.Login_Main_Activity;
import com.a9mm.user.R;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class EmailRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_register_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = this.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public void  goToLogin(View view){
        Intent intent = new Intent(EmailRegisterActivity.this, EmailLoginActivity.class);
        startActivity(intent);
        Animatoo.animateSlideLeft(EmailRegisterActivity.this);
        finish();
    }
    public void  backToMainLoginPage(View view){
        Intent intent = new Intent(EmailRegisterActivity.this, Login_Main_Activity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(EmailRegisterActivity.this);
        finish();
    }
}