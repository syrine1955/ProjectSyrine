package com.example.projectsyrine.hundlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projectsyrine.Entites.Contrat;

import java.util.ArrayList;

public class ContractDBHundler extends SQLiteOpenHelper {

    private static final String DB_NAME = "ProjectSyrine.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "contrat";
    private static final String ID_COL = "id";
    private static final String reference_COL = "reference";
    private static final String datedebut_COL = "datedebut";
    private static final String datefin_COL = "datefin";
    private static final String redevence_COL = "redevence";
    private static final String idClient_COL = "idClient";

    public ContractDBHundler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + reference_COL + " TEXT,"
                + datedebut_COL + " TEXT,"
                + datefin_COL + " TEXT,"
                + redevence_COL + " INTEGER,"
                + idClient_COL + " INTEGER)";
        db.execSQL(query);
    }

    public ArrayList<Contrat> readContracts() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Contrat> contratArrayList = new ArrayList<Contrat>();
        return contratArrayList;
    }

    public void ajoutContract(String reference, String datedebut, String datefin, double redevence,int idClient) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(reference_COL, reference);
        values.put(datedebut_COL, datedebut);
        values.put(datefin_COL, datefin);
        values.put(redevence_COL, redevence);
        values.put(idClient_COL, idClient);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void modContract(String originalContractId,String reference, String datedebut, String datefin, String redevence,int idClient) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(reference_COL, reference);
        values.put(datedebut_COL, datedebut);
        values.put(datefin_COL, datefin);
        values.put(redevence_COL, redevence);
        values.put(idClient_COL, idClient);
        db.update(TABLE_NAME, values, "id=?", new String[]{originalContractId});
        db.close();
    }

    public void deleteContract(String id) {
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
