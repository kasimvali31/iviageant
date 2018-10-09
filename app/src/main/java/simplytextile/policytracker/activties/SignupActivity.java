package simplytextile.policytracker.activties;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.MainActivity;
import simplytextile.policytracker.R;
import simplytextile.policytracker.Utills;
import simplytextile.policytracker.VolleyCallback;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.companyresponse.Compres;

public class SignupActivity extends AppCompatActivity
{
    EditText input_firstname,input_lastname,input_email,input_phone,input_loginanme,input_password;
    String FirstName,LastName,Email,Phone,LoginName,Password;
    RadioGroup radioGroup;
    RadioButton rb_agent,rb_manager;
    Spinner companytype,selectcompany;
    Button register;
    String a1[];
    String selecteddtext;
    String cname;
    int k;
    ArrayList ll=new ArrayList();
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
        selectcompany=(Spinner)findViewById(R.id.selectcompany_singupactivity);
        companytype=(Spinner)findViewById(R.id.companytype_singupactivity);
        register=(Button)findViewById(R.id.register_signup);
        register.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {

                if(selecteddtext.equals("Manager"))
                {
                //code if condition is true
                    managerintilization();
                }
                else
               {
//code if condition is false
                   agentintialization();

                }



//              radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//              {
//                  @Override
//                  public void onCheckedChanged(RadioGroup group, int checkedId)
//                  {
//                      switch(checkedId)
//                      {
//                          case R.id.radioagent_Signupactivity:
//                              agentintialization();
//                              // do operations specific to this selection
//                              break;
//                          case R.id.radioManager_signupactivity:
//                              // do operations specific to this selection
//                              managerintilization();
//                              break;
//
//                      }
//                  }
//              });

            }
        });




        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<Compres> call = service.getCompanies();
        call.enqueue(new Callback<Compres>()
        {
            @Override
            public void onResponse(Call<Compres> call, final Response<Compres> response)
            {
                 k=response.body().getData().getCompany_list().size();
                a1=new String[k];
                for(int i=0;i<k;i++)
                {

                    a1[i]=response.body().getData().getCompany_list().get(i).getPolicy_type().getName();
//                    if (response.body().getData().getCompany_list().get(i).getPolicy_type().getName().toString().equals("Health"))
//                    {
//                        ll.add(company_list.get(i).getBusiness_name());
//
//                    }

                }
                ArrayAdapter aa=new ArrayAdapter(SignupActivity.this,android.R.layout.simple_spinner_dropdown_item,a1);
                companytype.setAdapter(aa);
                companytype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                         cname=parent.getItemAtPosition(position).toString().trim();
                        if (cname.equals("General"))
                        {

                            for (int j=0;j<k;j++)
                            {
                                if (response.body().getData().getCompany_list().get(j).getPolicy_type().getName().equals("General"))
                                {
                                    ll.add(response.body().getData().getCompany_list().get(j).getBusiness_name());
                                }
                            }
                        }
                        else if (cname.equals("Health"))
                        {
                            for (int j=0;j<k;j++)
                            {
                                if (response.body().getData().getCompany_list().get(j).getPolicy_type().getName().equals("Health"))
                                {
                                    ll.add(response.body().getData().getCompany_list().get(j).getBusiness_name());
                                }
                            }
                        }
                        else if (cname.equals("Life Insurance"))
                        {
                            for (int j=0;j<k;j++)
                            {
                                if (response.body().getData().getCompany_list().get(j).getPolicy_type().getName().equals("Life Insurance"))
                                {
                                    ll.add(response.body().getData().getCompany_list().get(j).getBusiness_name());
                                }
                            }
                        }
                ArrayAdapter as=new ArrayAdapter(SignupActivity.this,android.R.layout.simple_spinner_dropdown_item,ll);
                selectcompany.setAdapter(as);

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {

                    }
                });
            }
            @Override
            public void onFailure(Call<Compres> call, Throwable t)
            {
                Toast.makeText(SignupActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        rb_agent=(RadioButton)findViewById(R.id.radioagent_Signupactivity);
        rb_manager=(RadioButton)findViewById(R.id.radioManager_signupactivity);
        rb_agent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

               selecteddtext=rb_agent.getText().toString();
                selectcompany.setVisibility(View.INVISIBLE);
                companytype.setVisibility(View.INVISIBLE);


            }
        });
        rb_manager.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                 selecteddtext=rb_manager.getText().toString();
                selectcompany.setVisibility(View.VISIBLE);
                companytype.setVisibility(View.VISIBLE);

            }
        });
    }


    private void managerintilization()
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
            managersignupRequest();
        }
    }

    private void agentintialization()
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
           agentsignupRequest();
        }
    }




    private void agentsignupRequest()
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

                    }

                    catch (JSONException e)
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

    private void managersignupRequest()
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
            comArray.put(Integer.parseInt("id"),10056);
//            comArray.put("id");
//            comArray.put("id");
//            comArray.put("id");
            JSONObject jptype=new JSONObject();
            jptype.put("id",5302);
            jptype.put("name","");
            jptype.put("description","");
            jptype.put("parent_id","");
            jptype.put("is_renewable","");
            comArray.put(jptype);
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
