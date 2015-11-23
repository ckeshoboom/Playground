package com.boomtown.ckesho.playground.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boomtown.ckesho.playground.Models.Message;
import com.boomtown.ckesho.playground.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ckesho on 11/16/2015.
 */
public class ConvAdapter extends RecyclerView.Adapter{
    public ArrayList<Message> viewtypelist;
    Context context;
    int viewitemtype;
    public String time;

    public static class ViewHolder0 extends RecyclerView.ViewHolder{
        public ViewHolder0(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            //ButterKnife.bind(this, itemView);
        }




        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder{
        public ViewHolder1(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        //@Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        @Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder{
        public ViewHolder2(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        //@Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        @Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder{
        public ViewHolder3(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
           ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        @Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        //@Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder4 extends RecyclerView.ViewHolder{
        public ViewHolder4(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        @Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        //@Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder5 extends RecyclerView.ViewHolder {
        public ViewHolder5(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind( this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        @Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        //@Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder6 extends RecyclerView.ViewHolder{
        public ViewHolder6(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        @Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        //@Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder7 extends RecyclerView.ViewHolder{
        public ViewHolder7(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        @Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        //@Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }

    public static class ViewHolder8 extends RecyclerView.ViewHolder{
        public ViewHolder8(View itemView) {
            super(itemView);

            //View parameter in constructor enable butterknife to bind
            //to corresponding view
            ButterKnife.bind(this, itemView);
        }
        @Bind(R.id.rl_conv_item_date_visible) RelativeLayout rl_conv_item_date_visible;
        @Bind(R.id.tv_conv_item_date) TextView tv_conv_item_date;
        @Bind(R.id.tv_conv_item_timestamp) TextView tv_conv_item_timestamp;
        @Bind(R.id.tv_conv_item_identification) TextView tv_conv_item_identification;
        @Bind(R.id.tv_conv_item_message) TextView tv_conv_item_message;
        //@Bind(R.id.tv_conv_item_action) TextView tv_conv_item_action;
    }



    //constructor
    public ConvAdapter(Context context,ArrayList<Message> list) {
        super();
        this.context=context;
        viewtypelist=new ArrayList<Message>();
        if(list!=null){
            viewtypelist=list;
        }
        viewitemtype=0;
        time="Seconds ago";
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        RecyclerView.ViewHolder vh;

        switch (viewType){
            /*
            case (0):
                 view=View.inflate(context, R.layout.conv_item_date,null);
                    TextView tv=(TextView)view.findViewById(R.id.tv_conv_item_date);

                    tv.setText((time));
                 vh=new ViewHolder0(view);
                //break;
                return vh;
             */
            case (1):
                 view=View.inflate(context, R.layout.conv_item_call_attempt,null);
                 vh=new ViewHolder1(view);
                return vh;
            case (2):
                 view=View.inflate(context, R.layout.conv_item_call_missed,null);
                 vh=new ViewHolder2(view);
                return vh;
            case (3):
                view=View.inflate(context, R.layout.conv_item_call_logged,null);
                vh=new ViewHolder3(view);
                return vh;
            case (4):
                view=View.inflate(context, R.layout.conv_item_call_received,null);
                vh=new ViewHolder4(view);
                return vh;
            case (5):
                 view=View.inflate(context, R.layout.conv_item_text_outgoing,null);
                 vh=new ViewHolder5(view);
                return vh;
            case (6):
                 view=View.inflate(context, R.layout.conv_item_text_incoming,null);
                 vh=new ViewHolder6(view);
                return vh;
            case (7):
                 view=View.inflate(context, R.layout.conv_item_email_outgoing,null);
                 vh=new ViewHolder7(view);
                return vh;
            case (8):
                 view=View.inflate(context, R.layout.conv_item_email_incoming,null);
                 //vh=new ViewHolder8(view);
                ViewHolder8 vh8= new ViewHolder8(view);
                return vh8;

        }

        //View view=View.inflate(context, R.layout.conv_item_call_missed,null);
        //RecyclerView.ViewHolder vh=new ViewHolder0(view);
        //return vh;
        /*If there is no view type match convert view to type 5 and send off*/
        viewType=5;
        return new ViewHolder5(View.inflate(context, R.layout.conv_item_text_outgoing,null));
    }

    @Override
    public int getItemCount() {
        return viewtypelist.size();
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ) {

        if(holder.getItemViewType()==1) {

            ((ViewHolder1) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder1) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);


            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder1) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }

        }
        else if(holder.getItemViewType()==2) {


            /*3 methods for accessing vales within the holder that work*/
            //Method 1
            ViewHolder2 vh2 = (ViewHolder2) holder;
            vh2.tv_conv_item_identification.setText(viewtypelist.get(position).identification);
            //Method 2
            TextView tv = (TextView) holder.itemView.findViewById(R.id.tv_conv_item_timestamp);
            tv.setText("Tick tock");
            //Method 3
            ((ViewHolder2) holder).tv_conv_item_action.setText("hi! my name is, what? my name is, who?! My name is Slim Shady");

            //Method 3 is preferred
            ((ViewHolder2) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder2) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);

            //Changing the date to test the time
            GregorianCalendar calendar=new GregorianCalendar(2015,11,19,10,10);
            viewtypelist.get(position).date=calendar.getTime();
            ((ViewHolder2) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));


            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder2) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }

        else if(holder.getItemViewType()==3) {

            ((ViewHolder3) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder3) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder3) holder).tv_conv_item_message.setText(viewtypelist.get(position).message);

            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder3) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }

        else if(holder.getItemViewType()==4) {
            ViewHolder4 vh4 = (ViewHolder4) holder;
            vh4.tv_conv_item_identification.setText(viewtypelist.get(position).identification);
            TextView tv = (TextView) holder.itemView.findViewById(R.id.tv_conv_item_timestamp);
            tv.setText("10:10 PM");

            ((ViewHolder4) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder4) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder4) holder).tv_conv_item_message.setText("Where you been? Did you get my message?");


            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder4) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }

        else if(holder.getItemViewType()==5) {

            ((ViewHolder5) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder5) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder5) holder).tv_conv_item_message.setText(viewtypelist.get(position).message);


            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder5) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }
        else if(holder.getItemViewType()==6) {

            ((ViewHolder6) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder6) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder6) holder).tv_conv_item_message.setText(viewtypelist.get(position).message);


            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder6) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }
        else if(holder.getItemViewType()==7) {

            ((ViewHolder7) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder7) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder7) holder).tv_conv_item_message.setText(viewtypelist.get(position).message);

            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder7) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }
        else if(holder.getItemViewType()==8) {

            ((ViewHolder8) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder8) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder8) holder).tv_conv_item_message.setText("hi! my name is, what? my name is, who?! My name is Slim Shady");

            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder8) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }
        else /*the viewType is by default 5*/ {

            ((ViewHolder5) holder).tv_conv_item_date.setText(DateFormat.getDateInstance().format(viewtypelist.get(position).date));
            ((ViewHolder5) holder).tv_conv_item_timestamp.setText(viewtypelist.get(position).timestamp);
            ((ViewHolder5) holder).tv_conv_item_message.setText(viewtypelist.get(position).message);


            try {
                //if(position-1.date ==position.date&&position-1.date!=null){rl_date=GONE}

                if (viewtypelist.get(position+1) != null &&
                        DateFormat.getDateInstance().format(viewtypelist.get(position + 1).date).contentEquals(DateFormat.getDateInstance().format(viewtypelist.get(position).date))) {
                    ((ViewHolder5) holder).rl_conv_item_date_visible.setVisibility(View.GONE);
                }//viewtypelist.get(position-1).date==viewtypelist.get(position).date.)

            }
            catch ( Exception e){
                Log.i("playground", e.getMessage());
            }
        }



    }

    @Override
    public int getItemViewType(int position) {
        viewitemtype=5;
        /*
       0= conversation item: DATE
       1= conversation item: CALL MESSAGE ATTEMPT
       2= conversation item: CALL MESSAGE MISSED
       3= conversation item: CALL MESSAGE LOGGED
       4= conversation item: CALL MESSAGE RECIEVED
       5= conversation item: TEXT MESSAGE OUT
       6= conversation item: TEXT MESSAGE IN
       7= conversation item: EMAIL MESSAGE OUT
       8= conversation item: EMAIL MESSAGE IN
        */
        //return super.getItemViewType(position);
        return viewtypelist.get(position).viewitemtype;

    }
}
