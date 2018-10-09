package simplytextile.policytracker.activties;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.MainActivity;
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
    String a1[];
    ArrayList ll=new ArrayList();
    int count=0;
    Set list= new HashSet();

    public RecyclerView recyclerView;
    public ArrayList<CompanyList> company_list;

    Context context;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companies_activity);
        recyclerView = (RecyclerView)findViewById(R.id.rc_view);
        spinner=(Spinner)findViewById(R.id.spinner);
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
                data.getPolicy_list();



                company_list = new ArrayList<CompanyList>((compres.getData().getCompany_list()));

//                String[] spinnerArray = new String[company_list.size()];
//                HashMap<Integer,String> spinnerMap = new HashMap<Integer, String>();
//                for (int i = 0; i < company_list.size(); i++)
//                {
//                    spinnerMap.put(i, String.valueOf(company_list.get(i).getPolicy_type().getId()));
//                    spinnerArray[i] = company_list.get(i).getPolicy_type().getName();
//                   //Arrays.sort(new String[]{spinnerArray[i]});
//
//                   String[]cs=new String[]{spinnerArray[i]};
//                   Arrays.sort(cs);
//                   int n=removeDuplicates(cs);
//                    for(int j = 0; j<n; j++)
//                    {
//                        System.out.println(cs[j]);
//                        //Toast.makeText(CompaniesActivity.this, ""+cs[j], Toast.LENGTH_SHORT).show();
//                        Set<String> unique = new HashSet<String>(Collections.singleton(cs[j]));
//
//                        for (String word : unique)
//                            Toast.makeText(CompaniesActivity.this, ""+word, Toast.LENGTH_SHORT).show();
//
//
//                    }
//
//                }




//                CompanyAdapter companyAdapter = new CompanyAdapter(response.body().getData().getCompany_list(),context);
//                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setHasFixedSize(true);
//                recyclerView.setAdapter(companyAdapter);

                int k=company_list.size();

                a1=new String[k];

                for(int i=0;i<k;i++)
                {
                    if (company_list.get(i).getPolicy_type().getName().toString().equals("Health"))
                    {
//
                        ll.add(company_list.get(i).getBusiness_name());

                    }

                }
                ArrayAdapter aa=new ArrayAdapter(CompaniesActivity.this,android.R.layout.simple_spinner_item,ll);
                spinner.setAdapter(aa);

            }

            @Override
            public void onFailure(Call<Compres> call, Throwable t)
            {
                call.cancel();
            }
        });
    }

    public static int removeDuplicates(String[] A)
    {
        int length=A.length;
        if(length==0 || length==1) return length;
        int i=1;
        for(int j=1; j<length; j++){
            if(!A[j].equals(A[j-1])){
                A[i]=A[j];
                i++;
            }
        }
        if(i<length) A[i]=null;
        return i;
    }

}



