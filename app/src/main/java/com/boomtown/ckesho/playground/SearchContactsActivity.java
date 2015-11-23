package com.boomtown.ckesho.playground;

import android.app.LoaderManager;
import android.support.v4.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
//import android.support.v4.content.CursorLoader;
import android.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class SearchContactsActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor>{

int count, colcount;
    CursorLoader cursorLoader;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eavesdrop_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
count=0;
        colcount=0;


         cursorLoader =new CursorLoader(this);
        ContactsContract contactsContract;
        //Cursor cursor=ContactsContract.Contacts.;
        // Initializes the cursorLoader
        getLoaderManager().initLoader(0, null, this);
        getLoaderManager().initLoader(1, null, this);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.moveToPosition(count);
                //cursor.getCount()
                Snackbar.make(view, cursor.getColumnName(colcount)+ "=="+cursor.getString(colcount)+"Count is =" +colcount, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               // Log.i("playground", cursor.toString());
               // Log.i("playground", cursor.getString(0));
                //Log.i("playground", cursor.getColumnName(count)+"Count is =" +count);
                //Log.i("playground", cursor.getString(count));

                count++;
                colcount++;
                if (colcount>=cursor.getColumnCount()){colcount=0;}
                if (count>=cursor.getCount()){
                    count=0;
                }
            }
        });

    }


    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {

    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        //Log.i("playground", data.toString());
        //Log.i("playground", data.getString(0));
        Log.i("playground", "data.moveToFirst() == " + data.moveToFirst());
        //data.moveToFirst();
        Log.i("playground", "data.getCount()" +data.getCount());
        cursor=data;
    }

    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
         /*
         * Makes search string into pattern and
         * stores it in the selection array
         */
        //if(id==1){}
        //if(id==0){}

    String[] mSelectionArgs={"%am%"};
        String[] search= new String[1];
        search[0]="am";

    // Starts the query


        return new CursorLoader(
                this,//getActivity(),//Context
                ContactsContract.Contacts.CONTENT_URI, //uri
                null,//PROJECTION,//projection is string[]
                ContactsContract.Contacts.DISPLAY_NAME + " LIKE ?", //null, //SELECTION, // string
                mSelectionArgs,// string[]// this argument(s) replaces the question mark in SELECTION
                null//sort order
        );
    }



   /*
        * Note on querying contentproviders
        * Query the given URI, returning a Cursor over the result set.

For best performance, the caller should follow these guidelines:

Provide an explicit projection, to prevent reading data from storage that aren't going to be used.
Use question mark parameter markers such as 'phone=?' instead of explicit values in the selection parameter, so that queries that differ only by those values will be recognized as the same for caching purposes.
Parameters
uri	The URI, using the content:// scheme, for the content to retrieve.
projection	A list of which columns to return. Passing null will return all columns, which is inefficient.
selection	A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given URI.
selectionArgs	You may include ?s in selection, which will be replaced by the values from selectionArgs, in the order that they appear in the selection. The values will be bound as Strings.
sortOrder	How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
Returns
A Cursor object, which is positioned before the first entry, or null

    }*/

    /*
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        //only necessary if you are using an adapter and list view
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.i("playground", data.toString());
        Log.i("playground", data.getString(0));
        Log.i("playground", data.getColumnName(0));
        cursor=data;
    }
    */
}
