package com.sip.gestibank.remote;

import com.sip.gestibank.models.Customer;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CustomerService {

    @GET("/customers/list")
    Call<List<Customer>> getCustomers();

    @GET("/customers/list/attente")
    Call<List<Customer>> getCustomersWaiting();

    @GET("/customers/list/valide")
    Call<List<Customer>> getCustomersValidated();

    @POST("/customers/add")
    Call<Customer> addCustomer(@Body Customer customer);

    @PUT("/customers/update/{email}")
    Call<Customer> updateCustomerDetails(@Path("email") String email);

    @DELETE("/customers/delete/{email}")
    Call<Customer> deleteCustomerByEmail(@Path("email") String email);
}
