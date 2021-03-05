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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_list);

        agentService = ApiUtils.getAgentService();

        List<Agent> myAgentsList = getAgentsList();
        final ListView listViewAgent = findViewById(R.id.listAgents);
        listViewAgent.setAdapter(new AgentsListAdapter(this, myAgentsList));

    }


    private List<Agent> getAgentsList(){
        Call<List<Agent>> call = agentService.getAgent();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    int sizeList = list.size();
                    System.out.println("Longueur du fichier Agent : " + sizeList);
                    //listViewAgent.setAdapter(new AgentsListAdapter(AgentsList.this, list));
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

        return list;
    }


}





