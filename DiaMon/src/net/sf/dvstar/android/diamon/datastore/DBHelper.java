package net.sf.dvstar.android.diamon.datastore;

import java.io.File;
import java.io.IOException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	private static final String TAG = "DatabaseHelper";

	private SQLiteDatabase diamondb = null;
	private static final int DATABASE_VERSION = 1;
	private static final String DB_NAME = "diamon.db";
	private static final String TABLE_NAME_PROFILE = "profiles";
	private static final String TABLE_NAME_INSULIN = "insulin";
	
	private static final String TABLE_NAME_HELP_BU = "help_bu_items";
	private static String DB_FULL_PATH = "";
	private static String DB_PATH_CHECK = "";

	public static String KEY_ID = "_id";
	public static String KEY_INSULIN_DESC  = "descript"; 
	public static String KEY_INSULIN_TSTRT = "time_start"; 
	public static String KEY_INSULIN_TEND  = "time_end"; 
	public static String KEY_INSULIN_TMAX  = "time_max"; 
	public static String KEY_INSULIN_TWRK  = "time_work"; 
	public static String KEY_INSULIN_COLOR = "color";
		
	
	
	// public DBHelper(Context context, String name, CursorFactory factory,int
	// version) {
	public DBHelper(Context context) {
		super(context, getDBName(context), null, DATABASE_VERSION);
		DB_FULL_PATH = getDBName(context);
		try {
			this.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		// db = getWritableDatabase();
		openDataBase();
	}

	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * */
	public void createDataBase() throws IOException {
		boolean ret = checkDataBase();
		if (!ret) {
			diamondb = this.getWritableDatabase();
		}
	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			checkDB = SQLiteDatabase.openDatabase(DB_FULL_PATH, null,
					SQLiteDatabase.OPEN_READONLY);
		} catch (SQLiteException e) {
			// database does't exist yet.
		}
		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	public void openDataBase(int mode) throws SQLException {
		try {
			diamondb = SQLiteDatabase.openDatabase(DB_FULL_PATH, null, mode);
		} catch (IllegalStateException e) {
			// Sometimes, esp. after application upgrade, the database will be
			// non-closed, raising a IllegalStateException
			// below. Try to avoid by simply opening it again.
			Log.d(TAG, "Database non-closed. Reopening.");
			diamondb = SQLiteDatabase.openDatabase(DB_FULL_PATH, null, mode);
		}

		if (!checkTable(TABLE_NAME_PROFILE)) {
			diamondb.execSQL("create table " + TABLE_NAME_PROFILE
					+ " (_id integer primary key autoincrement, "
					+ " user_id text not null, " 
					+ " user_name text not null) ");
		}

		if (!checkTable(TABLE_NAME_HELP_BU)) {
			diamondb.execSQL("create table " + TABLE_NAME_HELP_BU
					+ " (_id integer primary key autoincrement, "
					+ " kind_of_item 	NUMERIC, " + " description 	TEXT, "
					+ " measure_bu 		TEXT, " + " measure_wt 		TEXT) ");
		}


		if (!checkTable(TABLE_NAME_INSULIN)) {
			diamondb.execSQL(
					"create table " 
					+ TABLE_NAME_INSULIN
					+ " (_id integer primary key autoincrement, "
					+ " descript		TEXT not null, " 
					+ " time_start 		DECIMAL(2,2), " 
					+ " time_end 		DECIMAL(2,2), " 
					+ " time_max 		DECIMAL(2,2), " 
					+ " time_work 		DECIMAL(2,2), " 
					+ " color			TEXT "
					+ " )"
					);
		}
		
		
	}

	public void openDataBase() throws SQLException {
		openDataBase(SQLiteDatabase.OPEN_READWRITE);
	}

	public SQLiteDatabase getDb() {
		return diamondb;
	}

	@Override
	public synchronized void close() {
		if (diamondb != null)
			diamondb.close();
		super.close();
	}

	private static String getDBName(Context context) {
		DB_FULL_PATH = DB_NAME;
		try {
			DB_PATH_CHECK = Environment.getExternalStorageDirectory().getPath()
					+ "/Android/data/" + context.getPackageName()
					+ "/databases/";
			DB_FULL_PATH = DB_PATH_CHECK + DB_NAME;

			File tryPath = new File(DB_PATH_CHECK);
			if (!tryPath.exists()) {
				tryPath.mkdirs();
			}
		} catch (Exception e) {
		}
		return DB_FULL_PATH;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	private boolean checkTable(String tableName) throws SQLException {
		boolean ret = false;
		try {
			String queryTemplate = "SELECT name, sql FROM sqlite_master WHERE type='table' AND name='%s';";
			String queryToGo = String.format(queryTemplate, tableName);
			Cursor cursor = diamondb.query(tableName, null, null, null, null,
					null, null);
			if (cursor != null) {
				ret = true;
				cursor.close();
			}
		} catch (SQLiteException ex) {
			ret = false;
		}
		return ret;
	}

	/**
	 * The Insert DB statement
	 * 
	 * @param id
	 *            the friends id to insert
	 * @param name
	 *            the friend's name to insert
	 */
	public void insert(String user_id, String user_name) {
		diamondb.execSQL("INSERT INTO friends('user_id', 'user_name') values ('"
				+ user_id + "', '" + user_name + "')");
	}

	/**
	 * Wipe out the DB
	 */
	public void clearAll(String tableName) {
		diamondb.delete(tableName, null, null);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

	
	
    public long insertInsulin(String desc) 
    {
    	return insertInsulin(desc, "0", "0", "0", "0", "#FF00FF");
    }
    public long insertInsulin(String desc, String tstrt, String tend, String tmax, String twrk, String color) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_INSULIN_DESC,  desc);
        initialValues.put(KEY_INSULIN_TSTRT, tstrt);
        initialValues.put(KEY_INSULIN_TEND,  tend);
        initialValues.put(KEY_INSULIN_TMAX,  tmax);
        initialValues.put(KEY_INSULIN_TWRK,  twrk);
        initialValues.put(KEY_INSULIN_COLOR, color);
        
        return diamondb.insert(TABLE_NAME_INSULIN, null, initialValues);
    }

    //---deletes a particular title---
    public boolean deleteInsulin(long rowId) 
    {
        return diamondb.delete(TABLE_NAME_INSULIN, KEY_ID + 
        		"=" + rowId, null) > 0;
    }

    //---retrieves all the titles---
    public Cursor getAlInsulins() 
    {
        return diamondb.query(TABLE_NAME_INSULIN, new String[] {
			KEY_ID, 
			KEY_INSULIN_DESC, 
			KEY_INSULIN_TSTRT,
			KEY_INSULIN_TEND, 
			KEY_INSULIN_TMAX, 
			KEY_INSULIN_TWRK, 
			KEY_INSULIN_COLOR}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }

    //---retrieves a particular title---
    public Cursor getInsulin(long rowId) throws SQLException 
    {
        Cursor mCursor =
        	diamondb.query(true, TABLE_NAME_INSULIN, new String[] {
			KEY_ID, 
			KEY_INSULIN_DESC, 
			KEY_INSULIN_TSTRT,
			KEY_INSULIN_TEND, 
			KEY_INSULIN_TMAX, 
			KEY_INSULIN_TWRK, 
			KEY_INSULIN_COLOR 
                		}, 
                		KEY_ID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

	
	
	
	
}
