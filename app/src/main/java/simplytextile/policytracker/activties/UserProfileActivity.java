package simplytextile.policytracker.activties;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import simplytextile.policytracker.R;

public class UserProfileActivity extends AppCompatActivity {

ImageView updateprofile;
TextView FirstName,ULastName,UEmail,UPhonenumber,UAadahaarNumber,UAddress,UCity,UPostalCode;
public static String Fname1,Lname,Phone,Adharnumber,city,postalcode,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity_);

        FirstName=(TextView)findViewById(R.id.ufirstname_userprofile_input);
        ULastName=(TextView)findViewById(R.id.lastname_userprofile_input);
        UPhonenumber=(TextView)findViewById(R.id.phone_userprofile_input);
        UAadahaarNumber=(TextView)findViewById(R.id.aadhar_userprofile_input);
        UEmail=(TextView)findViewById(R.id.emaail_userprofile_input);


       // UAddress=(TextView)findViewById(R.id.address_userprofile_input);
        UCity=(TextView)findViewById(R.id.city_userprofile_input);
        UPostalCode=(TextView)findViewById(R.id.postalcode_userprofile_input);





//        String FName=bundle.getString("ProfileFirstName");
//        Toast.makeText(UserProfileActivity.this, "" +FName, Toast.LENGTH_LONG).show();
//        FirstName.setText("Welcome ,"+getIntent().getExtras().getString("ProfileFirstName"));
//        Bundle gt=getIntent().getExtras();
//        String Fname  =gt.getString("ufirstname");
//        String Lname=gt.getString("ulastname");
//        String PhoneNo=gt.getString("phone");
//        String Ucity=gt.getString("city");
//        String Upostalcode=gt.getString("postalcode");
//        String Adhaar=gt.getString("adhaarcard");


Fname1=LoginActivity.FirstName;
Lname=LoginActivity.LastName;
Phone=LoginActivity.Phone;
Adharnumber=LoginActivity.AdhaarNaumber;
city=LoginActivity.City;
postalcode=LoginActivity.PostalCode;
Email=LoginActivity.Email;





FirstName.setText(Fname1);
ULastName.setText(Lname);
UPhonenumber.setText(Phone);
UAadahaarNumber.setText(Adharnumber);
UCity.setText(city);
UPostalCode.setText(postalcode);
UEmail.setText(Email);
initViews();




        Toast.makeText(UserProfileActivity.this, "" +Fname1, Toast.LENGTH_LONG).show();
//        FirstName.setText(Fname);
//        ULastName.setText(Lname);
//        UPhonenumber.setText(PhoneNo);
//        UCity.setText(Ucity);
//        UPostalCode.setText(Upostalcode);
//        UAadahaarNumber.setText(Adhaar);




    }

    private void initViews()
    {
updateprofile=(ImageView)findViewById(R.id.btn_updateprofile);
updateprofile.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        Intent updateprofile=new Intent(UserProfileActivity.this,UpdateUserProfileActivity.class);
        startActivity(updateprofile);
    }
});

    }
}
