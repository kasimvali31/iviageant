package simplytextile.policytracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import simplytextile.policytracker.R;
import simplytextile.policytracker.models.CustomerList;

/**
 * Created by shmahe on 21-09-2018.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolderss>
{
    List<CustomerList> customer_list;
    Context context;

    public CustomerListAdapter(List<CustomerList> customer_list, Context context) {
        this.customer_list = customer_list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerListAdapter.ViewHolderss onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bill_details_admin, viewGroup, false);
        return new ViewHolderss(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerListAdapter.ViewHolderss viewHolderss, int i) {

       // viewHolderss.mtext.setText(""+customer_list.get(i).getId()+" ("+customer_list.get(i).getFirst_name()+" )");

        viewHolderss.lastname_customer.setText(""+customer_list.get(i).getLast_name());
        viewHolderss.mobile.setText(""+customer_list.get(i).getAddress().getPhone1());
       // viewHolderss.customer_id_proof_proof.setText(""+customer_list.get(i).getId()+" ( "+customer_list.get(i).getGovt_id_number()+" )");
      //  viewHolderss.customer_address.setText(""+customer_list.get(i).getAddress().getAddress1()+","+customer_list.get(i).getAddress().getCity()+","+
        //        customer_list.get(i).getAddress().getState()+","+customer_list.get(i).getAddress().getZip());
        viewHolderss.customer_email.setText(""+customer_list.get(i).getAddress().getEmail1());
     //   viewHolderss.customer_dob.setText(""+customer_list.get(i).getDate_of_birth());
    }

    @Override
    public int getItemCount()
    {
        return customer_list.size();
    }
    class ViewHolderss extends RecyclerView.ViewHolder
    {
        TextView mtext,lastname_customer,mobile,customer_id_proof_proof,customer_address,customer_email,customer_dob;
        public ViewHolderss(@NonNull View itemView) {
            super(itemView);
        //    mtext=(TextView)itemView.findViewById(R.id.mtext_customer_id_name);
            lastname_customer=(TextView)itemView.findViewById(R.id.lastname_customer);
            mobile=(TextView)itemView.findViewById(R.id.mobile);
         //   customer_id_proof_proof=(TextView)itemView.findViewById(R.id.customer_id_proof_proof);
         //   customer_address=(TextView)itemView.findViewById(R.id.customer_address);
            customer_email=(TextView)itemView.findViewById(R.id.customer_email);
        //    customer_dob=(TextView)itemView.findViewById(R.id.customer_dob);
        }
    }
}
