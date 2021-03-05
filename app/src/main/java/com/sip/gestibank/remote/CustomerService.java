package com.sip.gestibank.remote;

import com.sip.gestibank.models.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CustomerService {

    @GET("/customers/list")
    Call<List<Customer>> getCustomers();

    @GET("/customers/list/attente")
    Call<List<Customer>> getCustomersWaiting();

    @GET("/customers/list/valide")
    Call<List<Customer>> getCustomersValidated();

    @POST("/customers/add")
    Call<Customer> addCustomer(@Body Customer customer);
}
