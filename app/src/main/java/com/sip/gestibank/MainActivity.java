package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callAccountCreation(View view){
        Intent i = new Intent(getApplicationContext(), AccountCreation.class);
        startActivity(i);
    }

    public void callCurrencyConverter(View view){
        Intent i = new Intent(getApplicationContext(), CurrencyConverter.class);
        startActivity(i);
    }

    public void callLoginPage(View view){
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }

}