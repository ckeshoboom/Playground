package com.boomtown.ckesho.playground;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;


public class PhoneBroadcastReceiver extends BroadcastReceiver {
    public PhoneBroadcastReceiver() {
    }

    //values
    int laststate, currentstate;
    Context onRecContext;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving


        // make contect avaliable outside function.
        onRecContext=context;

        //Troubleshooting code
        Log.i("playground", "!Broadcast is working! intent details" + intent.toString());
        if(intent.hasExtra(Intent.EXTRA_PHONE_NUMBER)){
            Log.i("playground", "Intent.EXTRA_PHONE_NUMBER= " + intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER));
        }
        Toast toast = Toast.makeText(context, "playground receiving broadcast", Toast.LENGTH_LONG);
        toast.show();


        //Access telephonyManager and request to listen in on events
        TelephonyManager telephonyManager=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneStateListener,
                PhoneStateListener.LISTEN_DATA_ACTIVITY |
                        PhoneStateListener.LISTEN_CALL_STATE |
                        PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);


        //throw new UnsupportedOperationException("Not yet implemented");
    }




    //define phone listener
    PhoneStateListener phoneStateListener = new PhoneStateListener(){
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);


            //Make sure there is a value in current state first
            if(currentstate==0||currentstate==1||currentstate==2){
            laststate=currentstate;}

            //add the new value to current state
            currentstate=state;


            //values
            CharSequence text = "BR incomingNumber= ";
            String incoming="incomingNumber";
            int duration = Toast.LENGTH_LONG;


            //Check the current state and last state to see whether a call has ended
            //**********add && incomingNumber!=null to verify its an incoming call has ended*********************
            if(currentstate==0 && laststate==2 ){
                Toast toast = Toast.makeText(onRecContext, text+incomingNumber, duration);
                toast.show();

                //Create pending intent and start activity
                Intent cIDActivityIntent = new Intent(onRecContext, CIDActivity.class);
                //put number in string and send it with intent to activity
                cIDActivityIntent.putExtra(incoming, incomingNumber);
                //Learn how to make this a pending intent instead
                //cIDActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //onRecContext.startActivity(cIDActivityIntent);

                PendingIntent pendingIntent= PendingIntent.getActivity(onRecContext, 0, cIDActivityIntent, PendingIntent.FLAG_ONE_SHOT);
                //pendingIntent.send(8003,null, null);
                AlarmManager am=(AlarmManager)onRecContext.getSystemService(Context.ALARM_SERVICE);
                am.set( AlarmManager.ELAPSED_REALTIME,0 /*System.currentTimeMillis()*/, pendingIntent);


            }


            //Know whats going on for troubleshooting
            else{
                Toast toast = Toast.makeText(onRecContext.getApplicationContext(), "BR state change notice", Toast.LENGTH_LONG);
                toast.show();
            }

            //additional troubleshooting
            Log.i("playground","incomingNumber= "+incomingNumber+" BR State is= "+state);
        }


        //These overrides could be of future value for troubleshooting and new features
        @Override
        public void onDataConnectionStateChanged(int state, int networkType) {
            super.onDataConnectionStateChanged(state, networkType);
            Log.i("playground","networktype= "+networkType+" BR State is= "+state);
        }

        @Override
        public void onDataActivity(int direction) {
            super.onDataActivity(direction);
            Log.i("playground", "data direction= " + direction);

        }
    };//********end of definition*************


}
