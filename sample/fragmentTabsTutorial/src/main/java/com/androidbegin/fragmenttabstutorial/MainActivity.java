package com.androidbegin.fragmenttabstutorial;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {
	// Declare Tab Variable
	ActionBar.Tab Tab1, Tab2, Tab3;
	Fragment fragmentTab1 = new FragmentTab1();
	Fragment fragmentTab2 = new FragmentTab2();
	Fragment fragmentTab3 = new FragmentTab3();
	private ArrayAdapter<String> adapter;
	private ArrayList<String> arrayList;
	static SimpleArrayMap samr;
	static SimpleArrayMap samg;
	static String n;

	MySQLiteHelper mDbHelper = new MySQLiteHelper(this);
	public void onStop()
	{
		super.onStop();
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
//get a list of installed apps.
		db.delete(MySQLiteHelper.TABLE_COMMENTS, null, null);
		//db.execSQL(MySQLiteHelper.DATABASE_CREATE);
		for (int i=0; i<MainActivity.samg.size();i++) {
			ContentValues values = new ContentValues();
			values.put(MySQLiteHelper.COLUMN_ID, samg.keyAt(i).toString());
			values.put(MySQLiteHelper.COLUMN_COMMENT, samg.get(samg.keyAt(i)).toString());
			db.insert(
					MySQLiteHelper.TABLE_COMMENTS,
					null,
					values);

		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();

		// Hide Actionbar Icon
		actionBar.setDisplayShowHomeEnabled(false);

		// Hide Actionbar Title
		actionBar.setDisplayShowTitleEnabled(false);

		// Create Actionbar Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		samr=new SimpleArrayMap();
		samg=new SimpleArrayMap();
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		/*n = sharedPreferences.getString("storedName", "");

		if (n.equals(""))
		{
			//getListwI();
			savePreferences("storedName","done");
		}
		else
		{*/
		readList();

			//getApp();

		//}
		//savePreferences("lastUpdateTime", "" + System.currentTimeMillis());
		// Set Tab Icon and Titles
		Tab1 = actionBar.newTab().setText("Installed");
		Tab2 = actionBar.newTab().setText("Uninstalled");
		Tab3 = actionBar.newTab().setText("Updated");

		// Set Tab Listeners
		Tab1.setTabListener(new TabListener(fragmentTab1));
		Tab2.setTabListener(new TabListener(fragmentTab2));
		Tab3.setTabListener(new TabListener(fragmentTab3));

		// Add tabs to actionbar
		actionBar.addTab(Tab1);
		actionBar.addTab(Tab2);
		actionBar.addTab(Tab3);

	}
	private void readList() {
		SQLiteDatabase db = mDbHelper.getReadableDatabase();
		Cursor cursor = db.query(MySQLiteHelper.TABLE_COMMENTS,
				null, null, null, null, null, null);
		System.out.println("Getting into method");


		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			System.out.println("Getting into while loop");
			String pId = cursor.getString(0);
			String pU=cursor.getString(1);
			Log.d("com.test", "Name: " + pId + " Updated: " + pU);
			cursor.moveToNext();
			samr.put(pId, pU);

		}
		// make sure to close the cursor
		cursor.close();
	}

	private void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
}
