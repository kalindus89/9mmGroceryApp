package com.a9mm.user.email_signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.a9mm.user.R;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class EmailLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_login_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = this.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public void  goToRegister(View view){
        Intent intent = new Intent(EmailLoginActivity.this, EmailRegisterActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeLeft(EmailLoginActivity.this);
        finish();
    }
}