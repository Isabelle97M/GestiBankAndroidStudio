package com.sip.gestibank;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sip.gestibank.models.Customer;
import com.sip.gestibank.remote.CustomerService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerListAdapter extends BaseAdapter {

    private  List<Customer> listCustomer;
    private  LayoutInflater layoutInflater;
    private Context context;
    CustomerService customerService;

    public CustomerListAdapter(Context aContext, List<Customer> listData) {
        this.context = aContext;
        this.listCustomer = listData;
        layoutInflater = LayoutInflater.from(aContext);

    }
    @Override
    public int getCount() {
        return listCustomer.size();
    }
    @Override
    public Object getItem(int position) {
        return listCustomer.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomerListAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_customer_layout, null);
            holder = new CustomerListAdapter.ViewHolder();
            holder.customerName = (TextView)
                    convertView.findViewById(R.id.viewCustomerName);
            holder.customerAgent = (TextView)
                    convertView.findViewById(R.id.viewCustomerAgent);
            holder.customerStatus = (TextView)
                    convertView.findViewById(R.id.viewCustomerStatus);
            holder.customerDetails = (FloatingActionButton)
                    convertView.findViewById(R.id.btnCustomerDetails);
            holder.customerDeleting = (FloatingActionButton)
                    convertView.findViewById(R.id.btnDeleteCustomer);
            convertView.setTag(holder);
        } else {
            holder = (CustomerListAdapter.ViewHolder) convertView.getTag();
        }
        Customer customer = this.listCustomer.get(position);
        holder.customerName.setText("Nom : " +customer.getName() + " " + customer.getFirstname());
        holder.customerAgent.setText("Agent : " + customer.getAgent());
        holder.customerStatus.setText("Status : " + customer.getStatus());
        holder.customerDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setCancelable(true);
                builder.setTitle("Informations Client : ");
                builder.setMessage("Prénom :" + customer.getFirstname() + '\n' +
                        "Nom :" + customer.getName() + '\n' +
                        "E-mail :" + customer.getEmail() + '\n' +
                        "Tel :" + customer.getTel() + '\n' +
                        "Statut : " + customer.getStatus() + '\n' +
                        "Agent : " + customer.getAgent() + '\n' );
                builder.setNegativeButton("FERMER", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }

        });

        return convertView;
    }

    static class ViewHolder {
        TextView customerName;
        TextView customerAgent;
        TextView customerStatus;
        FloatingActionButton customerDetails;
        FloatingActionButton customerDeleting;
    }




}
