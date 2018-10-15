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

import java.util.List;

import simplytextile.policytracker.R;
import simplytextile.policytracker.activties.UpdateUserProfileActivity;
import simplytextile.policytracker.models.CustomerList;

/**
 * Created by shmahe on 21-09-2018.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolderss>
{
    List<CustomerList> customer_list;
    Context context;

    public CustomerListAdapter(List<CustomerList> customer_list, Context context)
    {
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
    public void onBindViewHolder(@NonNull CustomerListAdapter.ViewHolderss viewHolderss, final int i)
    {

        //viewHolderss.mtext.setText(""+customer_list.get(i).getId());
        viewHolderss.lastname_customer.setText(""+customer_list.get(i).getLast_name());
        viewHolderss.mobile.setText(""+customer_list.get(i).getAddress().getPhone1());
        viewHolderss.customer_email.setText(""+customer_list.get(i).getAddress().getEmail1());
     //   viewHolderss.customer_dob.setText(""+customer_list.get(i).getDate_of_birth());
        viewHolderss.edit_bill_details.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent ss=new Intent(context, UpdateUserProfileActivity.class);
                ss.putExtra("bname",""+customer_list.get(i).getBusiness_name());
                ss.putExtra("fname",""+customer_list.get(i).getFirst_name());
                ss.putExtra("lname",""+customer_list.get(i).getLast_name());
                ss.putExtra("dob",""+customer_list.get(i).getDate_of_birth());
                ss.putExtra("email",""+customer_list.get(i).getAddress().getEmail1());
                ss.putExtra("p1",""+customer_list.get(i).getAddress().getPhone1());
                ss.putExtra("p2",""+customer_list.get(i).getAddress().getPhone2());
                ss.putExtra("aadar",""+customer_list.get(i).getAadhar_number());
                ss.putExtra("pan",""+customer_list.get(i).getGovt_id_number());
                ss.putExtra("add1",""+customer_list.get(i).getAddress().getAddress1());
                ss.putExtra("city",""+customer_list.get(i).getAddress().getCity());
                ss.putExtra("state",""+customer_list.get(i).getAddress().getState());
                ss.putExtra("pin",""+customer_list.get(i).getAddress().getZip());
                context.startActivity(ss);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return customer_list.size();
    }
    class ViewHolderss extends RecyclerView.ViewHolder
    {
        TextView mtext,lastname_customer,mobile,customer_id_proof_proof,customer_address,customer_email,customer_dob;
        ImageView edit_bill_details,delete_bill_details;
        public ViewHolderss(@NonNull View itemView)
        {
            super(itemView);
            //mtext=(TextView)itemView.findViewById(R.id.mtext_customer_id_name);
            lastname_customer=(TextView)itemView.findViewById(R.id.lastname_customer);
            mobile=(TextView)itemView.findViewById(R.id.mobile);
         //   customer_address=(TextView)itemView.findViewById(R.id.customer_address);
            customer_email=(TextView)itemView.findViewById(R.id.customer_email);
            edit_bill_details=(ImageView)itemView.findViewById(R.id.edit_bill_details);
            delete_bill_details=(ImageView)itemView.findViewById(R.id.delete_bill_details);
        //    customer_dob=(TextView)itemView.findViewById(R.id.customer_dob);
        }
    }
}
