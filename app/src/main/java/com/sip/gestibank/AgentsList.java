package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import android.widget.ListView;

import com.sip.gestibank.models.Agent;
import com.sip.gestibank.remote.AgentService;
import com.sip.gestibank.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgentsList extends AppCompatActivity {

    AgentService agentService;
    List<Agent> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_list);

        agentService = ApiUtils.getAgentService();

        listView = findViewById(R.id.listCustomers);

            Call<List<Agent>> call = agentService.getAgentsList();

            call.enqueue(new Callback<List<Agent>>() {
                @Override
                public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                    if(response.isSuccessful()){
                        System.out.println(response.body());
                        list = response.body();
                        listView.setAdapter(new AgentsListAdapter(AgentsList.this, list));
                    }else {
                        System.out.println(response.code());
                    }

                }
                @Override
                public void onFailure(Call<List<Agent>> call, Throwable t) {
                    Log.e("ERROR: ", t.getMessage());
                }
            });



    }


}





