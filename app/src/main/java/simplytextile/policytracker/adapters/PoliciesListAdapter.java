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
import simplytextile.policytracker.models.PolicyList;

/**
 * Created by shmahe on 21-09-2018.
 */

public class PoliciesListAdapter extends RecyclerView.Adapter<PoliciesListAdapter.ViewHolderss>
{

    List<PolicyList> policy_list;
    Context context;

    public PoliciesListAdapter(List<PolicyList> policy_list, Context context) {
        this.policy_list = policy_list;
        this.context = context;
    }

    @NonNull
    @Override
    public PoliciesListAdapter.ViewHolderss onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.policies_adapter, viewGroup, false);
        return new ViewHolderss(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoliciesListAdapter.ViewHolderss viewHolderss, int i)
    {
        viewHolderss.text1.setText(""+policy_list.get(i).getPolicy_number());
        viewHolderss.text2.setText(""+policy_list.get(i).getCommission_amount());
    }

    @Override
    public int getItemCount() {
        return policy_list.size();
    }
    class ViewHolderss extends RecyclerView.ViewHolder
    {
        TextView text2,text1;
        public ViewHolderss(@NonNull View itemView)
        {
            super(itemView);
            text2=(TextView)itemView.findViewById(R.id.text2);
            text1=(TextView)itemView.findViewById(R.id.text1);
        }
    }
}
