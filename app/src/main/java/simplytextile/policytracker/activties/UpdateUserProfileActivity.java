package simplytextile.policytracker.activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import simplytextile.policytracker.R;

public class UpdateUserProfileActivity extends AppCompatActivity {
    Spinner selectcstate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user_profile_activity);
        initViews();
    }

    private void initViews()
    {

        selectcstate=(Spinner)findViewById(R.id.user_select_state);
        ArrayAdapter<CharSequence> selectstate = ArrayAdapter.createFromResource(this, R.array.select_state, android.R.layout.simple_spinner_item);
        selectstate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectcstate.setAdapter(selectstate);
    }
}
