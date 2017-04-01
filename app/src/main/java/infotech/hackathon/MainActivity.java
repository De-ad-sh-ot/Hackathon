package infotech.hackathon;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import infotech.hackathon.maps.MapsActivity;

import static infotech.hackathon.R.drawable.content_main1;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String[] images={"https://thechroniclesofacreativemind.files.wordpress.com/2012/11/ne.jpg",
            "http://m.sumeratravel.com/images/north-east.jpg",
            "http://www.rainbowtravels.in/images/North%20East%203.jpg",
            "http://indiaspend.com/wp-content/uploads/2012/06/hornbill-festival-COVER-STORY_WIDTH-414px_HT-299px.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView imageView=(ImageView) (findViewById(R.id.imageView1));

        Picasso.with(this)
                .load(images[1])
                .fit()
                .into(imageView);
//
//        imageView.setImageResource(R.drawable.north_east);
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
        switch(id)
        {
            case R.id.arunachal_pradesh:
                Intent i1=new Intent(this,State_detail.class);
                i1.putExtra("ResId",0);
                startActivity(i1);
                break;
            case R.id.assam:
                Intent i2=new Intent(this,State_detail.class);
                i2.putExtra("ResId",1);
                startActivity(i2);
                break;
            case R.id.manipur:
                Intent i3=new Intent(this,State_detail.class);
                i3.putExtra("ResId",2);
                startActivity(i3);
                break;
            case R.id.meghalaya:
                Intent i4=new Intent(this,State_detail.class);
                i4.putExtra("ResId",3);
                startActivity(i4);
                break;
            case R.id.mizoram:
                Intent i5=new Intent(this,State_detail.class);
                i5.putExtra("ResId",4);
                startActivity(i5);
                break;
            case R.id.nagaland:
                Intent i6=new Intent(this,State_detail.class);
                i6.putExtra("ResId",5);
                startActivity(i6);
                break;
            case R.id.sikkim:
                Intent i7=new Intent(this,State_detail.class);
                i7.putExtra("ResId",6);
                startActivity(i7);
                break;
            case R.id.tripura:
                Intent i8=new Intent(this,State_detail.class);
                i8.putExtra("ResId",7);
                startActivity(i8);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.topdestination) {

            Intent i=new Intent(MainActivity.this,TopDestination.class);
            startActivity(i);

        } else if (id == R.id.NewsFeed) {
            Intent i=new Intent(MainActivity.this,newsFeed.class);
            startActivity(i);
        } else if (id == R.id.ExploreTheNorthEast) {
            Intent i=new Intent(MainActivity.this,States.class);
            startActivity(i);

        } else if (id == R.id.Reviews) {

        } else if (id == R.id.ContactUs) {

        } else if (id == R.id.AboutandHelp) {

        }
        else if (id == R.id.NearebyFacilities) {

            Intent k=new Intent(MainActivity.this,MapsActivity.class);
            startActivity(k);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
