package com.sip.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sip.gestibank.models.Agent;
import com.sip.gestibank.models.Customer;
import com.sip.gestibank.remote.ApiUtils;
import com.sip.gestibank.remote.CustomerService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomersList extends AppCompatActivity {

    CustomerService customerService;
    List<Customer> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list);

        customerService = ApiUtils.getCustomerService();

        listView = findViewById(R.id.listCustomers);

        Call<List<Customer>> call = customerService.getCustomers();

        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                    list = response.body();
                    listView.setAdapter(new CustomerListAdapter(CustomersList.this, list));
                } else {
                    System.out.println(response.code());
                }

            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }



    }