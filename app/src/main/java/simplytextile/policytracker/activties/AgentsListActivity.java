package simplytextile.policytracker.activties;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.R;
import simplytextile.policytracker.adapters.AgentsListAdapter;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.response.AgentsResponse;



public class AgentsListActivity extends AppCompatActivity
{
    SharedPreferences sharedpreferences;
    RecyclerView agents_list_recycler;
    ImageView imageView;

    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_list);

        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        String S_id = mPrefs.getString("key", "");
        agents_list_recycler=(RecyclerView)findViewById(R.id.agents_list_recycler);
        imageView=(ImageView)findViewById(R.id.image_addbutton);
        llm=new LinearLayoutManager(this);





        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addagent=new Intent(AgentsListActivity.this,AddAgentActivity.class);
                startActivity(addagent);
            }
        });
        ApiService ps = ApiClient.getClient().create(ApiService.class);
        Call<AgentsResponse> agents=ps.getAgents(S_id);
        agents.enqueue(new Callback<AgentsResponse>()
        {
            @Override
            public void onResponse(Call<AgentsResponse> call, Response<AgentsResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    AgentsListAdapter adapter=new AgentsListAdapter(response.body().getData().getAgentList(),AgentsListActivity.this);
                    agents_list_recycler.setAdapter(adapter);
                    agents_list_recycler.setLayoutManager(llm);
                }
                else
                {
                    Toast.makeText(AgentsListActivity.this, "from else"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<AgentsResponse> call, Throwable t)
            {
                Toast.makeText(AgentsListActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
               onBackPressed();
                return true;
            case R.id.add_agents:
            {
                startActivity(new Intent(this,AddAgentActivity.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
