package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapterBaustelle;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapterMaterial;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Material;

public class MaterialViewActivity extends AppCompatActivity {

    ListView listView;
    DBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent myIntent = new Intent(this, MaterialErstellen.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //           .setAction("Action", null).show();
                startActivity(myIntent);
                finish();
            }
        });

        initControlls();
    }

    private void initControlls(){
        listView = (ListView) findViewById(R.id.MATERIAL_LIST_VIEW);
        db = new DBManager(this);
        ArrayList<Material> materiallist = db.getMaterialListe();

        MeinAdapterMaterial MyAdapter = new MeinAdapterMaterial(this, materiallist);

        listView.setAdapter(MyAdapter);
    }

}
