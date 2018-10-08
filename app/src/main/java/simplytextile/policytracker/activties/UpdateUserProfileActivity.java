package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import simplytextile.policytracker.R;

public class UpdateUserProfileActivity extends AppCompatActivity {
    Spinner selectcstate;
    String City;

    EditText UpdatFirstname,UpdateLastanme,UpdateEmailAdress,UpdateAdharNumber,UPdatecity,UpdatePostal,UpdateState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user_profile_activity);
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
