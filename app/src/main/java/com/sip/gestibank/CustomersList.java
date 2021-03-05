package com.sip.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sip.gestibank.models.Customer;
import com.sip.gestibank.remote.CustomerService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomersList extends AppCompatActivity {

    CustomerService customerService;
    List<Customer>list;
    ListView listView;
    Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list);

        btnDisplay = findViewById(R.id.btnDisplay);
        listView = findViewById(R.id.listViewCustomers);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCustomersList();
            }
        });

    }

    public void getCustomersList(){
        Call<List<Customer>> call = customerService.getCustomers();
        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());
                    StringBuffer buffer=new StringBuffer();
                    for (Customer customer : list)
                    {

                        buffer.append("Nom: "+customer.getName()+"\n");
                        buffer.append("Prénom: "+customer.getFirstname()+"\n\n");

                    }
                    showMessage("Customers List", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}