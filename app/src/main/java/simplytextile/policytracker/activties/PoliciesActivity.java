package simplytextile.policytracker.activties;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.R;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.models.PolicyList;
import simplytextile.policytracker.response.PoliciesResponse;

public class PoliciesActivity extends AppCompatActivity
{
    RecyclerView policies_recycler;
    LinearLayoutManager llm;
    ImageView imageView;
    String S_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policies_activity);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue", 0);
        S_id = mPrefs.getString("key", "");
        policies_recycler = (RecyclerView) findViewById(R.id.policies_recycler);
        llm = new LinearLayoutManager(this);
        imageView=(ImageView)findViewById(R.id.image_addbutton);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addcustomer=new Intent(PoliciesActivity.this,AddAgentActivity.class);
                startActivity(addcustomer);
            }
        });


        ApiService planView = ApiClient.getClient().create(ApiService.class);
        Call<PoliciesResponse> policResponse = planView.getPolicies(S_id);
        policResponse.enqueue(new Callback<PoliciesResponse>() {
            @Override
            public void onResponse(Call<PoliciesResponse> call, Response<PoliciesResponse> response)
            {
                if (response.body().getStatuscode() == 0)
                {
                    PoliciesListAdapter aa=new PoliciesListAdapter(response.body().getData().getPolicy_list(),PoliciesActivity.this);
                    policies_recycler.setAdapter(aa);
                    policies_recycler.setLayoutManager(llm);
//                    PoliciesListAdapter adapter=new PoliciesListAdapter(response.body().getData().getPolicy_list(),PoliciesActivity.this);
                } else
                    {
                    Toast.makeText(PoliciesActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PoliciesResponse> call, Throwable t)
            {
                Toast.makeText(PoliciesActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class PoliciesListAdapter extends RecyclerView.Adapter<PoliciesListAdapter.ViewHolderss> {

        List<PolicyList> policy_list;
        Context context;

        public PoliciesListAdapter(List<PolicyList> policy_list, Context context)
        {
            this.policy_list = policy_list;
            this.context = context;
        }

        @NonNull
        @Override
        public PoliciesListAdapter.ViewHolderss onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.policies_adapter, viewGroup, false);
            return new ViewHolderss(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PoliciesListAdapter.ViewHolderss viewHolderss, int i)
        {
            viewHolderss.id.setText("" + policy_list.get(i).getId());
            viewHolderss.policy_name.setText("" + policy_list.get(i).getCustomer().getFirst_name() + "( " + policy_list.get(i).getCustomer().getLast_name() + " )");
            viewHolderss.policy_business_name.setText("" + policy_list.get(i).getCustomer().getBusiness_name());
            viewHolderss.policy_address.setText("" + policy_list.get(i).getCustomer().getAddress().getAddress1() + "," + policy_list.get(i).getCustomer().getAddress().getCity() + "," +
                    policy_list.get(i).getCustomer().getAddress().getState() + "," + policy_list.get(i).getCustomer().getAddress().getZip());
            viewHolderss.policy_email.setText("" + policy_list.get(i).getCustomer().getAddress().getEmail1());
            viewHolderss.policy_phone.setText("" + policy_list.get(i).getCustomer().getAddress().getPhone1() + "(" + policy_list.get(i).getCustomer().getAddress().getPhone2() + ")");

            viewHolderss.policy_govtid.setText("" + policy_list.get(i).getCustomer().getGovt_id_number());
            viewHolderss.policy_aadar.setText("" + policy_list.get(i).getCustomer().getAadhar_number());
            viewHolderss.policy_dob.setText("" + policy_list.get(i).getCustomer().getDate_of_birth());
            viewHolderss.company_id.setText("" + policy_list.get(i).getCompany().getId());
            viewHolderss.company_business_name.setText("" + policy_list.get(i).getCompany().getBusiness_name());
            viewHolderss.company_irdai_number.setText("" + policy_list.get(i).getCompany().getIrdai_number());
            viewHolderss.company_govt_id_number.setText("" + policy_list.get(i).getCompany().getGovt_id_number());
            viewHolderss.company_policy_name.setText("" + policy_list.get(i).getCompany().getPolicy_type().getName() + "(" +
                    policy_list.get(i).getCompany().getPolicy_type().getId() + " )");

            viewHolderss.company_policy_description.setText("" + policy_list.get(i).getCompany().getPolicy_type().getDescription());
            viewHolderss.policy_agent_id.setText("" + policy_list.get(i).getCustomer().getAgent().getId());
            viewHolderss.policy_agent_name.setText("" + policy_list.get(i).getCustomer().getAgent().getFirst_name() + "( " +
                    policy_list.get(i).getCustomer().getAgent().getLast_name());

            viewHolderss.policy_agent_business.setText("" + policy_list.get(i).getCustomer().getAgent().getBusiness_name());
            viewHolderss.policy_agent_aadar.setText("" + policy_list.get(i).getCustomer().getAgent().getAadhar_number());
            viewHolderss.policy_agent_govt.setText("" + policy_list.get(i).getCustomer().getAgent().getGovt_id_number());
            viewHolderss.policy_agent_update_counter.setText("" + policy_list.get(i).getCustomer().getAgent().getUpdate_counter());
            viewHolderss.policy_agent_address.setText("" + policy_list.get(i).getCustomer().getAgent().getAddress().getAddress1() + "," +
                    policy_list.get(i).getCustomer().getAgent().getAddress().getCity() + "," + policy_list.get(i).getCustomer().getAgent().getAddress().getState() + "," +
                    policy_list.get(i).getCustomer().getAgent().getAddress().getZip());
            viewHolderss.policy_agent_phone.setText("" + policy_list.get(i).getCustomer().getAgent().getAddress().getPhone1());
            viewHolderss.policy_agent_email.setText("" + policy_list.get(i).getCustomer().getAgent().getAddress().getEmail1());
        }

        @Override
        public int getItemCount() {
            return policy_list.size();
        }

        class ViewHolderss extends RecyclerView.ViewHolder
        {
            TextView id, policy_name, policy_business_name, policy_address, policy_email, policy_phone, policy_govtid, policy_aadar,
                    policy_dob, company_id, company_business_name, company_irdai_number, company_govt_id_number, company_policy_name,
                    company_policy_description, policy_agent_id, policy_agent_name, policy_agent_business, policy_agent_aadar,
                    policy_agent_govt, policy_agent_update_counter, policy_agent_address, policy_agent_phone, policy_agent_email;

            public ViewHolderss(@NonNull View itemView)
            {
                super(itemView);
                id=(TextView)itemView.findViewById(R.id.id);
                policy_name=(TextView)itemView.findViewById(R.id.policy_name);
                policy_name=(TextView)itemView.findViewById(R.id.policy_name);
                policy_business_name=(TextView)itemView.findViewById(R.id.policy_business_name);
                policy_address=(TextView)itemView.findViewById(R.id.policy_address);
                policy_email=(TextView)itemView.findViewById(R.id.policy_email);
                policy_phone=(TextView)itemView.findViewById(R.id.policy_phone);
                policy_govtid=(TextView)itemView.findViewById(R.id.policy_govtid);
                policy_aadar=(TextView)itemView.findViewById(R.id.policy_aadar);
                policy_dob=(TextView)itemView.findViewById(R.id.policy_dob);
                company_id=(TextView)itemView.findViewById(R.id.company_id);
                company_business_name=(TextView)itemView.findViewById(R.id.company_business_name);
                company_irdai_number=(TextView)itemView.findViewById(R.id.company_irdai_number);
                company_govt_id_number=(TextView)itemView.findViewById(R.id.company_govt_id_number);
                company_policy_name=(TextView)itemView.findViewById(R.id.company_policy_name);
                company_policy_description=(TextView)itemView.findViewById(R.id.company_policy_description);
                policy_agent_id=(TextView)itemView.findViewById(R.id.policy_agent_id);
                policy_agent_name=(TextView)itemView.findViewById(R.id.policy_agent_name);
                policy_agent_business=(TextView)itemView.findViewById(R.id.policy_agent_business);
                policy_agent_aadar=(TextView)itemView.findViewById(R.id.policy_agent_aadar);
                policy_agent_govt=(TextView)itemView.findViewById(R.id.policy_agent_govt);
                policy_agent_update_counter=(TextView)itemView.findViewById(R.id.policy_agent_update_counter);
                policy_agent_address=(TextView)itemView.findViewById(R.id.policy_agent_address);
                policy_agent_phone=(TextView)itemView.findViewById(R.id.policy_agent_phone);
                policy_agent_email=(TextView)itemView.findViewById(R.id.policy_agent_email);
            }
        }
    }
}
