package com.a9mm.user.signin_singup_phone;

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

import com.a9mm.user.Login_Main_Activity;
import com.a9mm.user.R;
import com.a9mm.user.signin_signup_email.EmailRegisterActivity;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class PhoneLoginActivity extends AppCompatActivity {

    EditText phoneNumber;
    Button conBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_login_activity);

        //to hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        conBtn = (Button) findViewById(R.id.conBtn);
        buttonOnclick();
    }

    public void buttonOnclick(){
        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = phoneNumber.getText().toString().trim();

                if(TextUtils.isEmpty(phone)){
                    phoneNumber.setError("phoneNumber is required");
                }else{

                    ProgressDialog dialog = new ProgressDialog(PhoneLoginActivity.this);
                    dialog.setTitle("Loading...");
                    dialog.setMessage("Please wait we are checking your credentials");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Toast.makeText(PhoneLoginActivity.this, "Success Phone Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goToRegister_phone(View view) {
        Intent intent = new Intent(PhoneLoginActivity.this, PhoneRegisterActivity.class);
        startActivity(intent);
        Animatoo.animateSlideLeft(PhoneLoginActivity.this);
        finish();
    }

    public void backToMainLoginPage(View view) {
        Intent intent = new Intent(PhoneLoginActivity.this, Login_Main_Activity.class);
        startActivity(intent);
        Animatoo.animateSlideRight(PhoneLoginActivity.this);
        finish();
    }

}