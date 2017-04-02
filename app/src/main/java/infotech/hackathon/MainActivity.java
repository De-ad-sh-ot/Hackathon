package infotech.hackathon;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import infotech.hackathon.login.SignInActivity;
import infotech.hackathon.maps.MapsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//
//    private String[] images={"https://thechroniclesofacreativemind.files.wordpress.com/2012/11/ne.jpg",
//            "http://m.sumeratravel.com/images/north-east.jpg",
//            "http://www.rainbowtravels.in/images/North%20East%203.jpg",
//            "http://indiaspend.com/wp-content/uploads/2012/06/hornbill-festival-COVER-STORY_WIDTH-414px_HT-299px.jpg"
//    };

    private RecyclerView recyclerViewMain;
    private LinearLayoutManager mLayoutManager;
    CommonRecyclerViewAdapter adapter;
    private String[] images={
        "http://thaitravelmart.com/uploads/tourism_news/05February2016_08.jpg",
        "https://image.slidesharecdn.com/north-east-india-110708020221-phpapp01/95/north-east-india-tourism-2-728.jpg?cb=1310090758",
            "http://4.bp.blogspot.com/-wKpyv73Yg7U/UNKn09ODrOI/AAAAAAAAABw/R3bhvOcdO98/s1600/North-East-logo.JPG",
        "https://image.slidesharecdn.com/north-east-india-110708020221-phpapp01/95/north-east-india-tourism-3-728.jpg?cb=1310090758",
        "http://www.thomascook.in/tcportal/images/holiday/holidayStaticPages/HolidayPhotoMaster/UN15108979.jpg",
        "https://image.slidesharecdn.com/north-east-india-110708020221-phpapp01/95/north-east-india-tourism-4-728.jpg?cb=1310090758"
    };

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
            authListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user == null) {
            // user auth state is changed - user is null
            // launch login activity
                        startActivity(new Intent(MainActivity.this, SignInActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();
                    }
                }
            };
        setContentView(R.layout.activity_main);
        recyclerViewMain = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Bean> arrayList_state=new ArrayList<>();

        for(int i=0; i<images.length;i++) {
            Bean bean = new Bean();
            bean.setImageView(images[i]);
            arrayList_state.add(bean);
        }

        recyclerViewMain.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewMain.setLayoutManager(mLayoutManager);

        adapter = new CommonRecyclerViewAdapter(this, arrayList_state, 2);

        recyclerViewMain.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        ImageView imageView=(ImageView) (findViewById(R.id.imageView1));

//        Picasso.with(this)
//                .load(images[1])
//                .fit()
//                .into(imageView);
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

            case R.id.logout:

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder
                    .setMessage(R.string.confirmation_msg)
                    .setTitle(R.string.btn_sign_out)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            signOut();
                        }})
                    .setNegativeButton(android.R.string.no, null);
                AlertDialog dialog = builder.create();
                dialog.show();

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //sign out method
     public void signOut() {
         auth.signOut();
             startActivity(new Intent(MainActivity.this, SignInActivity.class)
                     .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                     .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
         finish();
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

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}