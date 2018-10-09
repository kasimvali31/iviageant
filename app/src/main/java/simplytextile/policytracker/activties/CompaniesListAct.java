package simplytextile.policytracker.activties;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.R;
import simplytextile.policytracker.adapters.CompaniesListAdapters;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.companyresponse.Compres;

public class CompaniesListAct extends AppCompatActivity
{
    RecyclerView get_companies_recycler;
    FloatingActionButton adding_employee_fab_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_list);
        initParams();
    }
    public void initParams()
    {
        get_companies_recycler=(RecyclerView)findViewById(R.id.get_companies_recycler);
        adding_employee_fab_btn=(FloatingActionButton) findViewById(R.id.adding_employee_fab_btn);
        adding_employee_fab_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(CompaniesListAct.this,CompaniesActivity.class));
            }
        });
        ApiService ps = ApiClient.getClient().create(ApiService.class);
        Call<Compres> clist= ps.getCompanies();
        clist.enqueue(new Callback<Compres>()
        {
            @Override
            public void onResponse(Call<Compres> call, Response<Compres> response)
            {

                if (response.body().getStatuscode()==0)
                {
                    CompaniesListAdapters ada=new CompaniesListAdapters(response.body().getData().getCompany_list(),CompaniesListAct.this);
                    get_companies_recycler.setAdapter(ada);
                }
                else
                {
                    Toast.makeText(CompaniesListAct.this, ""+response.body().getStatuscode(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Compres> call, Throwable t)
            {
                Toast.makeText(CompaniesListAct.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
