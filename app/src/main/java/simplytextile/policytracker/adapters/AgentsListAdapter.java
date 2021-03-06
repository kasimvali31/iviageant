package simplytextile.policytracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import simplytextile.policytracker.R;
import simplytextile.policytracker.activties.UpdateAgent;
import simplytextile.policytracker.models.AgentList;

/**
 * Created by shmahe on 21-09-2018.
 */

public class AgentsListAdapter extends RecyclerView.Adapter<AgentsListAdapter.ViewHolders>
{

    List<AgentList> agentList;
    Context context;

    public AgentsListAdapter(List<AgentList> agentList, Context context)
    {
        this.agentList = agentList;
        this.context = context;
    }

    @NonNull
    @Override
    public AgentsListAdapter.ViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.agents_list_adapter, viewGroup, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgentsListAdapter.ViewHolders viewHolders, final int i)
    {
        //viewHolders.agents_id_name.setText(""+agentList.get(i).getId()+" ( "+agentList.get(i).getFirst_name()+" )");
        viewHolders.agents_id_lastname.setText(""+agentList.get(i).getFirst_name()+""+agentList.get(i).getLast_name());
        //viewHolders.agents_id_business_name.setText(""+agentList.get(i).getBusiness_name());
      //  viewHolders.agents_id_govt_details.setText(""+agentList.get(i).getGovt_id_number()+" ( "+agentList.get(i).getAadhar_number());
     //   viewHolders.agents_id_address.setText(""+agentList.get(i).getAddress().getAddress1()+","+agentList.get(i).getAddress().getCity()+","+
       //         agentList.get(i).getAddress().getState()+","+agentList.get(i).getAddress().getZip());
        viewHolders.agents_id_phone.setText(""+agentList.get(i).getAddress().getPhone1());
        viewHolders.agents_id_email.setText(""+agentList.get(i).getAddress().getEmail1());
        viewHolders.edit_agents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent ssp=new Intent(context, UpdateAgent.class);
                ssp.putExtra("bname",""+agentList.get(i).getBusiness_name());
                ssp.putExtra("fname",""+agentList.get(i).getFirst_name());
                ssp.putExtra("lname",""+agentList.get(i).getLast_name());
                ssp.putExtra("email",""+agentList.get(i).getAddress().getEmail1());
                ssp.putExtra("ph1",""+agentList.get(i).getAddress().getPhone1());
                ssp.putExtra("ph2",""+agentList.get(i).getAddress().getPhone2());
                ssp.putExtra("aadar",""+agentList.get(i).getAadhar_number());
                ssp.putExtra("pan",""+agentList.get(i).getGovt_id_number());
                ssp.putExtra("add1",""+agentList.get(i).getAddress().getAddress1());
                ssp.putExtra("city",""+agentList.get(i).getAddress().getCity());
                ssp.putExtra("state",""+agentList.get(i).getAddress().getState());
                ssp.putExtra("zip",""+agentList.get(i).getAddress().getZip());
                context.startActivity(ssp);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return agentList.size();
    }
    class ViewHolders extends RecyclerView.ViewHolder
    {
        TextView agents_id_email,agents_id_phone,agents_id_address,agents_id_cretaed_on,agents_id_govt_details,
                agents_id_business_name,agents_id_lastname,agents_id_name;
        ImageView edit_agents;
        public ViewHolders(@NonNull View itemView)
        {
            super(itemView);

           // agents_id_name=(TextView)itemView.findViewById(R.id.agents_id_name);
            agents_id_lastname=(TextView)itemView.findViewById(R.id.agents_id_lastname);
          //  agents_id_business_name=(TextView)itemView.findViewById(R.id.agents_id_business_name);
         //   agents_id_govt_details=(TextView)itemView.findViewById(R.id.agents_id_govt_details);
         //   agents_id_cretaed_on=(TextView)itemView.findViewById(R.id.agents_id_cretaed_on);
        //    agents_id_address=(TextView)itemView.findViewById(R.id.agents_id_address);
            agents_id_phone=(TextView)itemView.findViewById(R.id.agents_id_phone);
            agents_id_email=(TextView)itemView.findViewById(R.id.agents_id_email);
            edit_agents=(ImageView) itemView.findViewById(R.id.edit_agents);

        }
    }
}
