package infotech.hackathon;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommonRecyclerViewAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private ArrayList<Bean> arrayList_bean;
    private int id;
    private int screenWidth;

    public CommonRecyclerViewAdapter(Activity activity, ArrayList<Bean> arrayList_bean,int id) {
        this.activity = activity;
        this.arrayList_bean=arrayList_bean;
        this.id=id;

        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
    }

    @Override
    public CustomRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(id==0)
        {
            View view = LayoutInflater.from(activity)
                    .inflate(R.layout.listview_item1, parent, false);
            Holder dataObjectHolder = new Holder(view);
            return dataObjectHolder;
        }
        else{
            View view = LayoutInflater.from(activity)
                    .inflate(R.layout.listview_item2, parent, false);
            Holder dataObjectHolder = new Holder(view);
            return dataObjectHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Holder myHolder = (Holder) holder;

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(arrayList_bean.get(position).getImageView(), opts);
        opts.inJustDecodeBounds = false;

        myHolder.tv1.setText(arrayList_bean.get(position).getTextView1());
        if(id==0)
        myHolder.tv2.setText(arrayList_bean.get(position).getTextView2());

        myHolder.imageProgressBar.setVisibility(View.VISIBLE);

        Picasso.with(activity)
                .load(arrayList_bean.get(position).getImageView())
                .fit()
                .into(myHolder.images, new Callback() {
                    @Override
                    public void onSuccess() {
                        myHolder.imageProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        myHolder.imageProgressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return arrayList_bean.size();
    }

    public class Holder extends CustomRecycleViewHolder {
        private ImageView images;
        private TextView tv1;
        private TextView tv2;
        private ProgressBar imageProgressBar;

        public Holder(View itemView) {
            super(itemView);
            images = (ImageView) itemView.findViewById(R.id.ivItemGridImage);
            imageProgressBar = (ProgressBar) itemView.findViewById(R.id.image_progress_bar);
            tv1 = (TextView) itemView.findViewById(R.id.tv_1);
            if(id==0)
            tv2 = (TextView) itemView.findViewById(R.id.tv_2);
        }
    }
}
