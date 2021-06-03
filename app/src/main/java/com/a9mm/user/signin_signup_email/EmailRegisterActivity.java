package com.a9mm.user.signin_signup_email;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a9mm.user.HomeMainActivity;
import com.a9mm.user.Login_Main_Activity;
import com.a9mm.user.R;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class EmailRegisterActivity extends AppCompatActivity {

    EditText password_user,email_user,name_user;
    Button conBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_register_activity);

        //to hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name_user = (EditText) findViewById(R.id.name_user);
        email_user = (EditText) findViewById(R.id.email_user);
        password_user = (EditText) findViewById(R.id.password_user);
        conBtn = (Button) findViewById(R.id.conBtn);
        buttonOnclick();
    }

    public void buttonOnclick(){
        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name_user.getText().toString().trim();
                String email = email_user.getText().toString().trim();
                String password = password_user.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    name_user.setError("Name is required");
                }else if(TextUtils.isEmpty(email)){
                    email_user.setError("Email is required");
                }else if(TextUtils.isEmpty(password)){
                    password_user.setError("Password is required");
                }else{
                    ProgressDialog dialog = new ProgressDialog(EmailRegisterActivity.this);
                    dialog.setTitle("Loading...");
                    dialog.setMessage("Please wait we are checking your credentials");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Toast.makeText(EmailRegisterActivity.this, "Success Register", Toast.LENGTH_SHORT).show();
                }

            }
        });
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