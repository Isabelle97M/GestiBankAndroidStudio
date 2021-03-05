package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdministratorHome extends AppCompatActivity {

    Button btnAgentsList, btnAddAgent, btnCustomersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_home);

        String nameSession = getIntent().getStringExtra("username");
        TextView nameAuth;
        nameAuth = findViewById(R.id.viewNameAdminAuth);
        nameAuth.setText(nameSession);

        btnAgentsList = (Button) findViewById(R.id.btnAgentsList);
        btnAddAgent = (Button) findViewById(R.id.btnAddAgentForm);
        btnCustomersList = (Button) findViewById(R.id.btnAgentAffectation);

    }

    public void callAgentsList(View view) {
        Intent i = new Intent(getApplicationContext(), AgentsList.class);
        startActivity(i);
    }

    public void callAddAgentForm(View view) {
        Intent i = new Intent(getApplicationContext(), AddNewAgent.class);
        startActivity(i);
    }

    public void callCustomersList(View view) {
        Intent i = new Intent(getApplicationContext(), CustomersList.class);
        startActivity(i);
    }

}