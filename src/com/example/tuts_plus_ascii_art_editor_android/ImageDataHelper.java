package com.example.tuts_plus_ascii_art_editor_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class ImageDataHelper extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "asciipics.db";
	
	// This automatically gives us a primary key column that will auto-increment.
	public static final String ID_COL = BaseColumns._ID;
	
	public static final String TABLE_NAME = "pics";
	
	
	 // The table will contain two columns, one for the content of the ASCII 
	 // artwork, which will be a text string, and one for a name, which will appear 
	 // in a list when the user attempts to load saved artworks.
	 
	public static final String ASCII_COL = "ascii_text";
	public static final String CREATED_COL = "pic_creation";

	//Now we can define the database creation string:
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER " +
		    "PRIMARY KEY AUTOINCREMENT, " + ASCII_COL + " TEXT, " + CREATED_COL + " TEXT);";

	// <---- Singleton pattern ---->
	
	private static ImageDataHelper dbInstance;
	private Context dbContext;
	
	private ImageDataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.dbContext = context;
	}
	
	public static ImageDataHelper getInstance(Context context) {
	    if (dbInstance == null)
	        dbInstance = new ImageDataHelper(context.getApplicationContext());
	    return dbInstance;
	}
	
	public void onCreate(SQLiteDatabase db) {
	    db.execSQL(DATABASE_CREATE);
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    db.execSQL("DROP TABLE IF EXISTS pics");
	    db.execSQL("VACUUM");
	    onCreate(db);
	}
	
}