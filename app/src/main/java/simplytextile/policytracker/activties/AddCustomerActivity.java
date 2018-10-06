package simplytextile.policytracker.activties;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;

public class AddCustomerActivity extends AppCompatActivity
{
    public  static String S_id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
         S_id = mPrefs.getString("key", "");
        try
        {

            JSONObject jmain=new JSONObject();
            JSONObject jsub1=new JSONObject();
            jsub1.put("id",0);
            jsub1.put("business_name","bname");
            jsub1.put("first_name","fname");
            jsub1.put("last_name","lname");
            jsub1.put("aadhar_number","");
            jsub1.put("govt_id_number","");
            jsub1.put("date_of_birth","2018-01-18T08:00:00.000Z");

            JSONObject jsub2=new JSONObject();
            jsub2.put("address1","hyderabad");
            jsub2.put("address2","");
            jsub2.put("address3","");
            jsub2.put("city","PLEASANTON");
            jsub2.put("state","Bihar");
            jsub2.put("zip","94588");
            jsub2.put("email1","rupesh.d.shah@gmail.com");
            jsub2.put("phone1","5106766249");
            jsub2.put("email2","");
            jsub2.put("phone2","");
            jsub1.put("address",jsub2);

            JSONObject jsubAgent=new JSONObject();
            jsubAgent.put("id",10059);
            jsubAgent.put("business_name","bname");
            jsubAgent.put("business_name","");
            jsubAgent.put("first_name","");
            jsubAgent.put("last_name","");
            jsubAgent.put("aadhar_number","");
            jsubAgent.put("govt_id_number","");

            JSONObject jsub3=new JSONObject();
            jsub3.put("address1","");
            jsub3.put("address2","");
            jsub3.put("address3","");
            jsub3.put("city","");
            jsub3.put("state","");
            jsub3.put("zip","");
            jsub3.put("email1","");
            jsub3.put("phone1","");
            jsub3.put("email2","");
            jsub3.put("phone2","");
            jsubAgent.put("address",jsub3);
            jsub1.put("agent",jsubAgent);
            jmain.put("customer",jsub1);

            Utills.getVolleyResponseJson(AddCustomerActivity.this, Request.Method.POST, "http://dev.simplytextile.com:9081/api/customers", jmain, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result)
                {
                    JSONObject jb = null;
                    try
                    {
                        jb = new JSONObject(result);
                        String   msg=jb.getString("message");
                        Toast.makeText(AddCustomerActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                    }
                    catch (JSONException e)
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
