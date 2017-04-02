package infotech.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class State_detail extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private RecyclerView.LayoutManager mLayoutManager;
    CommonRecyclerViewAdapter adapter;
    private String[] state_detail_name;
    static int ResId_state;
    private String[] state_detail_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);
        setTitle("Explore Your State");
        recyclerViewMain=(RecyclerView)findViewById(R.id.my_recycler_view);
        ResId_state=getIntent().getExtras().getInt("ResId");

        state_detail_name=getResources().getStringArray(R.array.state_detail);

        switch(ResId_state)
        {
            case 0:
                state_detail_images=getResources().getStringArray(R.array.arunachal_detail);
                break;
            case 1:
                state_detail_images=getResources().getStringArray(R.array.assam_detail);
                break;
            case 2:
                state_detail_images=getResources().getStringArray(R.array.manipur_detail);
                break;
            case 3:
                state_detail_images=getResources().getStringArray(R.array.meghalaya_detail);
                break;
            case 4:
                state_detail_images=getResources().getStringArray(R.array.mizoram_detail);
                break;
            case 5:
                state_detail_images=getResources().getStringArray(R.array.nagaland_detail);
                break;
            case 6:
                state_detail_images=getResources().getStringArray(R.array.sikkim_detail);
                break;
            case 7:
                state_detail_images=getResources().getStringArray(R.array.tripura_detail);
                break;

        }

        ArrayList<Bean> arrayList_state=new ArrayList<>();

        for(int i=0; i<state_detail_images.length;i++) {
            Bean bean = new Bean();
            bean.setTextView1(state_detail_name[i]);
            bean.setImageView(state_detail_images[i]);
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
                        Intent i1=new Intent(State_detail.this,State_detail_detail.class);
                        i1.putExtra("ResId",position);
                        startActivity(i1);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
    }
}

