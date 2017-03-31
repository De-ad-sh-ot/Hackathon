//package infotech.hackathon;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class topdestjava extends ArrayAdapter<String> {
//
//    private TextView tv1;
//    private TextView tv2;
//    private ImageView imageView;
//    private Activity context;
//    String[] names;
//    String[] states;
//    ArrayList<String> images;
//
//    public topdestjava(Activity context, String[] names, String[] states) {
//        super(context, R.layout.listview_item1, names);
//        this.context = context;
//        this.names = names;
//        this.states = states;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//
//        initializeImages();
//        LayoutInflater inflater = context.getLayoutInflater();
//
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.listview_item1, null, true);
//            tv1 = (TextView) convertView.findViewById(R.id.tv_1);
//            tv2 = (TextView) convertView.findViewById(R.id.tv_2);
//            imageView = (ImageView) convertView.findViewById(R.id.imageView);
//        }
//
//        tv1.setText(names[position]);
//        tv2.setText(states[position]);
//        Picasso
//                .with(context)
//                .load(images.get(position))
//                .error(R.drawable.ic_menu_camera)
//                .placeholder(R.drawable.logo)
//                .fit()
//                .into(imageView);
//        return convertView;
//    }
//    private void initializeImages() {
//        images = new ArrayList<String>();
//        for (int i = 0; i < TopDestination.images.length; i++) {
//            images.add(TopDestination.images[i]);
//        }
//    }
//}
//
//
//
//
