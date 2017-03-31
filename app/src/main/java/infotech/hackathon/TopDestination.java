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

    public static String[] IMAGES = new String[]{
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Tawang_Monastery_at_April.jpg/1280px-Tawang_Monastery_at_April.jpg",
            "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Nathu-La-pass.jpg",
            "http://maxpixel.freegreatpicture.com/static/photo/1x/River-Rafting-Water-Raft-Whitewater-Boat-Sport-444743.jpg",
            "http://bhaaratdarshan.com/ar/wp-content/uploads/2016/05/main-Gorichen-Peak-bhaaratdarshan-1.jpg",
            "https://en.wikipedia.org/wiki/Nuranang_Falls#/media/File:Nuranang.JPG",
            "https://en.wikipedia.org/wiki/File:Nohkalikai_falls.jpg",
            "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Jaintia-Hills1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/a/a5/Madhuri_Lake.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/a/af/Phodong_monastery_-_north_sikkim.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/7/70/The_Buddha_Park_or_Tathagata_Sthal%2C_Sikkim.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/2/2a/2010-kabini-tiger.jpg",
            "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Majuli-Islands1.jpg",
            "http://sevendiary.com/wp-content/uploads/2015/07/Shri-Govindajee-Temple_Imphal.jpg",
            "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Shilloi-Lake1.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/1/11/2007-sela-pass-1.jpg",
            "https://www.holidify.com/blog/wp-content/uploads/2014/10/5512100471_3fdacfdbb1_z.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/e/e7/Mawsmai_Cave_in_Meghalaya%2C_India.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/8/88/Brahmaputra_River,_Shigatse.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/9/98/Mount-dempo-tea-plantation.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/f/f5/Yak_animal_in_Sikkim_India.JPG",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/The_Dzukou_Valley.JPG/800px-The_Dzukou_Valley.JPG",
            "https://www.holidify.com/blog/wp-content/uploads/2014/10/2091431903_9a291d6735_z.jpg",
            "https://tmi2-tourmyindiapvtlt.netdna-ssl.com/blog/wp-content/uploads/2015/01/pelling-kanchendzonga.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recycler_view);

        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);

        names = getResources().getStringArray(R.array.topdestination_places);
        states = getResources().getStringArray(R.array.topdestination_states);

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
