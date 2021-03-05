package com.sip.gestibank.remote;

import com.sip.gestibank.models.Agent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AgentService {

    @GET("/agents/list")
    Call<List<Agent>> getAgentsList();

    @PUT("/agents/update/:matricule")
    Call<List<Agent>> putAgent();

    @DELETE("/agents/delete/:matricule")
    Call<List<Agent>> deleteAgent();

    @POST("/agents/add")
    Call<Agent> postAgent(@Body Agent agent);

}
