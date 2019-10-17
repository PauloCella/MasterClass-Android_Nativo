package com.example.myapplication.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Entity.Item;
import com.example.myapplication.db.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private SQLiteDatabase db;
    Context context = null;

    private ItemDAO() {}

    public ItemDAO(Context context) {
        this.db = DataBaseHelper.getHelper(context).getWritableDatabase();
        this.context = context;
    }

    public void insert(Item item) {
        ContentValues values = mapDtoToContentValues(item);
        db.insert("ITEM", null, values);
    }

    private ContentValues mapDtoToContentValues(Item item){
        ContentValues values = new ContentValues();
        values.put("ID", item.getId());
        values.put("NOME", item.getNome());
        values.put("EMAIL", item.getEmail());

        return values;
    }


    public List<Item> buscar(String nome){
        Cursor cursor = db.query("ITEM", null, null, new String[]{"%" + nome + "%", "%" + nome + "%"}, null, null, null, null);
        List<Item> itens = mapCursorToList(cursor);
        return itens;
    }


    private List<Item> mapCursorToList(Cursor cursor) {
        List<Item> itens = new ArrayList<Item>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Item item = new Item(
                    cursor.getInt(cursor.getColumnIndex("ID")),
                    cursor.getString(cursor.getColumnIndex("NOME")),
                    cursor.getString(cursor.getColumnIndex("EMAIL"))
            );
            itens.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        System.gc();
        return itens;
    }


}
