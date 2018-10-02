package simplytextile.policytracker.activties;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import simplytextile.policytracker.MainActivity;
import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;

public class SignupActivity extends AppCompatActivity
{
    EditText input_firstname,input_lastname,input_email,input_phone,input_loginanme,input_password;
    String FirstName,LastName,Email,Phone,LoginName,Password;
    RadioGroup radioGroup;
    RadioButton rb_agent,rb_manager;
    Spinner companytype,selectcompany;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        initViews();





        ActionBar actionBar = getActionBar();
    }



    private void initViews()
    {
        input_firstname=(EditText)findViewById(R.id.firstname_signupactivity_input);
        input_lastname=(EditText)findViewById(R.id.lastname_signupactivity_input);
        input_email=(EditText)findViewById(R.id.email_signupactivity_input);
        input_phone=(EditText)findViewById(R.id.Phone_signupactivity_input);
        input_loginanme=(EditText)findViewById(R.id.loginname_signupactivity_input);
        input_password=(EditText)findViewById(R.id.password_signupactivity_input);
        register=(Button)findViewById(R.id.register_signup);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              intialization();
            }
        });






        selectcompany=(Spinner)findViewById(R.id.selectcompany_singupactivity);
        ArrayAdapter<CharSequence> selectcompanyadapter = ArrayAdapter.createFromResource(this, R.array.select_company, android.R.layout.simple_spinner_item);
        selectcompanyadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectcompany.setAdapter(selectcompanyadapter);

        companytype=(Spinner)findViewById(R.id.companytype_singupactivity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_company_type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        companytype.setAdapter(adapter);

        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        rb_agent=(RadioButton)findViewById(R.id.radioagent_Signupactivity);
        rb_manager=(RadioButton)findViewById(R.id.radioManager_signupactivity);
        rb_agent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selectcompany.setVisibility(View.INVISIBLE);
                companytype.setVisibility(View.INVISIBLE);


            }
        });
        rb_manager.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                selectcompany.setVisibility(View.VISIBLE);
                companytype.setVisibility(View.VISIBLE);


            }
        });
    }

    private void intialization()
    {

        FirstName=input_firstname.getText().toString().trim();
        LastName=input_lastname.getText().toString().trim();
        Email=input_email.getText().toString().trim();
        Phone=input_phone.getText().toString().trim();
        LoginName=input_loginanme.getText().toString().trim();
        Password=input_password.getText().toString().trim();
        if (FirstName.isEmpty())
        {
            input_firstname.requestFocus();
            input_firstname.setError("Enter FirstName");
        }

        else if(LastName.isEmpty())
        {
            input_lastname.requestFocus();
            input_lastname.setError("Enter LastName");
        }
        else if(Email.isEmpty())
        {
            input_email.requestFocus();
            input_email.setError("Enter email");
        }
        else if (Phone.isEmpty())
        {
            input_phone.requestFocus();
            input_phone.setError("Enter Phone");
        }
        else if(LoginName.isEmpty())
        {
            input_loginanme.requestFocus();
            input_loginanme.setError("Enter Login Name");
        }
        else if (Password.isEmpty())
        {
            input_password.requestFocus();
            input_password.setError("Enter Password");
        }

        else
        {
           signupRequest();
        }
    }




    private void signupRequest()
    {

        JSONObject jsonObject=new JSONObject();
        JSONObject jsonObjectSub=new JSONObject();
        try
        {
            jsonObjectSub.put("id",0);
            jsonObjectSub.put("type_id",6500);
            jsonObjectSub.put("business_name","");
            jsonObjectSub.put("first_name",FirstName);
            jsonObjectSub.put("last_name",LastName);
            jsonObjectSub.put("aadhar_number","");
            jsonObjectSub.put("govt_id_number","");
            jsonObjectSub.put("irdai_number","");

            JSONObject jsonObjectAdd=new JSONObject();
            jsonObjectAdd.put("address1","");
            jsonObjectAdd.put("address2","");
            jsonObjectAdd.put("address3","");
            jsonObjectAdd.put("city","");
            jsonObjectAdd.put("state","");
            jsonObjectAdd.put("zip","");
            jsonObjectAdd.put("email1",Email);
            jsonObjectAdd.put("phone1",Phone);
            jsonObjectAdd.put("email2","");
            jsonObjectAdd.put("phone2","");
            jsonObjectSub.put("address",jsonObjectAdd);
            JSONObject jsonObjectUser=new JSONObject();
            jsonObjectUser.put("login_name",LoginName);
            jsonObjectUser.put("password",Password);
            jsonObjectSub.put("user",jsonObjectUser);
            JSONArray comArray =new JSONArray();
            jsonObjectSub.put("company_list",comArray);
            jsonObject.put("subscriber",jsonObjectSub);

            Utills.getVolleyResponseJson(SignupActivity.this, Request.Method.POST, "http://dev.simplytextile.com:9081/api/subscribers", jsonObject, new VolleyCallback() {
                @Override
                public void onSuccessResponse(String result)
                {
                    try
                    {
                        JSONObject jb =new JSONObject(result);
                        String   msg=jb.getString("message");
                        Toast.makeText(SignupActivity.this, ""+msg, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                    Toast.makeText(SignupActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                           Intent mainactivity =new Intent(SignupActivity.this,LoginActivity.class);
                           startActivity(mainactivity);



                }
            });



        }
        catch (JSONException e)
        {
                   e.printStackTrace();
        }

    }
}
