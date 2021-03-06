package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomerHome extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);


        String nameSession = getIntent().getStringExtra("username");
        TextView nameAuth;

        nameAuth = findViewById(R.id.viewNameCustomerAuth);
        nameAuth.setText(nameSession);

    }

    public void callGoHome(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

}