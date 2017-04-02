package infotech.hackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Final_detail_page extends AppCompatActivity {

    private String pageTitle;
    private String pageContent;
    private String pageImage;
    private String fabLocation;
    private TextView textView;
    private ImageView imageView;
    private int ResId;
    private int ActivityId;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_detail);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)
                findViewById(R.id.toolbar_layout);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_destination_detail);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        ResId = bundle.getInt("ResId");
        ActivityId = bundle.getInt("ActivityId");

        if (ActivityId == 1) {
            pageTitle = TopDestination.names[ResId];
            pageImage = TopDestination.IMAGES[ResId];
            fabLocation = TopDestination.locations[ResId];
            pageContent=TopDestination.content[ResId];

            textView = (TextView) findViewById(R.id.textView_content);
            textView.setText(pageContent);

            imageView = (ImageView) findViewById(R.id.imageView_destination);
            Picasso.with(this)
                    .load(pageImage)
                    .fit()
                    .into(imageView);

            setTitle(pageTitle);
        } else if (ActivityId == 0)
            {
                pageTitle = State_detail_detail.state_detail_detail_name[ResId];
                pageImage = State_detail_detail.state_detail_detail_images[ResId];
                pageContent=State_detail_detail.state_detail_detail_content[ResId];

                textView = (TextView) findViewById(R.id.textView_content);
                textView.setText(pageContent);

                imageView = (ImageView) findViewById(R.id.imageView_destination);
                Picasso.with(this)
                        .load(pageImage)
                        .fit()
                        .into(imageView);

                setTitle(pageTitle);

                if(State_detail_detail.ResId_state_detail!=0)
                    fab.hide();
            }

            fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:<"+fabLocation+">?q=<"+fabLocation+">"+(pageTitle)));
                    Intent intentChooser=Intent.createChooser(intent,"Launch Maps");
                    startActivity(intentChooser);

                }
            });
        }
}
