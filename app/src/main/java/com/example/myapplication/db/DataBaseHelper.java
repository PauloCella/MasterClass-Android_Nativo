package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class DataBaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "myApplication.db";
	private static int databaseVersion = 3;
	private Context context;
	private static DataBaseHelper instance;

	public static synchronized DataBaseHelper getHelper(Context context) {
		if (instance == null)
			instance = new DataBaseHelper(context, databaseVersion);
		return instance;
	}

	public DataBaseHelper(Context context, int databaseVersion) {
		super(context, DATABASE_NAME, null, databaseVersion);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String scriptCreate = " CREATE TABLE ITEM ( " +
				" ID INTEGER NOT NULL , " +
				" NOME TEXT , " +
				" EMAIL TEXT , " +
				" PRIMARY KEY ( ID ) ) ";

		String[] instrucoes = scriptCreate.split(";");
		for (int i = 0; i < instrucoes.length; i++) {
			if (instrucoes[i] != null && !instrucoes[i].trim().equals("")) {
				db.execSQL(instrucoes[i]);
			}
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table ITEM");

		this.onCreate(db);
	}
}