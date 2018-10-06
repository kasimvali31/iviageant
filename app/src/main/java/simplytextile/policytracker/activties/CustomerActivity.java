package simplytextile.policytracker.activties;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
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
import simplytextile.policytracker.adapters.CustomerListAdapter;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.response.CustomerResponse;

public class CustomerActivity extends AppCompatActivity
{
    public static final String ss="name";
    RecyclerView customer_recycler;
    ImageView imageView;
    LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);

        customer_recycler=(RecyclerView)findViewById(R.id.customer_recycler);
        imageView=(ImageView)findViewById(R.id.image_addbutton);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addcustomer=new Intent(CustomerActivity.this,AddCustomerActivity.class);
                startActivity(addcustomer);
            }
        });

        llm=new LinearLayoutManager(this);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        String S_id = mPrefs.getString("key", "");
        ApiService planView = ApiClient.getClient().create(ApiService.class);
        Call<CustomerResponse> customers=planView.getCustomers(S_id);
        customers.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response)
            {
                if (response.body().getStatuscode()==0)
                {
                    CustomerListAdapter adapter=new CustomerListAdapter(response.body().getData().getCustomer_list(),CustomerActivity.this);;
                    customer_recycler.setAdapter(adapter);
                    customer_recycler.setLayoutManager(llm);
                }
                else
                {
                    Toast.makeText(CustomerActivity.this, "from else"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t)
            {
                Toast.makeText(CustomerActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(this,AddCustomerActivity.class));
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
