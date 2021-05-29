package com.a9mm.user.signin_singup_phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.a9mm.user.Login_Main_Activity;
import com.a9mm.user.R;
import com.a9mm.user.signin_signup_email.EmailLoginActivity;
import com.a9mm.user.signin_signup_email.EmailRegisterActivity;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class PhoneRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_register_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = this.getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

    }

    public void  goTologin_phone(View view){
        Intent intent = new Intent(PhoneRegisterActivity.this, PhoneLoginActivity.class);
        startActivity(intent);
        Animatoo.animateSlideLeft(PhoneRegisterActivity.this);
        finish();
    }
    public void  backToMainLoginPage(View view){
        Intent intent = new Intent(PhoneRegisterActivity.this, Login_Main_Activity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(PhoneRegisterActivity.this);
        finish();
    }
}