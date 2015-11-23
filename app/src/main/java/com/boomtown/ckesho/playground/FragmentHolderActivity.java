package com.boomtown.ckesho.playground;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.*;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.boomtown.ckesho.playground.Fragments.FragmentConversations;


/**
 * Created by ckesho on 11/16/2015.
 */
public class FragmentHolderActivity extends AppCompatActivity {


    FragmentTransaction fragTrans;
    FragmentManager fragMan;
    ImageButton btn_fragment_holder_1;
    FragmentConversations fragmentConv;

    public FragmentHolderActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_holder_layout);

        fragMan=getSupportFragmentManager();
        fragTrans=fragMan.beginTransaction();

        btn_fragment_holder_1=(ImageButton) findViewById(R.id.btn_fragment_holder_1);
        btn_fragment_holder_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fill here
                Toast.makeText(getApplicationContext(), "btn_fragment_holder_1", Toast.LENGTH_SHORT).show();
                fragmentConv=new FragmentConversations();
                fragTrans.replace( R.id.fl_holder, fragmentConv).commit();
            }
        });
    }
}
