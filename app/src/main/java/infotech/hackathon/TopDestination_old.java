//package infotech.hackathon;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//public class TopDestination extends AppCompatActivity {
//    private Context context;
//
//    private ListView lvproducts;
//    private String[] names;
//    private String[] states;
//    static String[] images;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.common_recycler_view);
//
//        names = getResources().getStringArray(R.array.topdestination_places);
//        states = getResources().getStringArray(R.array.topdestination_states);
//
//        images = new String[]{"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Indian_rhinoceros%2Ckaziranga_national_park.jpg/1280px-Indian_rhinoceros%2Ckaziranga_national_park.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Tawang_Monastery_at_April.jpg/1280px-Tawang_Monastery_at_April.jpg",
//        "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Nathu-La-pass.jpg",
//        "http://maxpixel.freegreatpicture.com/static/photo/1x/River-Rafting-Water-Raft-Whitewater-Boat-Sport-444743.jpg",
//        "http://bhaaratdarshan.com/ar/wp-content/uploads/2016/05/main-Gorichen-Peak-bhaaratdarshan-1.jpg",
//        "https://en.wikipedia.org/wiki/Nuranang_Falls#/media/File:Nuranang.JPG",
//        "https://en.wikipedia.org/wiki/File:Nohkalikai_falls.jpg",
//        "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Jaintia-Hills1.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/a/a5/Madhuri_Lake.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/a/af/Phodong_monastery_-_north_sikkim.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/7/70/The_Buddha_Park_or_Tathagata_Sthal%2C_Sikkim.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/2/2a/2010-kabini-tiger.jpg",
//        "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Majuli-Islands1.jpg",
//        "http://sevendiary.com/wp-content/uploads/2015/07/Shri-Govindajee-Temple_Imphal.jpg",
//        "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2015/01/Shilloi-Lake1.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/1/11/2007-sela-pass-1.jpg",
//        "https://www.holidify.com/blog/wp-content/uploads/2014/10/5512100471_3fdacfdbb1_z.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/e/e7/Mawsmai_Cave_in_Meghalaya%2C_India.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/8/88/Brahmaputra_River,_Shigatse.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/9/98/Mount-dempo-tea-plantation.jpg",
//        "https://upload.wikimedia.org/wikipedia/commons/f/f5/Yak_animal_in_Sikkim_India.JPG",
//        "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/The_Dzukou_Valley.JPG/800px-The_Dzukou_Valley.JPG",
//        "https://www.holidify.com/blog/wp-content/uploads/2014/10/2091431903_9a291d6735_z.jpg",
//        "https://tmi2-tourmyindiapvtlt.netdna-ssl.com/blog/wp-content/uploads/2015/01/pelling-kanchendzonga.jpg"};
//
////        placeName= new int[]{R.string.rang_ghar,R.string.namdapha_national_park};
////        placeContent=new int[]{R.string.rang_ghar_detail,R.string.namdapha_national_park_detail};
////        placeImage=new int[]{R.drawable.rang_ghar,R.drawable.namdapha_national_park};
//
//        topdestjava topdestjava=new topdestjava(this,names,states);
//
//        lvproducts = (ListView) findViewById(R.id.lvProducts);
//
//        lvproducts.setAdapter(topdestjava);
//
//        lvproducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                imageView=(ImageView)findViewById(R.id.imageView);
////                imageView.setImageResource(placeImage[view.getId()]);
////
////                textView=(TextView)findViewById(R.id.textView_content);
////                textView.setText(placeContent[view.getId()]);
//
//                Intent i1=new Intent(TopDestination.this,Final_detail_page.class);
//                i1.putExtra("ResId",i);
//                startActivity(i1);
//
//            }
//        });
//    }
//}
