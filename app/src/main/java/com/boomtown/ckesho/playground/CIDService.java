package com.boomtown.ckesho.playground;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class CIDService extends Service {
    public CIDService() {
    }



    int laststate,currentstate;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();


        currentstate=0; laststate=0;
        HandlerThread handlerThread;
        handlerThread=new HandlerThread("ned");
        handlerThread.start();


        Toast.makeText(getApplicationContext(), "Servicestarted", Toast.LENGTH_LONG)
                .show();

        Handler handler;

        handler=new Handler(handlerThread.getLooper());
        final Runnable runnable= new Runnable() {
            @Override
            public void run() {
                Log.i("playground", "Run executed by runnable");
                Toast.makeText(getApplicationContext(), "thread running", Toast.LENGTH_LONG)
                        .show();




                //define phone listener See broadcast receiver for cleanest code
                PhoneStateListener phoneStateListener = new PhoneStateListener(){
                    @Override
                    public void onCallStateChanged(int state, String incomingNumber) {
                        super.onCallStateChanged(state, incomingNumber);
                        laststate=currentstate;
                        String incoming="incomingNumber";
                        currentstate=state;
                        //add && incomingNumber!=null for incoming calls
                        if(currentstate==0 && laststate==2){
                            CharSequence text = "Call ended";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(getApplicationContext(), incomingNumber, duration);
                            toast.show();

                            Intent cIDActivityIntent = new Intent(getBaseContext(), CIDActivity.class);
                            //put number in string and send it with intent to activity
                            cIDActivityIntent.putExtra(incoming, incomingNumber);

                            cIDActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(cIDActivityIntent);

                        }
                        else{Toast toast = Toast.makeText(getApplicationContext(), "state change notice", Toast.LENGTH_LONG);
                        toast.show();}
                        Log.i(incoming,incomingNumber+" State is= "+state);
                    }

                    @Override
                    public void onDataConnectionStateChanged(int state, int networkType) {
                        super.onDataConnectionStateChanged(state, networkType);
                        //lbl_networktype.setText("Network Type= "+networkType);
                        //lbl_networkstate.setText("State= "+state);
                    }

                    @Override
                    public void onDataActivity(int direction) {
                        super.onDataActivity(direction);
                        //lbl_networkstate.setText("Data Direction= "+direction);
                    }
                };

                //********end of definition*************

                TelephonyManager telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                telephonyManager.listen(phoneStateListener,
                        PhoneStateListener.LISTEN_DATA_ACTIVITY |
                                PhoneStateListener.LISTEN_CALL_STATE |
                                PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

            }
        };

        handler.post(runnable);



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}

