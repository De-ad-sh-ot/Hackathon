package infotech.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class TopDestination extends AppCompatActivity{

    private RecyclerView recyclerViewMain;
    private RecyclerView.LayoutManager mLayoutManager;
    CommonRecyclerViewAdapter adapter;
    static String[] names;
    static String[] states;
    static String[] locations;
    static String[] content;

    public static String[] IMAGES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);
setTitle("Top Destination");
        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);

        names = getResources().getStringArray(R.array.topdestination_places);
        states = getResources().getStringArray(R.array.topdestination_states);
        IMAGES=getResources().getStringArray(R.array.topdestination_images);
        locations=getResources().getStringArray((R.array.topdestination_location));
        content=getResources().getStringArray(R.array.topdestination_content);

        ArrayList<Bean> arrayList_bean = new ArrayList<>();

        for(int i=0;i<IMAGES.length;i++) {
            Bean bean=new Bean();
            bean.setImageView(IMAGES[i]);
            bean.setTextView1(names[i]);
            bean.setTextView2(states[i]);
            arrayList_bean.add(bean);
        }

        recyclerViewMain.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        recyclerViewMain.setLayoutManager(mLayoutManager);

        adapter = new CommonRecyclerViewAdapter(this, arrayList_bean, 0);

        recyclerViewMain.setAdapter(adapter);

        recyclerViewMain.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerViewMain,new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position) {
                Intent i1=new Intent(TopDestination.this,Final_detail_page.class);
                Bundle bundle=new Bundle();
                bundle.putInt("ResId",position);
                bundle.putInt("ActivityId",1);
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
