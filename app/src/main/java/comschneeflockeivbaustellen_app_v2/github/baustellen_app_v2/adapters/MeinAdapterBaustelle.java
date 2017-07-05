package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.BaustellenViewActivity2;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.R;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;


// Adapter um Datenbank mit Baustellenübersicht Liste zu handlen
public class MeinAdapterBaustelle extends BaseAdapter {

    // Variablen anlegen
    private Context context;
    private Baustellen[] baustellen;
    private TextView tvBauname;
    private TextView tvBauherr;
    private DBManager db;
    public BaustellenViewActivity2 view = null;

    private static LayoutInflater inflater = null;
    public MeinAdapterBaustelle(Activity someActivity, ArrayList<Baustellen> listBaustellen) {
        baustellen = new Baustellen[listBaustellen.size()];
        listBaustellen.toArray(baustellen);
        context = someActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return baustellen.length;
    }

    @Override
    public Baustellen getItem(int position) {
        Baustellen output = baustellen[position];
        return output;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View rowView;
        rowView = inflater.inflate(R.layout.simple_list_image_item_2, null);
        tvBauname = (TextView) rowView.findViewById(R.id.MEIN_BAUSTELLEN_NAME);
        tvBauherr = (TextView) rowView.findViewById(R.id.MEIN_BAUSTELLEN_HERR);

        tvBauname.setText(baustellen[position].getBaustellenname());
        tvBauherr.setText(baustellen[position].getBauherr());

        return rowView;
    }
}