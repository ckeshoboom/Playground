package com.boomtown.ckesho.playground;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.boomtown.ckesho.playground.Adapters.SwipeAdapter;

import java.util.ArrayList;

public class SwipeActivity extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    SwipeAdapter swipeAdapter;
    ArrayList<String> arrayList;
    String[] arrayString=new String[20];
    int action_xfinal, action_xinitial, action_yinitial;
    boolean swipedRight;
    View touchedview;
    int touchedposition;


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
        setContentView(R.layout.swipe_layout);
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
        listView=(ListView)findViewById(R.id.lv_listView);
        action_xinitial=0;
        action_xfinal =0;
        action_yinitial=0;
        swipedRight =false;

        for(int cnt=0;cnt<20;cnt++) {
            arrayString[cnt]="BoomTown";
        }
        arrayAdapter=new ArrayAdapter<String>( this,R.layout.swipe_item,R.id.lbl_swipeItem1, arrayString);
        swipeAdapter=new SwipeAdapter(this,R.layout.swipe_item,R.id.lbl_swipeItem1, arrayString);
        //View footer= View.inflate(this, R.layout.property_block_item, null);
        //listView.addFooterView(footer);
        listView.setAdapter(swipeAdapter);








    }//end on create



}
