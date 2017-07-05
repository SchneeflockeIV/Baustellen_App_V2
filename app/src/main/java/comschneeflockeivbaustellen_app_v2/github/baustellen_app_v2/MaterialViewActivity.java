package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapterBaustelle;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapterMaterial;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Material;

public class MaterialViewActivity extends AppCompatActivity {

    ListView listView;
    DBManager db;
    Bundle extras;
    int baustellen_id;
    Intent myIntent;
    Context context;
    TextView bauName;
    TextView bauStrasse;
    TextView bauPlz;
    TextView bauOrt;
    TextView bauHerr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bauName = (TextView)findViewById(R.id.MATERIAL_BAUSTELLEN_NAME);
        bauStrasse = (TextView)findViewById(R.id.MATERIAL_BAUSTELLEN_STRASSE);
        bauPlz = (TextView)findViewById(R.id.MATERIAL_BAUSTELLEN_PLZ);
        bauOrt = (TextView)findViewById(R.id.MATERIAL_BAUSTELLEN_ORT);
        bauHerr = (TextView)findViewById(R.id.MATERIAL_BAUSTELLEN_HERR);


        context = this;

        extras = getIntent().getExtras();
      //  if(baustellen_id > 0){
            baustellen_id = extras.getInt("BAUSTELLEN_ID");
      //  }

        fillBaustellenDaten();

        myIntent = new Intent(this, MaterialErstellen.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //           .setAction("Action", null).show();
                myIntent = new Intent(context, MaterialErstellen.class);
                myIntent.putExtra("BAUSTELLEN_ID", baustellen_id);
                startActivity(myIntent);
            }
        });

        initControlls(baustellen_id);
    }

    private void initControlls(int key){
        //if(key > 0){
        listView = (ListView) findViewById(R.id.MATERIAL_LIST_VIEW);
        db = new DBManager(this);
        ArrayList<Material> materiallist = db.getMaterialListe(key);

        MeinAdapterMaterial MyAdapter = new MeinAdapterMaterial(this, materiallist);

        listView.setAdapter(MyAdapter);
   //     }
    }

    private void fillBaustellenDaten(){
        DBManager db = new DBManager(this);
        Baustellen bau = db.selectBaustelle(baustellen_id);

        bauName.setText(bau.getBaustellenname());
        bauStrasse.setText(bau.getStrasse());
        bauOrt.setText(bau.getOrt());
        bauPlz.setText(bau.getPlz());
        bauHerr.setText(bau.getBauherr());
    }

}
