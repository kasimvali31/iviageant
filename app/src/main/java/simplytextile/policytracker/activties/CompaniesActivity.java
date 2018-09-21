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

//        ApiService service = ApiClient.getClient().create(ApiService.class);
//        Call<Compres> call = service.getCompanies();
//        call.enqueue(new Callback<Compres>()
//        {
//            @Override
//            public void onResponse(Call<Compres> call, Response<Compres> response)
//            {
//    //            Toast.makeText(CompaniesActivity.this, "Success"+response.body().getData().getCompany_list(), Toast.LENGTH_LONG).show();
//                Compres compres=response.body();
//
//                compres.getStatuscode();
//                compres.getData().getCompany_list();
//                Toast.makeText(CompaniesActivity.this, "Success"+response.body().getStatuscode(), Toast.LENGTH_LONG).show();
//
//                compres.getMessage();
//                Toast.makeText(CompaniesActivity.this, "Success"+response.body().getMessage(), Toast.LENGTH_LONG).show();
//                Data data=compres.getData();
//                data.getTotalrecords();
//
//
//                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setHasFixedSize(true);
//                company_list = new ArrayList<CompanyList>((data.getCompany_list()));
//                companyAdapter = new CompanyAdapter(company_list);
//                Toast.makeText(CompaniesActivity.this, "Success"+company_list, Toast.LENGTH_LONG).show();
//                Toast.makeText(CompaniesActivity.this, "Success"+companyAdapter, Toast.LENGTH_LONG).show();
//
//
//                recyclerView.setAdapter(companyAdapter);
//
//
//
//
//
//
//
//
//
//
//
//
//              //  data.getCompany_list();
//
//
//               // Toast.makeText(CompaniesActivity.this, "Success"+data.getCompany_list(), Toast.LENGTH_LONG).show();
//                Toast.makeText(CompaniesActivity.this, "Success"+data.getTotalrecords(), Toast.LENGTH_LONG).show();
//             //   Toast.makeText(CompaniesActivity.this, "Success"+companyList, Toast.LENGTH_LONG).show();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Compres> call, Throwable t)
//            {
//                call.cancel();
//            }
//        });



//
//    private void initViews()
//    {
//
//        addcompany=(ImageView)findViewById(R.id.btn_addCompany);
//        addcompany.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Intent addcomp=new Intent(CompaniesActivity.this,AddCompanyActivity.class);
//                startActivity(addcomp);
//
//            }
//        });
//
//
//
//
//
//    }
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
                Toast.makeText(CompaniesActivity.this, "Success"+response.body().getStatuscode(), Toast.LENGTH_LONG).show();
                compres.getMessage();
                Toast.makeText(CompaniesActivity.this, "Success"+response.body().getMessage(), Toast.LENGTH_LONG).show();
                Data data=compres.getData();
                data.getTotalrecords();
                company_list = new ArrayList<CompanyList>((compres.getData().getCompany_list()));
                CompanyAdapter companyAdapter = new CompanyAdapter(company_list,context);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                Toast.makeText(CompaniesActivity.this, "Success"+company_list, Toast.LENGTH_LONG).show();
                Toast.makeText(CompaniesActivity.this, "Success"+companyAdapter, Toast.LENGTH_LONG).show();
                recyclerView.setAdapter(companyAdapter);
                // Toast.makeText(CompaniesActivity.this, "Success"+data.getCompany_list(), Toast.LENGTH_LONG).show();
                Toast.makeText(CompaniesActivity.this, "Success"+data.getTotalrecords(), Toast.LENGTH_LONG).show();
                //   Toast.makeText(CompaniesActivity.this, "Success"+companyList, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<Compres> call, Throwable t)
            {
                call.cancel();
            }
        });
    }


}
