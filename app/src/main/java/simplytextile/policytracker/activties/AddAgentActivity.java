package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_agent_activity);
        initParams();
    }
    public void initParams()
    {
        JSONObject jmain=new JSONObject();
        JSONObject sub1=new JSONObject();
        try
        {
            sub1.put("id",0);
            sub1.put("business_name","business_names");
            sub1.put("first_name","ff");
            sub1.put("last_name","ll");
            sub1.put("aadhar_number","");
            sub1.put("govt_id_number","");

            JSONObject sub2=new JSONObject();
            sub2.put("address1","hyd");
            sub2.put("address2","add2");
            sub2.put("address3","");
            sub2.put("city","hyderabad");
            sub2.put("state","telangana");
            sub2.put("zip","94588");
            sub2.put("email1","rupesh.d.shah@gmail.com");
            sub2.put("phone1","5106766249");
            sub2.put("email2","");
            sub2.put("phone2","");
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
