package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import simplytextile.policytracker.R;

public class AddCompanyActivity extends AppCompatActivity {

    Spinner companytype,selectcompany;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);


        selectcompany=(Spinner)findViewById(R.id.selectcompany_addcompanyactivity);
        ArrayAdapter<CharSequence> selectcompanyadapter = ArrayAdapter.createFromResource(this, R.array.select_company, android.R.layout.simple_spinner_item);
        selectcompanyadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectcompany.setAdapter(selectcompanyadapter);

        companytype=(Spinner)findViewById(R.id.companytype_addcompanyactivity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_company_type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        companytype.setAdapter(adapter);
    }
}
