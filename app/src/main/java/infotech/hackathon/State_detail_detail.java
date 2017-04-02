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
    static String[] state_detail_detail_images={
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);

        recyclerViewMain=(RecyclerView)findViewById(R.id.my_recycler_view);
        ResId_state_detail=getIntent().getExtras().getInt("ResId");

        switch(State_detail.ResId_state){
            case 0:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_tourist);
                        state_detail_detail_images=getResources().getStringArray(R.array.arunachal_tourist_images);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_festival);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_dance);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.arunachal_how);
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_tourist);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_tourist_images);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_festival);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_festival_images);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_dance);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_dance_images);
                        state_detail_detail_content=getResources().getStringArray(R.array.assam_dance_content);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_cuisine);
                        state_detail_detail_images=getResources().getStringArray(R.array.assam_cuisine_images);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.assam_how);
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
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_festival);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_dance);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.manipur_how);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_tourist);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_festival);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_dance);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.meghalaya_how);
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_tourist);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_festival);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_dance);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.mizoram_how);
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_tourist);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_festival);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_dance);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.nagaland_how);
                        break;
                    default:
                        break;
                }
                break;
            case 6:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_tourist);
                        state_detail_detail_images=getResources().getStringArray(R.array.sikkim_tourist_images);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_festival);
                        state_detail_detail_images=getResources().getStringArray(R.array.sikkim_festival_images);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_dance);
                        state_detail_detail_images=getResources().getStringArray(R.array.sikkim_dance_images);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.sikkim_how);
                        break;
                    default:
                        break;
                }
                break;
            case 7:
                switch (ResId_state_detail)
                {
                    case 0:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_tourist);
                        break;
                    case 1:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_festival);
                        break;
                    case 2:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_dance);
                        break;
                    case 3:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_cuisine);
                        break;
                    case 4:
                        state_detail_detail_name=getResources().getStringArray(R.array.tripura_how);
                        break;
                    default:
                        break;
                }
                break;
            default:
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
