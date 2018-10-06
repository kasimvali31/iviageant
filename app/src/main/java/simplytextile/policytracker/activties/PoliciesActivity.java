package simplytextile.policytracker.activties;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.R;
import simplytextile.policytracker.adapters.PoliciesListAdapter;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.response.PoliciesResponse;

public class PoliciesActivity extends AppCompatActivity {
    RecyclerView policies_recycler;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policies_activity);

        policies_recycler=(RecyclerView)findViewById(R.id.policies_recycler);
        llm=new LinearLayoutManager(this);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        String S_id = mPrefs.getString("key", "");

        ApiService planView = ApiClient.getClient().create(ApiService.class);
        Call<PoliciesResponse> policResponse= planView.getPolicies(S_id);
        policResponse.enqueue(new Callback<PoliciesResponse>()
        {
            @Override
            public void onResponse(Call<PoliciesResponse> call, Response<PoliciesResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    PoliciesListAdapter adapter=new PoliciesListAdapter(response.body().getData().getPolicy_list(),PoliciesActivity.this);
                    policies_recycler.setAdapter(adapter);
                    policies_recycler.setLayoutManager(llm);
                }
                else
                {
                    Toast.makeText(PoliciesActivity.this, "else case"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PoliciesResponse> call, Throwable t) {
                Toast.makeText(PoliciesActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
