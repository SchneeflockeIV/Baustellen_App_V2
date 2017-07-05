package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapterBaustelle;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

// Baustellen View, Übersicht
public class BaustellenViewActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    // Variablen anlegen
    ListView listView;
    DBManager db;
    Intent myIntent;
    Context context;

    boolean deleteClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baustellen_view2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        myIntent = new Intent(this, BaustelleErstellen.class);

        context = this;


        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
             //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             //           .setAction("Action", null).show();
                myIntent = new Intent(context, BaustelleErstellen.class);
                startActivity(myIntent);
                finish();

            }
        });

        initControlls();

        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    // Methode initialisert Liste
    private void initControlls(){
        listView = (ListView) findViewById(R.id.BAUSTELLEN_LIST_VIEW);
        db = new DBManager(this);
        ArrayList<Baustellen> baustellenlist = db.getBaustellenListe();

        MeinAdapterBaustelle MyAdapter = new MeinAdapterBaustelle(this, baustellenlist);

        listView.setAdapter(MyAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!deleteClick) {
            final Baustellen bau = (Baustellen) listView.getAdapter().getItem(position);
            myIntent = new Intent(this, MaterialViewActivity.class);
            myIntent.putExtra("BAUSTELLEN_ID", bau.getBauId());
            startActivity(myIntent);
        }
    }

    // Longcklick Methode um Objekt aus Liste und DB zu entfernen
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        deleteClick = true;
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(this);
        final Baustellen bau = (Baustellen) listView.getAdapter().getItem(position);
        myAlertDialog.setTitle("Löschen?");
        myAlertDialog.setMessage("Möchten Sie die Baustelle " +bau.getBaustellenname()+" wirklich aus der Liste löschen?" );
        myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                if(db.deleteBau(bau)){
                    Toast.makeText(context, "Baustelle erfolgreich aus Liste entfernt", Toast.LENGTH_SHORT).show();
                    myIntent = new Intent(context, BaustellenViewActivity2.class);
                    startActivity(myIntent);
                    deleteClick = false;
                    finish();

                }
                else{
                    Toast.makeText(context, "Fehler beim löschen der ausgewählten Baustelle", Toast.LENGTH_SHORT).show();
                    deleteClick = false;
                }
            }});
        myAlertDialog.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                deleteClick = false;
            }});
        myAlertDialog.show();
        return false;
    }
}

