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

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    List<NotificationList> notification_list;
    Context context;

    public NotificationAdapter(List<NotificationList> notification_list, Context context) {
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
        viewHolder.mtext.setText(notification_list.get(i).getCompany().getBusiness_name());
    }

    @Override
    public int getItemCount()
    {
    return notification_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mtext;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mtext=(TextView)itemView.findViewById(R.id.name);

        }
    }
}
