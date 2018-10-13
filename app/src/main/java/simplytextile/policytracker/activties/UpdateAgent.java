package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;

public class UpdateAgent extends AppCompatActivity
{
    String bname,fname,lname,email,ph1,ph2,aadar,pan,add1,city,state,zip;
    EditText business_name_update_agents,first_name_update_agents,last_name_update_agents,
    aadhar_number_update_agents,govt_id_number_update_agents,address1_update_agents,city_update_agents,
            state_update_agents,zip_update_agents,email1_update_agents,phone1_update_agents,phone2_update_agents;
    Button update_agent_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_agent_activity);
        Bundle b=getIntent().getExtras();
        bname=b.getString("bname");
        fname=b.getString("fname");
        lname=b.getString("lname");
        email=b.getString("email");
        ph1=b.getString("ph1");
        ph2=b.getString("ph2");
        aadar=b.getString("aadar");
        pan=b.getString("pan");
        add1=b.getString("add1");
        city=b.getString("city");
        state=b.getString("state");
        zip=b.getString("zip");
        initParams();
    }
    public void initParams()
    {
        business_name_update_agents=(EditText)findViewById(R.id.business_name_update_agents);
        first_name_update_agents=(EditText)findViewById(R.id.first_name_update_agents);
        last_name_update_agents=(EditText)findViewById(R.id.last_name_update_agents);
        aadhar_number_update_agents=(EditText)findViewById(R.id.aadhar_number_update_agents);
        govt_id_number_update_agents=(EditText)findViewById(R.id.govt_id_number_update_agents);
        address1_update_agents=(EditText)findViewById(R.id.address1_update_agents);
        city_update_agents=(EditText)findViewById(R.id.city_update_agents);
        state_update_agents=(EditText)findViewById(R.id.state_update_agents);
        zip_update_agents=(EditText)findViewById(R.id.zip_update_agents);
        email1_update_agents=(EditText)findViewById(R.id.email1_update_agents);
        phone1_update_agents=(EditText)findViewById(R.id.phone1_update_agents);
        phone2_update_agents=(EditText)findViewById(R.id.phone2_update_agents);
        update_agent_btn=(Button) findViewById(R.id.update_agent_btn);
        update_agent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                performUpdations();
            }
        });
    }
    public void performUpdations()
    {
        String bname=business_name_update_agents.getText().toString().trim();
        String fname=first_name_update_agents.getText().toString().trim();
        String lname=last_name_update_agents.getText().toString().trim();
        String aadar=aadhar_number_update_agents.getText().toString().trim();
        String govt=govt_id_number_update_agents.getText().toString().trim();
        String add1=address1_update_agents.getText().toString().trim();
        String city=city_update_agents.getText().toString().trim();
        String state=state_update_agents.getText().toString().trim();
        String zip=zip_update_agents.getText().toString().trim();
        String email1=email1_update_agents.getText().toString().trim();
        String phone1=phone1_update_agents.getText().toString().trim();
        String phone2=phone2_update_agents.getText().toString().trim();

        if (bname.isEmpty())
        {
            business_name_update_agents.requestFocus();
        }else if (fname.isEmpty())
        {
            first_name_update_agents.requestFocus();
        }else if (lname.isEmpty())
        {
            last_name_update_agents.requestFocus();
        }else if (aadar.isEmpty())
        {
            aadhar_number_update_agents.requestFocus();
        }else if (govt.isEmpty())
        {
            govt_id_number_update_agents.requestFocus();
        }else if (add1.isEmpty())
        {
            address1_update_agents.requestFocus();
        }else if (city.isEmpty())
        {
            city_update_agents.requestFocus();
        }
        else if (state.isEmpty())
        {
            state_update_agents.requestFocus();
        }else if (zip.isEmpty())
        {
            zip_update_agents.requestFocus();
        }
        else if (email1.isEmpty())
        {
            email1_update_agents.requestFocus();
        }
        else if (phone1.isEmpty())
        {
            phone1_update_agents.requestFocus();
        }
        else
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
                sub2.put("address2","");
                sub2.put("address3","");
                sub2.put("city",city);
                sub2.put("state",state);
                sub2.put("zip",zip);
                sub2.put("email1",email1);
                sub2.put("phone1",phone1);
                sub2.put("email2","");
                sub2.put("phone2",phone2);
                sub1.put("address",sub2);
                jmain.put("agent",sub1);


                Utills.getVolleyResponseJson(UpdateAgent.this, Request.Method.POST, "http://dev.simplytextile.com:9081/api/agents", jmain, new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result)
                    {
                        JSONObject jb = null;
                        try
                        {
                            jb = new JSONObject(result);
                            String   msg=jb.getString("message");
                            Toast.makeText(UpdateAgent.this, ""+msg, Toast.LENGTH_SHORT).show();
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
