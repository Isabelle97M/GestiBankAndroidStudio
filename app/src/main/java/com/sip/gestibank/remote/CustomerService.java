package com.sip.gestibank.remote;

import com.sip.gestibank.models.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CustomerService {

    @GET("list/")
    Call<List<Customer>> getCustomers();

    @GET("list/attente")
    Call<List<Customer>> getCustomersWaiting();

    @GET("list/valide")
    Call<List<Customer>> getCustomersValidated();

    @POST("add/")
    Call<Customer> addCustomer(@Body Customer customer);
}
