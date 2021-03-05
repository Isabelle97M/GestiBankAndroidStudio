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

    private  List<Agent> listData;
    private  LayoutInflater layoutInflater;
    private Context context;

    public AgentsListAdapter(Context aContext, List<Agent> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);

    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
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
            /*holder.btnAgentInfo = (Button)
                    convertView.findViewById(R.id.agentDetails);*/
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Agent agent = this.listData.get(position);
        //System.out.println(listData.size());
        holder.agentName.setText("Nom : " + agent.getName());
        //System.out.println(agent.getName());
        holder.agentFirstName.setText("Prénom : " + agent.getFirstname());
        holder.agentMatricule.setText("Matricule : " + agent.getMatricule());
        /*holder.btnAgentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();
                for (Agent agent : list)
                {

                    buffer.append("Name: "+user.getName()+"\n");
                    buffer.append("Email: "+user.getEmail()+"\n\n");

                }
                showMessage("Clients List", buffer.toString());

                listAgent.toString();
            }
        });*/

        return convertView;
    }

    static class ViewHolder {
        TextView agentName;
        TextView agentFirstName;
        TextView agentMatricule;
        //Button btnAgentInfo;
    }


}
