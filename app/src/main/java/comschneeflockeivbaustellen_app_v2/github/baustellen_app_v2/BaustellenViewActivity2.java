package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapter;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

public class BaustellenViewActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    DBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baustellen_view2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView = (ListView) findViewById(R.id.BAUSTELLEN_LIST_VIEW);
        db = new DBManager(this);

        Context ctx = this;
        int itemLayout = R.layout.simple_list_image_item_2;
        Cursor cursor = db.selectAlleBaustellen();
        String[] from = new String[] {db.SPALTE_BAUSTELLEN_BILD, db.SPALTE_BAUSTELLEN_NAME, db.SPALTE_BAUSTELLEN_BAUHERR};
        int[] to = new int[] {R.id.MEIN_BAUSTELLEN_BILD, R.id.MEIN_BAUSTELLEN_NAME, R.id.MEIN_BAUSTELLEN_HERR};

        MeinAdapter meinAdapter = new MeinAdapter(ctx, itemLayout, cursor, from, to, 0);

        listView.setAdapter(meinAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("HSKL", "id = " + id);
    }
}