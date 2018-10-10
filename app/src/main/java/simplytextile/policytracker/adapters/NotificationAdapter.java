package simplytextile.policytracker.adapters;

import android.app.Notification;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import simplytextile.policytracker.NotificationResponse.NotificationList;
import simplytextile.policytracker.R;
import simplytextile.policytracker.activties.CustomerActivity;
import simplytextile.policytracker.models.CustomerList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>
{

    List<NotificationList> notification_list;
    Context context;

    public NotificationAdapter(List<NotificationList> notification_list, Context context)
    {
        this.notification_list = notification_list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notification_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        viewHolder.policy_number.setText(""+notification_list.get(i).getPolicy().getPolicy_number());
       // viewHolder.coverage_info.setText(""+notification_list.get(i).getPolicy().getCoverageInfo().getStart_date()+"( "+notification_list.get(i).getPolicy().getCoverageInfo().getEnd_date()+" )");
        viewHolder.policy_stdate.setText(""+notification_list.get(i).getPolicy().getCoverage_info().getStart_date());
        viewHolder.policy_end_date.setText(""+notification_list.get(i).getPolicy().getCoverage_info().getEnd_date());
        viewHolder.customer_name.setText(""+notification_list.get(i).getPolicy().getCustomer().getFirst_name()+"("+notification_list.get(i).getPolicy().getCustomer().getLast_name()+" )");
        viewHolder.business_name.setText(""+notification_list.get(i).getPolicy().getCompany().getBusiness_name());
       // viewHolder.company_business_name.setText(""+notification_list.get(i).getPolicy().getCompany().getBusiness_name());
        viewHolder.format_id.setText(""+notification_list.get(i).getFormat().getName());
        viewHolder.type_id.setText(""+notification_list.get(i).getType().getName());
    }
    @Override
    public int getItemCount()
    {
    return notification_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView policy_number,coverage_info,policy_stdate,customer_name,business_name,policy_end_date,company_business_name,
                format_id,type_id;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            policy_number=(TextView)itemView.findViewById(R.id.policy_number);
            //coverage_info=(TextView)itemView.findViewById(R.id.coverage_info);
            policy_stdate=(TextView)itemView.findViewById(R.id.customer_id);
            customer_name=(TextView)itemView.findViewById(R.id.customer_name);
            business_name=(TextView)itemView.findViewById(R.id.business_name);
            //company_business_name=(TextView)itemView.findViewById(R.id.company_business_name);
            policy_end_date=(TextView)itemView.findViewById(R.id.policy_end_date);
            format_id=(TextView)itemView.findViewById(R.id.format_id);
            type_id=(TextView)itemView.findViewById(R.id.type_id);
        }
    }
}
