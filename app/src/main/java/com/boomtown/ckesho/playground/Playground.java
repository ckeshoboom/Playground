package com.boomtown.ckesho.playground;



import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;




public class Playground extends AppCompatActivity {

    Button btn_leadProfileActivity, btn_swipeActivity, btn_feedActivity, btn_CIDActivity, btn_SearchContactsActivity, btn_FragHolderActivity;
    Resources r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_leadProfileActivity=(Button)findViewById(R.id.btn_leadProfileActivity);
        btn_swipeActivity=(Button)findViewById(R.id.btn_swipeActivity);
        btn_feedActivity=(Button)findViewById(R.id.btn_feedActivity);
        btn_SearchContactsActivity=(Button)findViewById(R.id.btn_SearchContactsActivity);
        btn_CIDActivity=(Button)findViewById(R.id.btn_CIDActivity);
        btn_FragHolderActivity=(Button)findViewById(R.id.btn_FragHolderActivity);



        //Note This is how you call drawables now!
        //ContextCompat.getDrawable(this,R.drawable.category_hot_frame);

        btn_leadProfileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leadProfileActivity = new Intent(getBaseContext(), LeadProfileActivity.class);

                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_enter_animation, R.anim.activity_exit_animation).toBundle();
                startActivity(leadProfileActivity, bundle);
            }
        });

        btn_swipeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swipeActivity = new Intent(getBaseContext(), SwipeActivity.class);

                Bundle bundle= ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_enter_animation, R.anim.activity_exit_animation).toBundle();
                startActivity(swipeActivity, bundle);
            }
        });


        btn_feedActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedActivity = new Intent(getBaseContext(), FeedActivity.class);

                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_enter_animation, R.anim.activity_exit_animation).toBundle();
                startActivity(feedActivity, bundle);
            }
        });


        btn_CIDActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CIDActivityIntent = new Intent(getBaseContext(), CIDActivity.class);

                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_enter_animation, R.anim.activity_exit_animation).toBundle();
                startActivity(CIDActivityIntent, bundle);
            }
        });

        btn_SearchContactsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SearchContactsActivityIntent = new Intent(getBaseContext(), SearchContactsActivity.class);

                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_enter_animation, R.anim.activity_exit_animation).toBundle();
                startActivity(SearchContactsActivityIntent, bundle);
            }
        });

        btn_FragHolderActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SearchContactsActivityIntent = new Intent(getBaseContext(), FragmentHolderActivity.class);

                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.activity_enter_animation, R.anim.activity_exit_animation).toBundle();
                startActivity(SearchContactsActivityIntent, bundle);
            }
        });


    }//end on create

}
