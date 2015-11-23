package com.boomtown.ckesho.playground;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

//import com.android.boomtown.R;


//import butterknife.Bind;
//import butterknife.ButterKnife;


public class LeadProfileActivity extends Activity {

    ImageButton back;
    ListView propertyBlockList;
    RelativeLayout leadProfilePropertyBlock;
    LinearLayout leadProfileShowHide;
    Button leadProfileShowHideButton, btn_leadProfileEmail, btn_leadProfilePhone;
    ArrayAdapter<String> adapter;
    Drawable profilephoto;
    ImageView leadProfileLeadPhotoImage;
    TextView lbl_leadProfileInitials, lbl_leadProfileSource;
    ScrollView leadProfileScrollView;

    //Helper Screen
    RelativeLayout rl_helper_press;
    TextView lbl_helper_1, lbl_helper_2;
    ImageView iv_helper_press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_profile);
        String houses[]={"MLS 2343423","MLS 2323423423", "MLS 232334322","MLS 1222213","MLS 7766634","MLS 19990423"};


        adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.property_block_item, R.id.lbl_propertyBlockMLS,houses);
        propertyBlockList=(ListView) findViewById(R.id.list_leadProfilePropertyBlock);
        leadProfilePropertyBlock=(RelativeLayout) findViewById(R.id.leadProfilePropertyBlock);
        back=(ImageButton) findViewById(R.id.btn_leadProfileBack);
        leadProfileShowHide=(LinearLayout) findViewById(R.id.ll_leadProfileDesc2);
        leadProfileShowHideButton=(Button) findViewById(R.id.leadProfileShowHideButton);
        btn_leadProfileEmail=(Button) findViewById(R.id.btn_leadProfileEmail);
        btn_leadProfilePhone=(Button) findViewById(R.id.btn_leadProfilePhone);
        leadProfileLeadPhotoImage=(ImageView) findViewById(R.id.leadProfileLeadPhotoImage);
        lbl_leadProfileInitials=(TextView)findViewById(R.id.lbl_leadProfileInitials);
        lbl_leadProfileSource=(TextView)findViewById(R.id.lbl_leadProfileSource);
        leadProfileScrollView=(ScrollView)findViewById(R.id.leadProfileScrollView);

        //Helper overlayscreen
        rl_helper_press=(RelativeLayout) findViewById(R.id.rl_helper_press);
        lbl_helper_1=(TextView )findViewById(R.id.lbl_helper_1);
        lbl_helper_2=(TextView )findViewById(R.id.lbl_helper_2);
        iv_helper_press=(ImageView)findViewById(R.id.iv_helper_press);

        propertyBlockList.setAdapter(adapter);

        Uri uri= Uri.parse("http://labs.sogeti.com/wp-content/uploads/2014/03/cloud.jpg").buildUpon().build();


        leadProfileLeadPhotoImage.setImageURI(uri);
        leadProfileLeadPhotoImage.setVisibility(View.INVISIBLE);
        lbl_leadProfileInitials.setVisibility(View.VISIBLE);


        btn_leadProfileEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abr@gmail.com", null));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"joeblow@boomtownroi.com"});
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(Intent.createChooser(intent, "Send email using..."));
                } catch (Exception e) {
                    //Log. exception
                    //toast message
                }
            }
        });

        btn_leadProfilePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.putExtra(Intent.EXTRA_PHONE_NUMBER, "tel:2125551212");
                intent.setData(new Uri.Builder().scheme("tel").authority("3143267050").build());
                startActivity(intent);
            }
        });

        leadProfileShowHideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leadProfileShowHide.getVisibility()==View.GONE){
                    leadProfileShowHide.setVisibility(View.VISIBLE);
                    //leadProfilePropertyBlock.setVisibility(View.GONE);
                }
                else{
                    leadProfileShowHide.setVisibility(View.GONE);
                    //leadProfilePropertyBlock.setVisibility(View.VISIBLE);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //super.onBackPressed();
                onBackPressed();
            }
        });

        lbl_leadProfileInitials.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                lbl_leadProfileInitials.setText("West Ashley, SC");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = new Uri.Builder()
                        .scheme("geo")
                        .encodedPath("0,0")
                        .encodedQuery("q=" + lbl_leadProfileInitials.getText().toString().toLowerCase().replaceAll(" ", "%20"))
                        .build();

                intent.setData(uri);

                //intent.setData(Uri.fromParts("geo", "0,0?q=" + lbl_leadProfileInitials.getText().toString().toLowerCase(), null));
                //Log.i("boom", lbl_leadProfileInitials.getText().toString().toLowerCase().replaceAll(" ", "%20"));
                Log.i("boom", intent.getData().toString());
                startActivity(intent);

                return true;
            }
        });

        lbl_leadProfileInitials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossfadein();

            }
        });


        rl_helper_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossfadeout();
            }
        });

        help_press_animation();
    }//end onCreate

    public void crossfadeout(){
        //lbl_leadProfileInitials.animate().xBy(20).start();
        //Animation fadeanimation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.lp_animation);
        //btn_leadProfilePhone.startAnimation(fadeanimation);

        rl_helper_press.animate().alpha(0).setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //add the meat
                        rl_helper_press.setVisibility(View.GONE);
                    }
                });

        //leadProfilePropertyBlock.setAlpha(0f);
        //leadProfileScrollView.setVisibility(View.VISIBLE);


        leadProfileScrollView.animate().alpha(1).setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //Add the meat here

                    }
                });


    }

    public void crossfadein(){

        rl_helper_press.setVisibility(View.VISIBLE);
        rl_helper_press.animate().alpha(1).setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //add the meat

                    }
                });
        help_press_animation();

    }

    public void help_press_animation(){

        Animation pressanimation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.press_animation);
        iv_helper_press.startAnimation(pressanimation);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lead_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
