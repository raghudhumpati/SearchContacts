package com.example.android.searchcontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by ANDROID on 6/10/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME="contactslist";
    public static final String COL_1="name";
    public static final String COL_2="phoneno";


    public DBHelper(Context context) {
        super(context, "totalcontacts.db", null, 1);
        SQLiteDatabase mydb=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table"+TABLE_NAME+"("+COL_1 +"text,"+COL_2+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void addcontact(String Name,String Phoneno)
    {

        SQLiteDatabase mydb=this.getWritableDatabase();

        ContentValues cvalues=new ContentValues();

        cvalues.put(COL_1,Name);
        cvalues.put(COL_2,Phoneno);

       mydb.insert(TABLE_NAME,null,cvalues);
    }

    public String searchcontact(String Phoneno)
    {
        String sname="NOT FOUND";
        String sphone="";

        SQLiteDatabase mydb=this.getWritableDatabase();

        String myquery="select * from contactslist";

        Cursor result=mydb.rawQuery(myquery,null);

        if(result!=null)
        {
            result.moveToFirst();

        }
        while(result.moveToNext()) {

            sphone = result.getString(1);
            sname = result.getString(0);

            if(Phoneno.equalsIgnoreCase(sname)) {
                break;
            }
        }
        return sphone;
    }
}
