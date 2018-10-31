package simplytextile.policytracker.activties;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;

public class AddCustomerActivity extends AppCompatActivity
{
public static String S_id;
    EditText business_name_add_customer,first_name_add_customer,last_name_add_customer,dob_add_customer,
            email_name_add_customer,phone2_name_add_customer,phone1_name_add_customer,aadar_name_add_customer,pan_number_name_add_customer,
            address1_name_add_customer,state_name_add_customer,city_name_add_customer,postal_name_add_customer;
    Button add_customer_btn;
    ImageView select_date;
    Calendar cal;
    String d1;
    int y,m,d;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
         S_id = mPrefs.getString("key", "");
        initParams();

    }
    public void initParams()
    {
        cal=Calendar.getInstance();
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.DAY_OF_MONTH);
        d=cal.get(Calendar.DAY_OF_WEEK);


        business_name_add_customer=(EditText)findViewById(R.id.business_name_add_customer);
        first_name_add_customer=(EditText)findViewById(R.id.first_name_add_customer);
        last_name_add_customer=(EditText)findViewById(R.id.last_name_add_customer);
        dob_add_customer=(EditText)findViewById(R.id.dob_add_customer);
        email_name_add_customer=(EditText)findViewById(R.id.email_name_add_customer);
        phone1_name_add_customer=(EditText)findViewById(R.id.phone1_name_add_customer);
        phone2_name_add_customer=(EditText)findViewById(R.id.phone2_name_add_customer);
        aadar_name_add_customer=(EditText)findViewById(R.id.aadar_name_add_customer);
        pan_number_name_add_customer=(EditText)findViewById(R.id.pan_number_name_add_customer);
        address1_name_add_customer=(EditText)findViewById(R.id.address1_name_add_customer);
        state_name_add_customer=(EditText)findViewById(R.id.state_name_add_customer);
        city_name_add_customer=(EditText)findViewById(R.id.city_name_add_customer);
        postal_name_add_customer=(EditText)findViewById(R.id.postal_name_add_customer);
        select_date=(ImageView)findViewById(R.id.select_date);

        select_date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog dp=new DatePickerDialog(AddCustomerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                    {
                         d1=""+dayOfMonth+"-"+month+"-"+year;
                        dob_add_customer.setText(""+d1);
                    }
                },y,m,d);
                dp.show();
            }
        });
        add_customer_btn=(Button)findViewById(R.id.add_customer_btn);
        add_customer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                performData();
            }
        });
    }
    public void performData()
    {
        String bnames=business_name_add_customer.getText().toString().trim();
        String fname=first_name_add_customer.getText().toString().trim();
        String lname=last_name_add_customer.getText().toString().trim();
        String bob=dob_add_customer.getText().toString().trim();
        String email=email_name_add_customer.getText().toString().trim();
        String phone1=phone1_name_add_customer.getText().toString().trim();
        String phone2=phone2_name_add_customer.getText().toString().trim();
        String aadar=aadar_name_add_customer.getText().toString().trim();
        String pan=pan_number_name_add_customer.getText().toString().trim();
        String add1=address1_name_add_customer.getText().toString().trim();
        String state=state_name_add_customer.getText().toString().trim();
        String city=city_name_add_customer.getText().toString().trim();
        String postal=postal_name_add_customer.getText().toString().trim();



        if (fname.isEmpty())
        {
            first_name_add_customer.setError("enter name");
        }else if (lname.isEmpty())
        {
            last_name_add_customer.requestFocus();
            last_name_add_customer.setError("enter last name");
        }else if (bob.isEmpty())
        {
            dob_add_customer.setError("enter birth");
        }else if (email.isEmpty())
        {
            email_name_add_customer.setError("enter email id");
        }else if (phone1.isEmpty())
        {
            phone1_name_add_customer.setError("enter mobile");
        }else if (aadar.isEmpty())
        {
            aadar_name_add_customer.setError("enter aadar number");
        }else if (pan.isEmpty())
        {
            pan_number_name_add_customer.setError("enter pan");
        }else if (add1.isEmpty())
        {
            address1_name_add_customer.setError("enter address");
        }else if (state.isEmpty())
        {
            state_name_add_customer.setError("enter state");
        }else if (city.isEmpty())
        {
            city_name_add_customer.setError("enter city");
        }else if (postal.isEmpty())
        {
            postal_name_add_customer.setError("enter postal code");
        }
        else {


            try {

                JSONObject jmain = new JSONObject();
                JSONObject jsub1 = new JSONObject();
                jsub1.put("id", 0);
                jsub1.put("business_name", bnames);
                jsub1.put("first_name", fname);
                jsub1.put("last_name", lname);
                jsub1.put("aadhar_number", aadar);
                jsub1.put("govt_id_number", pan);
                jsub1.put("date_of_birth", bob);

                JSONObject jsub2 = new JSONObject();
                jsub2.put("address1", add1);
                jsub2.put("address2", "");
                jsub2.put("address3", "");
                jsub2.put("city", city);
                jsub2.put("state", state);
                jsub2.put("zip", postal);
                jsub2.put("email1", email);
                jsub2.put("phone1", phone1);
                jsub2.put("email2", "");
                jsub2.put("phone2", phone2);
                jsub1.put("address", jsub2);

                JSONObject jsubAgent = new JSONObject();
                jsubAgent.put("id", 10059);
                jsubAgent.put("business_name", "bname");
                jsubAgent.put("business_name", "");
                jsubAgent.put("first_name", "");
                jsubAgent.put("last_name", "");
                jsubAgent.put("aadhar_number", "");
                jsubAgent.put("govt_id_number", "");

                JSONObject jsub3 = new JSONObject();
                jsub3.put("address1", "");
                jsub3.put("address2", "");
                jsub3.put("address3", "");
                jsub3.put("city", "");
                jsub3.put("state", "");
                jsub3.put("zip", "");
                jsub3.put("email1", "");
                jsub3.put("phone1", "");
                jsub3.put("email2", "");
                jsub3.put("phone2", "");
                jsubAgent.put("address", jsub3);
                jsub1.put("agent", jsubAgent);
                jmain.put("customer", jsub1);

                Utills.getVolleyResponseJson(AddCustomerActivity.this, Request.Method.POST, "http://dev.simplytextile.com:9081/api/customers", jmain, new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        JSONObject jb = null;
                        try {
                            jb = new JSONObject(result);
                            String msg = jb.getString("message");

                            Snackbar ss = Snackbar.make((findViewById(android.R.id.content)), "" + msg, Snackbar.LENGTH_SHORT);
                            ss.show();
                            Toast.makeText(AddCustomerActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            } catch (Exception e)
            {

            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
               onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
