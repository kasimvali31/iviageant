package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import simplytextile.policytracker.R;

public class UpdateUserProfileActivity extends AppCompatActivity
{
    Spinner selectcstate;
    String City,bname,fname,lname,dob,email,p1,p2,aadar,pan,add1,citys,state,pin;

    EditText UpdatFirstname,UpdateLastanme,UpdateEmailAdress,UpdateAdharNumber,UPdatecity,UpdatePostal,UpdateState;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user_profile_activity);
        b=getIntent().getExtras();
        bname=b.getString("bname");
        fname=b.getString("fname");
        lname=b.getString("lname");
        dob=b.getString("dob");
        email=b.getString("email");
        p1=b.getString("p1");
        p2=b.getString("p2");
        aadar=b.getString("aadar");
        pan=b.getString("pan");
        add1=b.getString("add1");
        citys=b.getString("city");
        state=b.getString("state");
        pin=b.getString("pin");

        initViews();
    }

    private void initViews()
    {

//        selectcstate=(Spinner)findViewById(R.id.user_select_state);
////        ArrayAdapter<CharSequence> selectstate = ArrayAdapter.createFromResource(this, R.array.select_state, android.R.layout.simple_spinner_item);
////        selectstate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        selectcstate.setAdapter(selectstate);

        UpdatFirstname=(EditText)findViewById(R.id.firstname_userprofile_input);
        UpdateLastanme=(EditText)findViewById(R.id.lastname_userprofile_input);
        UpdateEmailAdress=(EditText)findViewById(R.id.emaail_userprofile_input);
        UpdateAdharNumber=(EditText)findViewById(R.id.aadhar_userprofile_input);
        UPdatecity=(EditText)findViewById(R.id.city_userprofile_input);
        UpdatePostal=(EditText)findViewById(R.id.postalcode_userprofile_input);
        UpdateState=(EditText)findViewById(R.id.user_select_state);


        UpdatFirstname.setText(LoginActivity.FirstName);
        UpdateLastanme.setText(LoginActivity.LastName);
        UpdateEmailAdress.setText(LoginActivity.Email);
        UpdatePostal.setText(LoginActivity.PostalCode);
        UPdatecity.setText(UserProfileActivity.city);
        UpdateAdharNumber.setText(UserProfileActivity.Adharnumber);


        Toast.makeText(UpdateUserProfileActivity.this, "" +City, Toast.LENGTH_LONG).show();



    }
}
