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
import com.a9mm.user.retrofit_api.ApiClient;
import com.a9mm.user.retrofit_api.ApiInterface;
import com.a9mm.user.retrofit_api.Users;
import com.a9mm.user.signin_signup_email.EmailRegisterActivity;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneLoginActivity extends AppCompatActivity {

    EditText phoneNumber, otp;
    Button conBtn, otpBtn;
    public static ApiInterface apiInterface;

    //phone otp
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    private FirebaseAuth mAuth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_login_activity);

        //to hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        otp = (EditText) findViewById(R.id.otp);
        conBtn = (Button) findViewById(R.id.conBtn);
        otpBtn = (Button) findViewById(R.id.otpBtn);

        mAuth = FirebaseAuth.getInstance();

        dialog = new ProgressDialog(PhoneLoginActivity.this);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait we are checking your credentials");
        dialog.setCanceledOnTouchOutside(false);

        buttonOnclick();
        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

                //   signInWithPhoneAuthCredential(credential);
                Toast.makeText(PhoneLoginActivity.this, "Already Login using phone number", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                dialog.dismiss();
                phoneNumber.setVisibility(View.VISIBLE);
                conBtn.setVisibility(View.VISIBLE);
                otp.setVisibility(View.GONE);
                otpBtn.setVisibility(View.GONE);

                System.out.println("aaaaaaaaaaaaaa "+e.getMessage());
                Toast.makeText(PhoneLoginActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {

                mVerificationId = verificationId;
                mResendToken = token;

                phoneNumber.setVisibility(View.GONE);
                conBtn.setVisibility(View.GONE);
                otp.setVisibility(View.VISIBLE);
                otpBtn.setVisibility(View.VISIBLE);
                dialog.dismiss();
                Toast.makeText(PhoneLoginActivity.this, "Code has been Sent. please Verify it.", Toast.LENGTH_SHORT).show();

            }
        };
    }

    public void buttonOnclick() {
        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneNumber.getText().toString().trim();

                if (TextUtils.isEmpty(phone)) {
                    phoneNumber.setError("phoneNumber is required");
                } else if (phoneNumber.getText().toString().trim().length() < 9) {
                    phoneNumber.setError("phoneNumber is not correct");
                } else {
                    dialog.show();
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phoneNumber.getText().toString().trim(),
                            60,
                            TimeUnit.SECONDS,
                            PhoneLoginActivity.this,
                            callbacks);
                }
            }
        });

        otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp_text = otp.getText().toString().trim();

                if (TextUtils.isEmpty(otp_text)) {
                    otp.setError("Please enter the OTP");
                } else {
                    dialog.show();
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp_text);
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            loginNow();
                        } else {
                            Toast.makeText(PhoneLoginActivity.this, "Something went wrong 1", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void loginNow() {


            Call<Users> call = apiInterface.performPhoneLogin(phoneNumber.getText().toString().trim());
            call.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    if (response.body().getResponse().equals("ok")) {
                        Toast.makeText(PhoneLoginActivity.this, "Login Success " + response.body().getUserId(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else if (response.body().getResponse().equals("No account")) {
                        Toast.makeText(PhoneLoginActivity.this, "No account", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(PhoneLoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {

                    Toast.makeText(PhoneLoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();

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