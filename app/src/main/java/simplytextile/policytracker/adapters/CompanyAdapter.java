package simplytextile.policytracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import simplytextile.policytracker.R;
import simplytextile.policytracker.activties.CompaniesActivity;
import simplytextile.policytracker.companyresponse.CompanyList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder>
{
    ArrayList<CompanyList> company_list;
    private Context context;
    ArrayAdapter aa;


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

//viewHolder.companyName.setText(company_list.get(i).getBusiness_name());
//        int k=company_list.size();
//        viewHolder.a1=new String[k];
//        for(int s=0;s<k;s++)
//        {
//            a1[i]=company_list.get(s).getPolicy_type().getName();        //response.body().getFoodItemCategories().get(i).getCategory();
//        }
//        aa=new ArrayAdapter(context,android.R.layout.simple_spinner_item,a1);
//        viewHolder.selectcompany.setAdapter(aa);
        viewHolder.companyName.setText(company_list.get(i).getPolicy_type().getId().toString());
        viewHolder.Name.setText(company_list.get(i).getPolicy_type().getName());

    }

    @Override
    public int getItemCount()
    {
        return company_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView companyName,Name;
        Spinner selectcompany;
        String a1[];
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            companyName=(TextView)itemView.findViewById(R.id.companyname);
            Name=(TextView)itemView.findViewById(R.id.name);
            selectcompany=(Spinner)itemView.findViewById(R.id.selectcompany_singupactivity);
        }
    }
}
