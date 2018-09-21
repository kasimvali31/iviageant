package simplytextile.policytracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import simplytextile.policytracker.R;
import simplytextile.policytracker.companyresponse.CompanyList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder>
{
    ArrayList<CompanyList> company_list;
    Context context;

    public CompanyAdapter(ArrayList<CompanyList> company_list,Context context)
    {
        this.company_list = company_list;
        this.context=context;
    }

    @NonNull
    @Override
    public CompanyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_companylist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
viewHolder.companyName.setText(company_list.get(i).getBusiness_name());
    }

    @Override
    public int getItemCount()
    {
        return company_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView companyName;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            companyName=(TextView)itemView.findViewById(R.id.companyname);


        }
    }
}
