package com.sip.gestibank;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


import com.sip.gestibank.models.Agent;

import java.util.List;


public class AgentsListAdapter extends BaseAdapter {

    private List<Agent> listAgent;
    private LayoutInflater layoutInflater;
    private Context context;

    public AgentsListAdapter(Context aContext, List<Agent> listData) {
        this.context = aContext;
        this.listAgent = listData;
        layoutInflater = LayoutInflater.from(aContext);

    }
    @Override
    public int getCount() {
        return listAgent.size();
    }
    @Override
    public Object getItem(int position) {
        return listAgent.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_agent_layout, null);
            holder = new ViewHolder();
            holder.agentName = (TextView)
                    convertView.findViewById(R.id.viewAgentName);
            holder.agentFirstName = (TextView)
                    convertView.findViewById(R.id.viewAgentFirstName);
            holder.agentMatricule = (TextView)
                    convertView.findViewById(R.id.viewAgentMatricule);
            holder.btnAgentInfo = (Button)
                    convertView.findViewById(R.id.btnAgentDetails);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Agent agent = this.listAgent.get(position);
        holder.agentName.setText("Nom : " +agent.getName());
        holder.agentFirstName.setText("Prénom : " + agent.getFirstname());
        holder.agentMatricule.setText("Matricule : " + agent.getMatricule());
        holder.btnAgentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView agentName;
        TextView agentFirstName;
        TextView agentMatricule;
        Button btnAgentInfo;
    }


}
