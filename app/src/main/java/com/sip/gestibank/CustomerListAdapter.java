package com.sip.gestibank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sip.gestibank.models.Customer;

import java.util.List;

public class CustomerListAdapter extends BaseAdapter {

    private  List<Customer> listCustomer;
    private  LayoutInflater layoutInflater;
    private Context context;

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
        } else {
            holder = (CustomerListAdapter.ViewHolder) convertView.getTag();
        }
        Customer customer = this.listCustomer.get(position);
        holder.customerName.setText("Nom : " +customer.getName() + " " + customer.getFirstname());
        holder.customerAgent.setText("Agent : " + customer.getAgent());
        holder.customerStatus.setText("Status : " + customer.getStatus());

        return convertView;
    }

    static class ViewHolder {
        TextView customerName;
        TextView customerAgent;
        TextView customerStatus;
    }

}
