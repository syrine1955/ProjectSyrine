package com.example.projectsyrine.hundlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projectsyrine.Entites.Client;

import java.util.ArrayList;

public class ClientDBHundler extends SQLiteOpenHelper{

    private static final String DB_NAME = "ProjectSyrine.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Client";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "nom";
    private static final String ADDRESS_COL = "adresse";
    private static final String TEL_COL = "tel";
    private static final String FAX_COL = "fax";
    private static final String CONTACT_COL = "contact";
    private static final String TEL_CONT_COL = "tel_Contact";

    public ClientDBHundler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + TEL_COL + " INTEGER,"
                + FAX_COL + " INTEGER,"
                + CONTACT_COL + " TEXT,"
                + TEL_CONT_COL + " INTEGER)";
        db.execSQL(query);
    }

    public ArrayList<Client> readClients() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Client> clientArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                clientArrayList.add(new Client(cursor.getInt(0)
                        ,cursor.getString(1)
                        ,cursor.getString(2)
                        ,cursor.getInt(3)
                        ,cursor.getInt(4)
                        ,cursor.getString(5)
                        ,cursor.getInt(6)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return clientArrayList;
    }

    public void ajoutClient(String nom, String adresse, int tel, int fax,String contact, int tel_Contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, nom);
        values.put(ADDRESS_COL, adresse);
        values.put(TEL_COL, tel);
        values.put(FAX_COL, fax);
        values.put(CONTACT_COL, contact);
        values.put(TEL_CONT_COL, tel_Contact);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void modClient(String originalClientId,String nom, String adresse, int tel, int fax,String contact, int tel_Contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, nom);
        values.put(ADDRESS_COL, adresse);
        values.put(TEL_COL, tel);
        values.put(FAX_COL, fax);
        values.put(CONTACT_COL, contact);
        values.put(TEL_CONT_COL, tel_Contact);
        db.update(TABLE_NAME, values, "id=?", new String[]{originalClientId});
        db.close();
    }

    public void deleteClient(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{id});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
