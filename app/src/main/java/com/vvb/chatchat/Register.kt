package com.vvb.chatchat

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider.*
import com.rilixtech.widget.countrycodepicker.CountryCodePicker
import java.util.concurrent.TimeUnit.*

class Register : AppCompatActivity() {
}
/*
    val TAG = "TAG"
    var verificationId: String? = null
    var token: ForceResendingToken? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var fAuth = FirebaseAuth.getInstance()
        var phonenumber = findViewById<EditText>(R.id.phone)
        var CodeEnter = findViewById<EditText>(R.id.codeEnter)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var nextBtn = findViewById<Button>(R.id.nextBtn)
        var textView2 = findViewById<TextView>(R.id.textView2)
        var codePicker = findViewById<CountryCodePicker>(R.id.ccp)

        // nextBtn.setOnClickListener(View)

        nextBtn.setOnClickListener {
            if (phonenumber.getText().toString().isEmpty() && phonenumber.getText()
                    .toString().length == 10
            ) {
                val phoneNum =
                    "+" + codePicker.selectedCountryCode + phonenumber.getText().toString()
                Log.d(TAG, "OnClick: Phone No$phoneNum")
             //  requestOTP(phoneNum)
            } else {
                phonenumber.setError("Phone Number is Not Valid Please try Again")
            }
        }

    }



    }


*/



