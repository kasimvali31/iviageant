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

import simplytextile.policytracker.MainActivity;
import simplytextile.policytracker.R;

public class SignupActivity extends AppCompatActivity
{
    EditText input_firstname,input_lastname,input_email,input_phone,input_loginanme,input_password;
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
                Intent  dasboard=new Intent(SignupActivity.this,MainActivity.class);
                startActivity(dasboard);

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
}
