package com.preethampm.bankingapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.preethampm.bankingapplication.database.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {
    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table

        db.execSQL("insert into " + TABLE_NAME + " values(5563,'Kishan', 'kishan@gmail.com','2332','8475432152', 14000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7021,'Manoj', 'manoj@gmail.com','2325','8416489744', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6459,'Mohit', 'mohit@gmail.com','3562','7251589475', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9554,'Goutham', 'goutham@gmail.com','2162','9356974568', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3469,'Santhosh', 'santhu@gmail.com','5556','9564123878', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5411,'Googly', 'googly@gmail.com','5564','6361573889', 3300)");
        db.execSQL("insert into " + TABLE_NAME + " values(9431,'Kaustub', 'kaustub@gmail.com','9868','8143896104', 2200)");
        db.execSQL("insert into " + TABLE_NAME + " values(1012,'Shridhar', 'shridhar@gmail.com','5677','9568538999', 7800)");
        db.execSQL("insert into " + TABLE_NAME + " values(6879,'Sanjay', 'sanjay@gmail.com','6693','8594755465', 5700)");
        db.execSQL("insert into " + TABLE_NAME + " values(7464,'Rohini', 'rohini@gmail.com','4505','6969694552', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3567,'Rahul', 'rahul@gmail.com','2362','7254642205', 3300)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
