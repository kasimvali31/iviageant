package simplytextile.policytracker.activties;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import simplytextile.policytracker.R;

public class HomeActivity extends AppCompatActivity {
    CardView homecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        homecard=(CardView)findViewById(R.id.android_card_home);
        homecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent homeintent=new Intent(HomeActivity.this,CustomerActivity.class);
                startActivity(homeintent);
            }
        });
    }
}
