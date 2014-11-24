package com.example.nihon.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.example.nihon.ChaoHoiFragment;
import com.example.nihon.wordlist.WordListItem;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

	public static final String phrase = "phrase";

	public static String DB_PATH = "/data/data/com.example.nihon/databases/";

	private static String DB_NAME = "learn_japanese1.sqlite";
	private SQLiteDatabase database;
	private final Context mContext;
	public static final String ID = "_id";
	public static final String db_category_id = "category_id";
	public static final String db_english = "english";
	public static final String db_pinyin = "pinyin";
	public static final String db_japanese = "japanese";
	public static final String db_vietnamese = "vietnamese";

	public Database(Context context) {
		super(context, DB_NAME, null, 1);
		this.mContext = context;
	}

	/**
	 * copy database from assets to the device if not existed
	 * 
	 * @return true if not exist and create database success
	 * @throws IOException
	 */
	public boolean isCreatedDatabase() throws IOException {
		// Default là đã có DB
		boolean result = true;
		// Nếu chưa tồn tại DB thì copy từ Asses vào Data
		if (!checkExistDataBase()) {
			this.getReadableDatabase();
			try {
				copyDataBase();
				result = false;
			} catch (Exception e) {
				throw new Error("Error copying database");
			}
		}

		return result;
	}

	/**
	 * check whether database exist on the device?
	 * 
	 * @return true if existed
	 */
	private boolean checkExistDataBase() {

		try {
			String myPath = DB_PATH + DB_NAME;
			File fileDB = new File(myPath);

			if (fileDB.exists()) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * copy database from assets folder to the device
	 * 
	 * @throws IOException
	 */
	private void copyDataBase() throws IOException {
		InputStream myInput = mContext.getAssets().open(DB_NAME);
		OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	/**
	 * delete database file
	 * 
	 * @return
	 */
	public boolean deleteDatabase() {
		File file = new File(DB_PATH + DB_NAME);
		return file.delete();
	}

	/**
	 * open database
	 * 
	 * @throws SQLException
	 */
	public void openDataBase() throws SQLException {
		database = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
				SQLiteDatabase.OPEN_READWRITE);
	}

	public synchronized void close() {
		if (database != null)
			database.close();
		super.close();
	}

	public void onCreate(SQLiteDatabase db) {
		// do nothing
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// do nothing
	}

	public int deleteData_From_Table(String tbName) {

		int result = 0;
		try {
			openDataBase();
			database.beginTransaction();
			result = database.delete(tbName, null, null);
			if (result >= 0) {
				database.setTransactionSuccessful();
			}
		} catch (Exception e) {
			database.endTransaction();
			close();
		} finally {
			database.endTransaction();
			close();
		}

		return result;
	}

	public ArrayList<Object> getAllEmployee() {
		ArrayList<Object> rs = new ArrayList<Object>();

		try {
			// Mở kết nối
			openDataBase();

			String[] columns = { "_id", "english", "pinyin", "japanese",
					"vietnamese" };
			// Truy vấn
			Cursor cursor = database.query(phrase, columns, null, null, null,
					null, null);

			// Đọc từng dòng
			while (cursor.moveToNext()) {
				WordListItem cc = new WordListItem();
				cc.setId(cursor.getInt(0));
				cc.setEnglish(cursor.getString(1));
				cc.setPinyin(cursor.getString(2));
				cc.setJapanese(cursor.getString(3));
				cc.setVietnamese(cursor.getString(4));
				rs.add(cc);
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rs;
	}

	/*
	 * Chen nhân viên vào
	 */

	public ArrayList<Object> getWordById(int id) {
		openDataBase();
		ArrayList<Object> list = new ArrayList<Object>();
		// Select All Query
		String sSQL = "select _id, english, pinyin, japanese,vietnamese from phrase where category_id = "
				+ id;
		Cursor cursor = database.rawQuery(sSQL, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				WordListItem lop = new WordListItem();
				lop.setId(cursor.getInt(0));
				Log.d("//==========", cursor.getString(1));
				lop.setEnglish(cursor.getString(1));
				Log.d("//==========", cursor.getString(2));
				lop.setPinyin(cursor.getString(2));
				lop.setJapanese(cursor.getString(3));
				Log.d("//==========", cursor.getString(3));
//				lop.setVietnamese(cursor.getString(4));
//				Log.d("//==========", cursor.getString(4));
				// Adding Lop to list
				list.add(lop);
			} while (cursor.moveToNext());
		}
		return list;
	}

	public Cursor getWord(String key) {
		Cursor cursor = database.query(phrase, new String[] { db_category_id,
				db_english, db_pinyin, db_pinyin, db_vietnamese }, db_english
				+ " like '%" + key.trim() + "%'", null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}
	
	public long addWord(String key, String meaning) {
		// CREATE A CONTENTVALUE OBJECT
		ContentValues cv = new ContentValues();
		cv.put(phrase,ID);
		cv.put(phrase, db_category_id);
		cv.put(phrase, db_english);
		cv.put(phrase, db_pinyin);
		cv.put(phrase, db_japanese);
		cv.put(phrase, db_vietnamese);
		

		long result = database.insert(phrase, ID,cv);
		
		Log.d("Hello", "insert " + result);
		return result;
	}

		public Cursor getAll(){
		Cursor result = database.query(phrase,
				new String[]{db_category_id, db_english, db_pinyin, db_japanese, db_vietnamese}
				, null, null, null, null, null);
		return result;
	}
}
