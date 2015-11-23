package com.boomtown.ckesho.playground;

import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.boomtown.ckesho.playground.Adapters.FeedAdapter;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    FeedAdapter feedAdapter;
    ArrayList<String> arrayList;
    String[] arrayString=new String[20];
    int action_xfinal, action_xinitial, action_yinitial;
    boolean swipedRight;
    View touchedview;
    int touchedposition;
    RoundedBitmapDrawable drawable;


    //for android2.3 and lower. For 3.0 and higher this is passed to action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_swipe_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);




        listView=(ListView)findViewById(R.id.lv_feed);
        action_xinitial=0;
        action_xfinal =0;
        action_yinitial=0;
        swipedRight =false;

        for(int cnt=0;cnt<20;cnt++) {
            arrayString[cnt]="Truman Sparks";
        }
        //arrayAdapter=new ArrayAdapter<String>( this,R.layout.swipe_item,R.id.lbl_swipeItem1, arrayString);
        feedAdapter=new FeedAdapter(this,R.layout.feed_item,R.id.lbl_feed_name, arrayString);
        //View footer= View.inflate(this, R.layout.property_block_item, null);
        //listView.addFooterView(footer);
        listView.setAdapter(feedAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("position","position= "+position);
            }
        });







    }//end on create



}
