package com.sameedshah.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    CountryCodePicker codePicker;
    TextView txtLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
        });

//        picker = findViewById(R.id.ccPicker);
//        Toast.makeText(this, picker.getDefaultCountryCode().toString(), Toast.LENGTH_SHORT).show();
    }
}
