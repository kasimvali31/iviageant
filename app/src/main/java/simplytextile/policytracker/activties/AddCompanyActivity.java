package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;

public class AddCompanyActivity extends AppCompatActivity
{

    EditText add_company_name,add_company_bid,add_company_license_number;
    Button addcommpany_btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);
        initParams();
    }
    public void initParams()
    {
        add_company_name=(EditText)findViewById(R.id.add_company_name);
        add_company_bid=(EditText)findViewById(R.id.add_company_bid);
        add_company_license_number=(EditText)findViewById(R.id.add_company_license_number);
        addcommpany_btn_save=(Button) findViewById(R.id.addcommpany_btn_save);
        addcommpany_btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                readData();
            }
        });
    }
    public void readData()
    {
        String cname=add_company_name.getText().toString().trim();
        String cbid=add_company_bid.getText().toString().trim();
        String cmpLicenseNUmber=add_company_license_number.getText().toString().trim();

        if (cname.isEmpty())
        {
            add_company_name.requestFocus();
            add_company_name.setError("enter company");
        }else if (cbid.isEmpty())
        {
            add_company_bid.requestFocus();
            add_company_bid.setError("enter id");
        }else if (cmpLicenseNUmber.isEmpty())
        {
            add_company_license_number.requestFocus();
            add_company_license_number.setError("enter licence");
        }
        else {

            JSONObject main = new JSONObject();
            JSONArray jr1 = new JSONArray();
            JSONObject jro = new JSONObject();
            try {
                jro.put("id", "" + cbid);
                jro.put("activation_date", "");
                jro.put("business_name", cname);
                jro.put("license_number", cmpLicenseNUmber);

                JSONObject jptype = new JSONObject();
                jptype.put("id", "");
                jptype.put("name", "");
                jptype.put("description", "");
                jptype.put("parent_id", "");
                jptype.put("is_renewable", "");
                jro.put("policy_type", jptype);
                jr1.put(jro);
                main.put("company_list", jr1);
                Utills.getVolleyResponseJson(AddCompanyActivity.this, Request.Method.POST, "http://dev.simplytextile.com:9081/api/subscribers/id/companies", main, new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                        JSONObject jb = null;
                        try {
                            jb = new JSONObject(result);
                            String msg = jb.getString("message");
                            Toast.makeText(AddCompanyActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
