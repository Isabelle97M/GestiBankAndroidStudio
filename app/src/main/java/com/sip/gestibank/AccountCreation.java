package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sip.gestibank.models.Customer;
import com.sip.gestibank.remote.ApiUtils;
import com.sip.gestibank.remote.CustomerService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountCreation extends AppCompatActivity {

    EditText name, firstname, tel, email;
    CustomerService customerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        customerService = ApiUtils.getCustomerService();


        firstname = (EditText) findViewById(R.id.editFirstNameCreation);
        name = (EditText) findViewById(R.id.editNameCreation);
        tel = (EditText) findViewById(R.id.editPhoneCreation);
        email = (EditText) findViewById(R.id.editEmailCreation);


    }

    public void callGoBackHomeCreation(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void callGoToAuthentification(View view){
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }

    public void newCustomerAccount(View v){
        Customer customer= new Customer(
                firstname.getText().toString(),
                name.getText().toString(),
                email.getText().toString(),
                tel.getText().toString()
        );
        Call<Customer> call = customerService.addCustomer(customer);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AccountCreation.this, "Customer account created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }



}