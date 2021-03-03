package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button btnCreateAccount, btnConverter;
    //JsonCurrencyApi jsonCurrencyApi;
    //List<Currency> list = new ArrayList<Currency>();

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

}