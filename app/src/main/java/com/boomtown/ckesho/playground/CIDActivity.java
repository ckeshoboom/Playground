package com.boomtown.ckesho.playground;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CIDActivity extends AppCompatActivity {

    //String incomingCall;
    TextView lbl_incomingCall, lbl_phoneState, lbl_networktype, lbl_networkstate;
    int laststate, currentstate;
    Button btn_startCID;
    Button btn_endCID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cid_layout);
        laststate=0; currentstate=0;
        lbl_incomingCall= (TextView) findViewById(R.id.lbl_incomingCall);
        lbl_phoneState= (TextView) findViewById(R.id.lbl_phoneState);
        lbl_networkstate= (TextView) findViewById(R.id.lbl_networkstate);
        lbl_networktype= (TextView) findViewById(R.id.lbl_networktype);
        btn_startCID=(Button) findViewById(R.id.btn_startCID);
        btn_endCID=(Button) findViewById(R.id.btn_endCID);


/*
        TelephonyManager telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_DATA_ACTIVITY|
                        PhoneStateListener.LISTEN_CALL_STATE|
                        PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
*/


        btn_startCID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create and start intent service
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), CIDService.class);
                startService(intent);
            }
        });

        btn_endCID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create and start intent service
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), CIDService.class);

                stopService(intent);
            }
        });



    }//end oncreate





    PhoneStateListener phoneStateListener = new PhoneStateListener(){
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            //The beef
            lbl_incomingCall.setText("incoming #= " + incomingNumber);
            lbl_phoneState.setText("State= "+state);
            laststate=currentstate;
            currentstate=state;
            if(currentstate==0 && laststate==2){
                CharSequence text = "Call ended";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        }

        @Override
        public void onDataConnectionStateChanged(int state, int networkType) {
            super.onDataConnectionStateChanged(state, networkType);
            lbl_networktype.setText("Network Type= "+networkType);
            lbl_networkstate.setText("State= "+state);
        }

        @Override
        public void onDataActivity(int direction) {
            super.onDataActivity(direction);
            lbl_networkstate.setText("Data Direction= "+direction);
        }
    };




}
