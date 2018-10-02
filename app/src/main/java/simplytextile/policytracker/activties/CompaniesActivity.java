package simplytextile.policytracker.activties;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.R;
import simplytextile.policytracker.adapters.CompanyAdapter;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.companyresponse.CompanyList;
import simplytextile.policytracker.companyresponse.Compres;
import simplytextile.policytracker.companyresponse.Data;

public class CompaniesActivity extends AppCompatActivity
{

    ImageView addcompany;


    public RecyclerView recyclerView;
    public ArrayList<CompanyList> company_list;

    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companies_activity);
        recyclerView = (RecyclerView)findViewById(R.id.rc_view);
        getCompany();

//
    }

    private void getCompany()
    {
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<Compres> call = service.getCompanies();
        call.enqueue(new Callback<Compres>()
        {
            @Override
            public void onResponse(Call<Compres> call, Response<Compres> response)
            {
                Compres compres=response.body();
                compres.getStatuscode();
                compres.getData().getCompany_list();
                compres.getMessage();
                Data data=compres.getData();
                data.getTotalrecords();
                company_list = new ArrayList<CompanyList>((compres.getData().getCompany_list()));
                CompanyAdapter companyAdapter = new CompanyAdapter(company_list,context);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                Toast.makeText(CompaniesActivity.this, "Success"+company_list, Toast.LENGTH_LONG).show();
                recyclerView.setAdapter(companyAdapter);



            }

            @Override
            public void onFailure(Call<Compres> call, Throwable t)
            {
                call.cancel();
            }
        });
    }


}
