package com.vvb.chatchat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {



   public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    EditText CodeEnter,PhoneNumber;
    Button nextBtn;
    ProgressBar progressBar;
    TextView textView2;
    CountryCodePicker codePicker;
    String verificationId;
    PhoneAuthProvider.ForceResendingToken token;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();
        PhoneNumber = findViewById(R.id.phone);
        CodeEnter = findViewById(R.id.codeEnter);
        progressBar = findViewById(R.id.progressBar);
        nextBtn = findViewById(R.id.nextBtn);
        textView2 = findViewById(R.id.textView2);//state
        codePicker = findViewById(R.id.ccp);

     nextBtn.setOnClickListener(v -> {
         if (PhoneNumber.getText().toString().isEmpty() && PhoneNumber.getText().toString().length() == 10){

             String phoneNum = "+"+codePicker.getSelectedCountryCode()+PhoneNumber.getText().toString();
             Log.d(TAG,"OnClick: Phone No" + phoneNum);
             progressBar.setVisibility(View.VISIBLE);
             textView2.setText("Sending OTP....");
             textView2.setVisibility(View.VISIBLE);
             requestOTP(phoneNum);

         }else {
             PhoneNumber.setError("Phone Number is Not Valid Please try Again");
         }

     });




    }

    @SuppressWarnings("deprecation")
    private void requestOTP(String phoneNum) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNum, 60L, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                progressBar.setVisibility(View.GONE);
                textView2.setVisibility(View.GONE);
                CodeEnter.setVisibility(View.VISIBLE);
                verificationId = s;
                token = forceResendingToken;
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                          }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(MainActivity2.this, "Can not Create an Account" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}