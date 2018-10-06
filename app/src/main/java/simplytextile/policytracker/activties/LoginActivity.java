package simplytextile.policytracker.activties;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simplytextile.policytracker.MainActivity;
import simplytextile.policytracker.R;
import simplytextile.policytracker.apis.ApiClient;
import simplytextile.policytracker.apis.ApiService;
import simplytextile.policytracker.responses.loginresponses.LoginResponse;

public class LoginActivity extends AppCompatActivity
{

    TextView signupText;


    SharedPreferences mPrefs;
    String Sid;
    EditText username,upassword;
    Button loginbutton;
    ProgressDialog pDialog;
    String Password,Username;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initViews();
        ActionBar actionBar = getActionBar();


    }

    private void initViews()
    {
        username=(EditText)findViewById(R.id.loginactivity_input_username);
        upassword=(EditText)findViewById(R.id.loginactivity_input_password);
        loginbutton=(Button)findViewById(R.id.loginactivitybutton);



        loginbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intialization();

            }
        });

        signupText=(TextView)findViewById(R.id.text_signup_mainactiivty);
        signupText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent mainactivity=new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(mainactivity);

            }
        });

    }

    public void Save(View view)
    {

//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.putString(Seesionid, Sid);
//        editor.commit();
    }

    private void intialization()
    {
        Password=upassword.getText().toString().trim();
         Username=username.getText().toString().trim();
        if (Username.isEmpty())
        {
            username.requestFocus();
            username.setError("Enter UserName");
        }

        else if(Password.isEmpty())
        {
            upassword.requestFocus();
            upassword.setError("Enter Password");

        }
        else
        {
                userLogin();

        }


    }

    private void userLogin()
    {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Signing In...!");
        pDialog.setCancelable(false);
        pDialog.show();

        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<LoginResponse> userCall = service.Logindetails(Username,Password);
        userCall.enqueue(new Callback<LoginResponse>()
        {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
            {
              if(response.body().getStatuscode()==0)
                  {

                      username.setText(" ");
                      upassword.setText(" ");
                      Toast.makeText(LoginActivity.this, "" + response.body().getMessage(), Toast.LENGTH_LONG).show();
                      String FirstName=response.body().getData().getSession().getSubscriber().getFirst_name();
                      Sid=response.body().getData().getSession().getId();
                      mPrefs = getSharedPreferences("IDvalue", 0);
                      SharedPreferences.Editor editor = mPrefs.edit();
                      editor.putString("key",Sid );
                      editor.commit();
                      Toast.makeText(LoginActivity.this, "" +Sid, Toast.LENGTH_LONG).show();
                      String LastName=response.body().getData().getSession().getSubscriber().getLast_name();
                      String Email=response.body().getData().getSession().getSubscriber().getAddress().getEmail1();
                      String Phone=response.body().getData().getSession().getSubscriber().getAddress().getPhone1();
                      String City=response.body().getData().getSession().getSubscriber().getAddress().getCity();
                      String PostalCode=response.body().getData().getSession().getSubscriber().getAddress().getZip();
                      String AdhaarNaumber=response.body().getData().getSession().getSubscriber().getAadhar_number();

                      pDialog.dismiss();
                      Bundle userprofile= new Bundle();
                      userprofile.putString("ufirstname",FirstName);
                      userprofile.putString("ulastname",LastName);
                      userprofile.putString("email",Email);
                      userprofile.putString("phone",Phone);
                      userprofile.putString("city",City);
                      userprofile.putString("postalcode",PostalCode);
                      userprofile.putString("adhaarcard",AdhaarNaumber);

                      Intent a=new Intent(LoginActivity.this,AddAgentActivity.class);

                      startActivity(a);


                   }
              else
                  {

                     Toast.makeText(LoginActivity.this, "" + response.body().getMessage(), Toast.LENGTH_LONG).show();
                     pDialog.dismiss();
                  }

            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t)
            {
                     Toast.makeText(LoginActivity.this,"Something went Wrong",Toast.LENGTH_LONG).show();
                pDialog.dismiss();


            }
        });
    }


}
