package simplytextile.policytracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import simplytextile.policytracker.R;
import simplytextile.policytracker.companyresponse.CompanyList;

public class CompaniesListAdapters extends RecyclerView.Adapter<CompaniesListAdapters.ViewH>
{
    ArrayList<CompanyList> company_list;
    Context context;

    public CompaniesListAdapters(ArrayList<CompanyList> company_list, Context context)
    {
        this.company_list = company_list;
        this.context = context;
    }

    @NonNull
    @Override
    public CompaniesListAdapters.ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.company_list_adaptersssss, viewGroup, false);
        return new ViewH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompaniesListAdapters.ViewH viewH, int i)
    {
        viewH.company_id.setText(""+company_list.get(i).getId());
        viewH.company_name.setText(""+company_list.get(i).getBusiness_name());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class ViewH extends RecyclerView.ViewHolder
    {
        TextView company_id,company_name;
        public ViewH(@NonNull View itemView)
        {
            super(itemView);
            company_id=(TextView)itemView.findViewById(R.id.company_id);
            company_name=(TextView)itemView.findViewById(R.id.company_name);
        }
    }
}
