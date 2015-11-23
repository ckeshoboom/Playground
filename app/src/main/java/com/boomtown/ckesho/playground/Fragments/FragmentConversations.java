package com.boomtown.ckesho.playground.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.boomtown.ckesho.playground.Adapters.ConvAdapter;
import com.boomtown.ckesho.playground.Models.MessageCreator;
import com.boomtown.ckesho.playground.Models.Message;
import com.boomtown.ckesho.playground.R;

/**
 * Created by ckesho on 11/16/2015.
 */
public class FragmentConversations extends Fragment{

    RecyclerView recycler_conversation;
    ConvAdapter convAdapter;
    Button btn_conv_ok;
    EditText  edit_conv_text_out;
    //RecyclerView.LayoutManager convLayoutManager;
    LinearLayoutManager convLayoutManager;
    long lasttime;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate( R.layout.fragment_conversation_layout, null);

        lasttime=System.currentTimeMillis();

        recycler_conversation= (RecyclerView) view.findViewById(R.id.recycler_conversation);
        edit_conv_text_out= (EditText) view.findViewById(R.id.edit_conv_text_out);
        btn_conv_ok= (Button) view.findViewById(R.id.btn_conv_ok);

        MessageCreator cc= new MessageCreator(10);//creates 10 contacts
        convAdapter=new ConvAdapter(getContext(), cc.getList());

        //********convAdapter.viewtypelist.add("conv_item_text_outgoing");


        /********************
        convLayoutManager= new RecyclerView.LayoutManager() {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return null;
            }
        };
         *****************/

        convLayoutManager= new LinearLayoutManager( getContext(),LinearLayoutManager.VERTICAL,true);
        //convLayoutManager.setStackFromEnd(true);


        recycler_conversation.setAdapter(convAdapter);

        btn_conv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),edit_conv_text_out.getText(),Toast.LENGTH_SHORT).show();
                Message message=new Message();

                /* No longer needed to keep a date. Date now integrated into each view
                Message time=new Message();

                if(3000<System.currentTimeMillis()-lasttime&&System.currentTimeMillis()-lasttime<6000){
                    convAdapter.time="Seconds ago";
                    time.viewitemtype=0;
                    convAdapter.viewtypelist.add(0, time);
                    convAdapter.notifyItemInserted(0);
                    recycler_conversation.scrollToPosition(0);//when dealing with zero position must request scroll
                }
                else if(6000<=System.currentTimeMillis()-lasttime&&System.currentTimeMillis()-lasttime<9000){
                    convAdapter.time="Minutes ago";
                    time.viewitemtype=0;
                    convAdapter.viewtypelist.add(0, time);
                    convAdapter.notifyItemInserted(0);
                    recycler_conversation.scrollToPosition(0);//when dealing with zero position must request scroll
                }
                else if(9000<=System.currentTimeMillis()-lasttime&&System.currentTimeMillis()-lasttime<12000){
                    convAdapter.time="Days ago";
                    time.viewitemtype=0;
                    convAdapter.viewtypelist.add(0, time);
                    convAdapter.notifyItemInserted(0);
                    recycler_conversation.scrollToPosition(0);//when dealing with zero position must request scroll
                }
                else if(12000<=System.currentTimeMillis()-lasttime){
                    convAdapter.time="UTC Date= "+System.currentTimeMillis();
                    time.viewitemtype=0;
                    convAdapter.viewtypelist.add(0, time);
                    convAdapter.notifyItemInserted(0);
                    recycler_conversation.scrollToPosition(0);//when dealing with zero position must request scroll

                }
                //else{}
                */

                message.message=edit_conv_text_out.getText().toString();
                message.viewitemtype=edit_conv_text_out.getText().length();
                convAdapter.viewtypelist.add(0,message);

                /*Each notify gives a different animation effect*/

                //convAdapter.notifyDataSetChanged();//simple refresh not pretty
                //convAdapter.notifyItemInserted(0);//Pretty but does not update to put lastest data on screen
                convAdapter.notifyItemInserted(0);
                recycler_conversation.scrollToPosition(0);//when dealing with zero position must request scroll
                //convAdapter.notifyItemRangeChanged(0,convAdapter.viewtypelist.size());// looks like an overwrite, not harsh but not pretty
                //convAdapter.notifyItemChanged(0);// looks like an overwrite, not harsh but not pretty
                //convAdapter.notifyItemRangeInserted(convAdapter.viewtypelist.size(),1);
                //convAdapter.viewtypelist.add(convAdapter.viewtypelist.size(), edit_conv_text_out.getText().toString());
                //convAdapter.notifyItemInserted(convAdapter.viewtypelist.size());

                lasttime=System.currentTimeMillis();
                edit_conv_text_out.setText("");

            }
        });

        recycler_conversation.setLayoutManager(convLayoutManager);

        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
