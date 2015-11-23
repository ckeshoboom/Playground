package com.boomtown.ckesho.playground.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.boomtown.ckesho.playground.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ckesho on 10/26/2015.
 */
public class FeedAdapter extends ArrayAdapter<String> {


        List<String> items;
        Context context;
        int action_xinitial, action_xfinal, action_yinitial;
        boolean swipedRight,swipedLeft, alreadySwiped;
        //caches the various views within each row
        static class ViewHolder {
            //Resources being binded by Butterknife



            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            public ViewHolder(View view){
                ButterKnife.bind(this, view);
            }


        }


        //public SwipeAdapter(Context context, int resource, List<String> items) {
        public FeedAdapter(Context context, int resource, int textview, String[] objects) {
            super(context, resource, textview, objects);
            //this.items = items;
            this.context=context;
            swipedLeft=false;
            swipedRight=false;
            alreadySwiped=false;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            //It will have a non-null value when ListView is asking you recycle the row layout.
            //So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
            if (convertView==null ||convertView!=null) {
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                if (position==0 ||position==5){
                convertView = inflater.inflate(R.layout.feed_item_newbuyer, null);}

                else if (position==1 ||position==6 ){
                    convertView = inflater.inflate(R.layout.feed_item_newhighinterest, null);}

                else if (position==2 ||position==7 ){
                    convertView = inflater.inflate(R.layout.feed_item_newtodo, null);}

                else {
                    convertView = inflater.inflate(R.layout.feed_item_newtext, null);
                }




                //save the view within the holder for binding
                holder = new ViewHolder(convertView);

                //save the holder within the view Tag for referencing
                convertView.setTag(holder);



            }
            else {
                //this is used to avoid unneccessary findViewById() calls - saves resources
                holder = (ViewHolder) convertView.getTag();
            }





//**********************************




            return convertView;
        }


        public void help_press_animation(View btn){

            Animation pressanimation= AnimationUtils.loadAnimation(getContext(), R.anim.press_animation);
            btn.startAnimation(pressanimation);
            btn.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);

        }

        public void swipe_animation (View view, Boolean direction){

            Animation swipe=AnimationUtils.makeInAnimation(getContext(), direction);
            view.startAnimation(swipe);

        }



    }

