package simplytextile.policytracker.activties;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;

import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;

public class AddAgentActivity extends AppCompatActivity
{
    EditText business_name_add_agents,first_name_add_agents,last_name_add_agents,aadhar_number_add_agents,
            govt_id_number_add_agents,address1_add_agents,address2_add_agents,address3_add_agents,city_add_agents,
            state_add_agents,zip_add_agents,email1_add_agents,email2_add_agents,phone1_add_agents,phone2_add_agents;
    Button add_agent_btn;
public  static String S_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_agent_activity);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        S_id= mPrefs.getString("key", "");
        initParams();
    }
    public void initParams()
    {
        business_name_add_agents=(EditText)findViewById(R.id.business_name_add_agents);
        first_name_add_agents=(EditText)findViewById(R.id.first_name_add_agents);
        last_name_add_agents=(EditText)findViewById(R.id.last_name_add_agents);
        aadhar_number_add_agents=(EditText)findViewById(R.id.aadhar_number_add_agents);
        govt_id_number_add_agents=(EditText)findViewById(R.id.govt_id_number_add_agents);
        address1_add_agents=(EditText)findViewById(R.id.address1_add_agents);
        address2_add_agents=(EditText)findViewById(R.id.address2_add_agents);
        address3_add_agents=(EditText)findViewById(R.id.address3_add_agents);
        city_add_agents=(EditText)findViewById(R.id.city_add_agents);
        state_add_agents=(EditText)findViewById(R.id.state_add_agents);
        zip_add_agents=(EditText)findViewById(R.id.zip_add_agents);
        email1_add_agents=(EditText)findViewById(R.id.email1_add_agents);
        email2_add_agents=(EditText)findViewById(R.id.email2_add_agents);
        phone1_add_agents=(EditText)findViewById(R.id.phone1_add_agents);
        phone2_add_agents=(EditText)findViewById(R.id.phone2_add_agents);
        add_agent_btn=(Button) findViewById(R.id.add_agent_btn);
        add_agent_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                performOperations();
            }
        });
    }
    public void performOperations()
    {
        String bname=business_name_add_agents.getText().toString().trim();
        String fname=first_name_add_agents.getText().toString().trim();
        String lname=last_name_add_agents.getText().toString().trim();
        String aadar=aadhar_number_add_agents.getText().toString().trim();
        String govt=govt_id_number_add_agents.getText().toString().trim();
        String add1=address1_add_agents.getText().toString().trim();
        String add2=address2_add_agents.getText().toString().trim();
        String add3=address3_add_agents.getText().toString().trim();
        String city=city_add_agents.getText().toString().trim();
        String state=state_add_agents.getText().toString().trim();
        String zip=zip_add_agents.getText().toString().trim();
        String email1=email1_add_agents.getText().toString().trim();
        String email2=email2_add_agents.getText().toString().trim();
        String phone1=phone1_add_agents.getText().toString().trim();
        String phone2=phone2_add_agents.getText().toString().trim();

        if (bname.isEmpty())
        {
            business_name_add_agents.requestFocus();
            business_name_add_agents.setError("enter business name");
        }else if (fname.isEmpty())
        {
            first_name_add_agents.requestFocus();
            first_name_add_agents.setError("enter first name");
        }else if (lname.isEmpty())
        {
            last_name_add_agents.requestFocus();
            last_name_add_agents.setError("enter last name");
        }else if (add1.isEmpty())
        {
            address1_add_agents.requestFocus();
            address1_add_agents.setError("enter address");
        }else if (city.isEmpty())
        {
            city_add_agents.requestFocus();
            city_add_agents.setError("enter city");
        }else if (state.isEmpty())
        {
            state_add_agents.requestFocus();
            state_add_agents.setError("enter stste");
        }else if (zip.isEmpty())
        {
            zip_add_agents.requestFocus();
            zip_add_agents.setError("enter postal code");
        }else if (email1.isEmpty())
        {
            email1_add_agents.requestFocus();
            email1_add_agents.setError("enter email address");
        }else if (phone1.isEmpty())
        {
            phone1_add_agents.requestFocus();
            phone1_add_agents.setError("enter mobile number");
        }else
        {
            JSONObject jmain=new JSONObject();
            JSONObject sub1=new JSONObject();
            try
            {
                sub1.put("id",0);
                sub1.put("business_name",bname);
                sub1.put("first_name",fname);
                sub1.put("last_name",lname);
                sub1.put("aadhar_number",aadar);
                sub1.put("govt_id_number",govt);

                JSONObject sub2=new JSONObject();
                sub2.put("address1",add1);
                sub2.put("address2",add2);
                sub2.put("address3",add3);
                sub2.put("city",city);
                sub2.put("state",state);
                sub2.put("zip",zip);
                sub2.put("email1",email1);
                sub2.put("phone1",phone1);
                sub2.put("email2",email2);
                sub2.put("phone2",phone2);
                sub1.put("address",sub2);
                jmain.put("agent",sub1);


                Utills.getVolleyResponseJson(AddAgentActivity.this, Request.Method.POST, "http://dev.simplytextile.com:9081/api/agents", jmain, new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result)
                    {
                        JSONObject jb = null;
                        try
                        {
                            jb = new JSONObject(result);
                            String   msg=jb.getString("message");
                            Toast.makeText(AddAgentActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                });

            }catch (Exception e)
            {

            }
        }

    }
}
