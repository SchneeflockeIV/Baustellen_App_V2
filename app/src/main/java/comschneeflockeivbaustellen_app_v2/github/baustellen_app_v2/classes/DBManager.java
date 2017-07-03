package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Daisu_000 on 29.05.2017.
 */

public class DBManager extends SQLiteOpenHelper {

    public static final int DATENBANK_VERSION = 1;
    public static final String DATENBANK_NAMEN = "Baustellen_App.db";

    // Aufbau der Tabelle Event
    // Account Daten
    public static final String TABELLE_ACC = "Account";
    public static final String SPALTE_ACC_ID = "AccID";
    public static final String SPALTE_ACC_BENUTZERNAME = "Benutzername";
    public static final String SPALTE_ACC_GESCHLECHT = "Geschlecht";
    public static final String SPALTE_ACC_GRAD = "Grad";
    public static final String SPALTE_ACC_VORNAME = "Vorname";
    public static final String SPALTE_ACC_NACHNAME = "Nachname";
    public static final String SPALTE_ACC_TELEFONNUMMER = "Telfefonnummer";
    public static final String SPALTE_ACC_PASSWORD = "Password";
    //Baustellen Daten

    //Baustellen Tabele struktorieren
    public static final String TABELLE_BAUSTELLEN = "Baustellen";
    public static final String SPALTE_BAUSTELLEN_ID = "BaustellenID";
    public static final String SPALTE_BAUSTELLEN_NAME = "Baustellenname";
    public static final String SPALTE_BAUSTELLEN_STRASSE = "Strasse";
    public static final String SPALTE_BAUSTELLEN_ORT = "Ort";
    public static final String SPALTE_BAUSTELLEN_PLZ = "Plz";
    public static final String SPALTE_BAUSTELLEN_BAUHERR = "Bauherr";
    public static final String SPALTE_BAUSTELLEN_BILD = "Bild";

    //Material Tabelle
    public static final String TABELLE_MATERIAL = "Material";
    public static final String SPALTE_MATERIAL_ID = "MaterialID";
    public static final String SPALTE_MATERIAL_NAME = "Materialname";
    public static final String SPALTE_MATERIAL_ANZAHL = "Anzahl";
    public static final String SPALTE_MATERIAL_EINZELPREIS = "Einzelpreis";
    public static final String SPALTE_MATERIAL_GESAMTPREIS = "Gesamtpreis";

    public DBManager(Context cxt) {
        super(cxt, DATENBANK_NAMEN, null, DATENBANK_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    //ACC Datenbank methoden

    //Neue Zeile in Acc einfügen
    public boolean insertAcc(Account acc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues neueZeile = new ContentValues();

        neueZeile.put(SPALTE_ACC_BENUTZERNAME, acc.getBenutzerName());
        neueZeile.put(SPALTE_ACC_VORNAME, acc.getVorname());
        neueZeile.put(SPALTE_ACC_NACHNAME, acc.getNachname());
        neueZeile.put(SPALTE_ACC_GRAD, acc.getGrad());
        neueZeile.put(SPALTE_ACC_TELEFONNUMMER, acc.getTelenummer());
        neueZeile.put(SPALTE_ACC_PASSWORD, acc.getPassword());
        neueZeile.put(SPALTE_ACC_GESCHLECHT, acc.getAnrede());

        long result = db.insert(TABELLE_ACC, null, neueZeile);
        if(result == -1) return false;
        else return true;
    }

    //Password ändern wo Benutzername übereinstimmt
    public void setNewPassword(String benutzername, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SPALTE_ACC_PASSWORD, newPassword);
        String where = SPALTE_ACC_BENUTZERNAME + "= '" + benutzername + "'";
        db.update(TABELLE_ACC, values, where, null);
    }


    //Acc selectieren und daten in AccObjekt schreiben
    public Account selectAccount(String benutzername) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor meinZeiger;
        meinZeiger = db.rawQuery("SELECT * FROM " + TABELLE_ACC +
            " WHERE " + SPALTE_ACC_BENUTZERNAME + "= '" + benutzername + "'", null);
        meinZeiger.moveToFirst();

        Account acc = new Account();
        acc.setId(meinZeiger.getInt(meinZeiger.getColumnIndex(SPALTE_ACC_ID)));
        acc.setBenutzerName(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_BENUTZERNAME)));
        acc.setVorname(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_VORNAME)));
        acc.setNachname(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_NACHNAME)));
        acc.setAnrede(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_GESCHLECHT)));
        acc.setGrad(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_GRAD)));
        acc.setTelenummer(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_TELEFONNUMMER)));
        acc.setPassword(meinZeiger.getString(meinZeiger.getColumnIndex(SPALTE_ACC_PASSWORD)));
        meinZeiger.close();
        return acc;
    }

    //Benutzername in tabelle selectieren fals kein vorhanden wird 0 ausgegeben
    public int accvorhanden(String benutzername) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor meinZeiger;
        meinZeiger = db.rawQuery("SELECT * FROM " + TABELLE_ACC +
                " WHERE " + SPALTE_ACC_BENUTZERNAME + "= '" + benutzername + "'", null);
        meinZeiger.moveToFirst();

        meinZeiger.close();
        return meinZeiger.getCount();
    }


    // Baustellen Datenbank methoden

    public Cursor selectAlleBaustellen() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor meinZeiger = db.rawQuery("SELECT * FROM " + TABELLE_BAUSTELLEN, null);
        meinZeiger.moveToFirst();
        return meinZeiger;
    }


    //Tabelle beim starten der app erstellen (wenn schon einmal erstellt wid keine neue erstellt)
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabelle für acc erstellen
        db.execSQL(
                "CREATE TABLE " + TABELLE_ACC + " (" +
                        SPALTE_ACC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        SPALTE_ACC_BENUTZERNAME + " TEXT," +
                        SPALTE_ACC_VORNAME + " TEXT," +
                        SPALTE_ACC_NACHNAME + " TEXT," +
                        SPALTE_ACC_GESCHLECHT + " TEXT," +
                        SPALTE_ACC_GRAD + " TEXT,"  +
                        SPALTE_ACC_TELEFONNUMMER + " TEXT," +
                        SPALTE_ACC_PASSWORD + " TEXT" +
                        ")"
        );
        //Tabele erstellen Baustelle
        db.execSQL(
                "CREATE TABLE " + TABELLE_BAUSTELLEN + " (" +
                        SPALTE_BAUSTELLEN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        SPALTE_BAUSTELLEN_NAME + " TEXT," +
                        SPALTE_BAUSTELLEN_STRASSE + " TEXT," +
                        SPALTE_BAUSTELLEN_ORT + " TEXT," +
                        SPALTE_BAUSTELLEN_PLZ + " TEXT," +
                        SPALTE_BAUSTELLEN_BAUHERR + " TEXT,"  +
                        SPALTE_BAUSTELLEN_BILD + " INTEGER" +
                        ")"
        );
        //Material tabelle erstellen
        db.execSQL(
                "CREATE TABLE " + TABELLE_MATERIAL + " (" +
                        SPALTE_MATERIAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        SPALTE_MATERIAL_NAME + " TEXT," +
                        SPALTE_MATERIAL_ANZAHL + " INTEGER," +
                        SPALTE_MATERIAL_EINZELPREIS + " DOUBLE," +
                        SPALTE_MATERIAL_GESAMTPREIS + " DOUBLE,"  +
                        SPALTE_BAUSTELLEN_ID + " INTEGER " +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
