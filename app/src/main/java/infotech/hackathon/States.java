package infotech.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class States extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private RecyclerView.LayoutManager mLayoutManager;
    CommonRecyclerViewAdapter adapter;
    private String[] state_name;
    private String[] capital_name;
    private String[] state_images={
      "https://greenerpasturesind.files.wordpress.com/2012/10/arunachal-pradesh-ziro-apatani-daporijo-subansiri-valley-tagin-tribe11.jpg",
            "http://www.mapsofindia.com/assam/assam-images/aswaklanta-temple.jpg",
            "http://reviewne.com/wp-content/uploads/2014/08/Loktak-Lake-1024x600.jpg",
              "http://im.hunt.in/cg/meg/About/Profile/Culture/dance1.jpg",
              "http://travelthemes.in/wp-content/uploads/2016/04/54cbf78f998d4de83ba396b5_image.jpg",
              "http://www.mapsofindia.com/nagaland/nagaland-images/morung-of-pochury-tribe.jpg",
              "http://vasantkamal.com/wp-content/uploads/2015/05/Sikkim-Buddha-park.jpg",
              "http://www.mybudgettrip.com/images/Tripura-banner.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);

        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);

        state_name=getResources().getStringArray(R.array.states);
        capital_name=getResources().getStringArray(R.array.states_capital);

        ArrayList<Bean> arrayList_state=new ArrayList<>();

        for(int i=0; i<state_images.length;i++) {
            Bean bean = new Bean();
            bean.setTextView1(state_name[i]);
            bean.setTextView2(capital_name[i]);
            bean.setImageView(state_images[i]);
            arrayList_state.add(bean);
        }

        recyclerViewMain.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        recyclerViewMain.setLayoutManager(mLayoutManager);

        adapter = new CommonRecyclerViewAdapter(this, arrayList_state, 0);

        recyclerViewMain.setAdapter(adapter);

        recyclerViewMain.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerViewMain,new RecyclerItemClickListener.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i1=new Intent(States.this,State_detail.class);
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
