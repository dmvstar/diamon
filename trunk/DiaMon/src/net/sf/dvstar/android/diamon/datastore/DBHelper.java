package net.sf.dvstar.android.diamon.datastore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "diamod.db";
    private static final String TABLE_NAME = "profiles";
	
	//public DBHelper(Context context, String name, CursorFactory factory,int version) {
	public DBHelper(Context context){
		super(context, DB_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();	
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_NAME + " (_id integer primary key autoincrement, " +
                " user_id text not null, user_name text not null) ");
	}

    /**
     * The Insert DB statement
     * @param id the friends id to insert
     * @param name the friend's name to insert
     */
    public void insert(String user_id, String user_name) {
        db.execSQL("INSERT INTO friends('user_id', 'user_name') values ('"
                + user_id + "', '"
                + user_name + "')");
    }

    /**
     * Wipe out the DB
     */
    public void clearAll() {
        db.delete(TABLE_NAME, null, null);
    }

    /**
     * Select All the returns a Cursor
     * @return the cursor for the DB selection
     */
    public Cursor cursorSelectAll() {
        Cursor cursor = this.db.query(
                TABLE_NAME, // Table Name
                new String[] { "user_id", "user_name" }, // Columns to return
                null,       // SQL WHERE
                null,       // Selection Args
                null,       // SQL GROUP BY
                null,       // SQL HAVING
                "name");    // SQL ORDER BY
        return cursor;
    }

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

}
