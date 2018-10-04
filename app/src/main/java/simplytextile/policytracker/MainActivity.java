package simplytextile.policytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import simplytextile.policytracker.activties.AgentsListActivity;
import simplytextile.policytracker.activties.CompaniesActivity;
import simplytextile.policytracker.activties.CustomerActivity;
import simplytextile.policytracker.activties.NotificationActivity;
import simplytextile.policytracker.activties.PoliciesActivity;
import simplytextile.policytracker.activties.UpdateUserProfileActivity;
import simplytextile.policytracker.activties.UserProfileActivity;
import simplytextile.policytracker.models.Customer;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ImageView profileimage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        profileimage=(ImageView)findViewById(R.id.profileimage);
//        profileimage.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent updateprofile=new Intent(MainActivity.this, UpdateUserProfileActivity.class);
//                startActivity(updateprofile);
//            }
//        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerview = navigationView.getHeaderView(0);
        TextView profilename = (TextView) headerview.findViewById(R.id.username);
        profilename.setText("your name");
        LinearLayout header = (LinearLayout) headerview.findViewById(R.id.header);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent updateprofile=new Intent(MainActivity.this, UserProfileActivity.class);
                startActivity(updateprofile);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home)
        {
            // Handle the camera action
//            Intent home =new Intent(MainActivity.this, CompaniesActivity.class);
//            startActivity(home);
        }
        else if (id == R.id.company)
        {
            Intent company =new Intent(MainActivity.this, CompaniesActivity.class);
            startActivity(company);
        }
        else if (id == R.id.policies)
        {
            Intent home =new Intent(MainActivity.this, AgentsListActivity.class);
            startActivity(home);
        }

        else if (id == R.id.customers)
        {
            Intent customer =new Intent(MainActivity.this, CustomerActivity.class);
            startActivity(customer);

        }
        else if (id == R.id.notifications)
        {
            Intent  notification=new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(notification);
        }
        else if (id == R.id.logout)
        {

        }
//        else if (id == R.id.nav_share)
//        {
//
//        }
//        else if (id == R.id.nav_send)
//        {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
