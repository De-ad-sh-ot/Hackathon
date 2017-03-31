package infotech.hackathon;

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
    private TextView textView;
    private ImageView imageView;
    private int ResId;
    private int ActivityId;

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

                textView = (TextView) findViewById(R.id.textView_content);
                textView.setText(pageContent);

                imageView = (ImageView) findViewById(R.id.imageView_destination);
                Picasso.with(this)
                        .load(pageImage)
                        .fit()
                        .into(imageView);

                setTitle(pageTitle);
            }

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
}
