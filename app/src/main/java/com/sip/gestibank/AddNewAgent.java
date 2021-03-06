package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sip.gestibank.models.Agent;
import com.sip.gestibank.remote.AgentService;
import com.sip.gestibank.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewAgent extends AppCompatActivity {

    AgentService agentService;
    EditText name, firstname, tel, email, matricule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_agent);
        agentService = ApiUtils.getAgentService();

        firstname = findViewById(R.id.editFirstNameAgent);
        name =  findViewById(R.id.editNameAgent);
        tel = findViewById(R.id.editPhoneAgent);
        email =  findViewById(R.id.editEmailAgent);
        matricule = findViewById(R.id.editMatriculeAgent);

    }

    public void callGoAdminHome(View view){
        Intent i = new Intent(getApplicationContext(), AdministratorHome.class);
        startActivity(i);
    }

    public void addAgent(View v){
        Agent agent = new Agent(
                firstname.getText().toString(),
                name.getText().toString(),
                tel.getText().toString(),
                email.getText().toString(),
                matricule.getText().toString()
        );
        Call<Agent> call = agentService.postAgent(agent);
        call.enqueue(new Callback<Agent>() {
            @Override
            public void onResponse(Call<Agent> call, Response<Agent> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AddNewAgent.this, "Customer account created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Agent> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}