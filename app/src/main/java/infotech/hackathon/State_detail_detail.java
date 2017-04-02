package infotech.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class State_detail_detail extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private RecyclerView.LayoutManager mLayoutManager;
    CommonRecyclerViewAdapter adapter;
    static String[] state_detail_detail_name;
    static String[] state_detail_detail_content;
    static int ResId_state_detail;
    static String[] state_detail_detail_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);

        recyclerViewMain=(RecyclerView)findViewById(R.id.my_recycler_view);
        ResId_state_detail=getIntent().getExtras().getInt("ResId");

        state_detail_detail_images=new String[]{
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg"
        };

        switch(State_detail.ResId_state){
            case 0:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_tourist);
                        state_detail_detail_images=getResources().getStringArray(R.array.arunachal_tourist_images);
                        getSupportActionBar().setTitle("Arunachal Pradesh");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_festival);
                        getSupportActionBar().setTitle("Arunachal Pradesh");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_dance);
                        getSupportActionBar().setTitle("Arunachal Pradesh");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_cuisine);
                        getSupportActionBar().setTitle("Arunachal Pradesh");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_how);
                        getSupportActionBar().setTitle("Arunachal Pradesh");
                        break;
                    default:
                        getSupportActionBar().setTitle("Arunachal Pradesh");
                        break;
                }
                break;
            case 1:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_tourist);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_tourist_images);
                        getSupportActionBar().setTitle("Assam");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_festival);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_festival_images);
                        getSupportActionBar().setTitle("Assam");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_dance);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_dance_images);
                        state_detail_detail_content=getResources().getStringArray(R.array.assam_dance_content);
                        getSupportActionBar().setTitle("Assam");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_cuisine);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_cuisine_images);
                        getSupportActionBar().setTitle("Assam");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_how);
                        getSupportActionBar().setTitle("Assam");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_tourist);
                        getSupportActionBar().setTitle("Manipur");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_festival);
                        getSupportActionBar().setTitle("Manipur");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_dance);
                        getSupportActionBar().setTitle("Manipur");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_cuisine);
                        getSupportActionBar().setTitle("Manipur");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_how);
                        getSupportActionBar().setTitle("Manipur");
                        break;
                    default:
                        getSupportActionBar().setTitle("Manipur");
                        break;
                }
                break;
            case 3:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_tourist);
                        getSupportActionBar().setTitle("Meghalaya");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_festival);
                        getSupportActionBar().setTitle("Meghalaya");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_dance);
                        getSupportActionBar().setTitle("Meghalaya");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_cuisine);
                        getSupportActionBar().setTitle("Meghalaya");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_how);
                        getSupportActionBar().setTitle("Meghalaya");
                        break;
                    default:
                        getSupportActionBar().setTitle("Meghalaya");
                        break;
                }
                break;
            case 4:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_tourist);
                        getSupportActionBar().setTitle("Mizoram");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_festival);
                        getSupportActionBar().setTitle("Mizoram");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_dance);
                        getSupportActionBar().setTitle("Mizoram");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_cuisine);
                        getSupportActionBar().setTitle("Mizoram");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_how);
                        getSupportActionBar().setTitle("Mizoram");
                        break;
                    default:
                        getSupportActionBar().setTitle("Mizoram");
                        break;
                }
                break;
            case 5:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_tourist);
                        getSupportActionBar().setTitle("Nagaland");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_festival);
                        getSupportActionBar().setTitle("Nagaland");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_dance);
                        getSupportActionBar().setTitle("Nagaland");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_cuisine);
                        getSupportActionBar().setTitle("Nagaland");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_how);
                        getSupportActionBar().setTitle("Nagaland");
                        break;
                    default:
                        getSupportActionBar().setTitle("Nagaland");
                        break;
                }
                break;
            case 6:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_tourist);
                        state_detail_detail_images=getResources().getStringArray(R.array.sikkim_tourist_images);
                        getSupportActionBar().setTitle("Sikkim");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_festival);
                        state_detail_detail_images=getResources().getStringArray(R.array.sikkim_festival_images);
                        getSupportActionBar().setTitle("Sikkim");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_dance);
                        state_detail_detail_images=getResources().getStringArray(R.array.sikkim_dance_images);
                        getSupportActionBar().setTitle("Sikkim");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_cuisine);
                        getSupportActionBar().setTitle("Sikkim");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_how);
                        getSupportActionBar().setTitle("Sikkim");
                        break;
                    default:
                        getSupportActionBar().setTitle("Sikkim");
                        break;
                }
                break;
            case 7:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_tourist);
                        getSupportActionBar().setTitle("Tripura");
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_festival);
                        getSupportActionBar().setTitle("Tripura");
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_dance);
                        getSupportActionBar().setTitle("Tripura");
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_cuisine);
                        getSupportActionBar().setTitle("Tripura");
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_how);
                        getSupportActionBar().setTitle("Tripura");
                        break;
                    default:
                        getSupportActionBar().setTitle("Tripura");
                        break;
                }
                break;
            default:
                getSupportActionBar().setTitle("Tripura");
                break;
        }

        ArrayList<Bean> arrayList_state=new ArrayList<>();

        for(int i=0; i<state_detail_detail_images.length;i++) {
            Bean bean = new Bean();
            bean.setTextView1(state_detail_detail_name[i]);
            bean.setImageView(state_detail_detail_images[i]);
            arrayList_state.add(bean);
        }

        recyclerViewMain.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        recyclerViewMain.setLayoutManager(mLayoutManager);

        adapter = new CommonRecyclerViewAdapter(this, arrayList_state, 1);

        recyclerViewMain.setAdapter(adapter);

        recyclerViewMain.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerViewMain,new RecyclerItemClickListener.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i1=new Intent(State_detail_detail.this,Final_detail_page.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("ResId",position);
                        bundle.putInt("ActivityId",0);
                        i1.putExtras(bundle);
                        startActivity(i1);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
    }
}
