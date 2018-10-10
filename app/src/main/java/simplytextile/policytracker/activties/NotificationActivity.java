package simplytextile.policytracker.activties;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.NotificationResponse.Notresponse;
import simplytextile.policytracker.R;
import simplytextile.policytracker.adapters.NotificationAdapter;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.response.PoliciesResponse;

public class NotificationActivity extends AppCompatActivity
{
    RecyclerView notification_recycler;
    LinearLayoutManager llm;
    LinearLayout data_loading_screen_layout;
    String S_id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
        notification_recycler=(RecyclerView)findViewById(R.id.notificationrecylers);
        data_loading_screen_layout=(LinearLayout) findViewById(R.id.data_loading_screen_layout);

        llm=new LinearLayoutManager(this);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
         S_id = mPrefs.getString("key", "");
        data_loading_screen_layout.setVisibility(View.VISIBLE);
        ApiService planView = ApiClient.getClient().create(ApiService.class);
        Call<Notresponse> policResponse= planView.getNotification(S_id);
        policResponse.enqueue(new Callback<Notresponse>()
        {
            @Override
            public void onResponse(Call<Notresponse> call, Response<Notresponse> response)
            {
                data_loading_screen_layout.setVisibility(View.GONE);
                if (response.body().getStatuscode()==0)
                {
                    NotificationAdapter adapter=new NotificationAdapter(response.body().getData().getNotification_list(),NotificationActivity.this);
                    notification_recycler.setAdapter(adapter);
                    notification_recycler.setLayoutManager(llm);
                }
                else
                {
                    Toast.makeText(NotificationActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Notresponse> call, Throwable t)
            {
                data_loading_screen_layout.setVisibility(View.GONE);
                Toast.makeText(NotificationActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
