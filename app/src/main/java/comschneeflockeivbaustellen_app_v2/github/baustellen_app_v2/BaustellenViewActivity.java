package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters.MeinAdapter;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

/**
 * Created by Daisu_000 on 29.05.2017.
 */

public class BaustellenViewActivity  extends AppCompatActivity {

    ListView listView;
    DBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baustellen_view);


   /*     listView = (ListView) findViewById(R.id.BAUSTELLEN_LIST_VIEW);
        db = new DBManager(this);
        Context ctx = this;
        int itemLayout = R.layout.simple_list_image_item_2;
        Cursor cursor = db.selectAllePersonen();
        String[] from = new String[] {db.SPALTE_PERSONEN_BILD, db.SPALTE_PERSONEN_NAME, db.SPALTE_PERSONEN_ADRESSE};
        int[] to = new int[] {R.id.MEIN_PERSONEN_BILD, R.id.MEIN_PERSONEN_NAMEN, R.id.MEIN_PERSONEN_ADRESSE};
        MeinAdapter meinAdapter = new MeinAdapter(ctx, itemLayout, cursor, from, to, 0);
        listView.setAdapter(meinAdapter);*/
    }
}
