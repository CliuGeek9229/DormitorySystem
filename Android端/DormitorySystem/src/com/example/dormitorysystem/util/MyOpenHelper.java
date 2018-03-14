package com.example.dormitorysystem.util;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {
	private final String Psql = "create table if not exists userInfo" +
			"(_id integer primary key AUTOINCREMENT," +
			"username varchar(20),pwd varchar(20)," +
			"realname varchar(20),sex varchar(10)," +
			"school varchar(20),profession varchar(20))";
	
	private  final String Asql = "create table if not exists actionInfo" +
			"(_id integer primary key AUTOINCREMENT," +
			"manager varchar(20),title varchar(30)," +
			"time varchar(20),locate varchar(20)," +
			"username varchar(20),data varchar(20)," +
			"state varchar(20),detail text)";
	

	public MyOpenHelper(Context context) {
		super(context, "cooventure_db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Asql);
		db.execSQL(Psql);
		Log.v("ruichuang", "创建成功！");

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
