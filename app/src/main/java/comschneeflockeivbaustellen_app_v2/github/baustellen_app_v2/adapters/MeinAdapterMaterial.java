package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.R;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Material;


// Adapter um Datenbank mit Baustellendetails mit Materialliste zu handlen
public class MeinAdapterMaterial extends BaseAdapter {

    // Variablen anlegen
    private Context context;
    private Material[] material;
    private TextView tvMatname;
    private TextView tvMatanzahl;
    private TextView tvMatpreis;
    private TextView tvMatgesamt;

    private static LayoutInflater inflater = null;
    public MeinAdapterMaterial(Activity someActivity, ArrayList<Material> listMaterial) {
        material = new Material[listMaterial.size()];
        listMaterial.toArray(material);
        context = someActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return material.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.simple_list_item_1, null);
        tvMatname = (TextView) rowView.findViewById(R.id.MEIN_MATERIAL_NAME);
        tvMatanzahl = (TextView) rowView.findViewById(R.id.MEIN_MATERIAL_ANZAHL);
        tvMatpreis = (TextView) rowView.findViewById(R.id.MEIN_MATERIAL_EINZELPREIS);
        tvMatgesamt = (TextView) rowView.findViewById(R.id.MEIN_MATERIAL_GESAMTPREIS);

        tvMatname.setText(material[position].getMaterialname());
        tvMatanzahl.setText(Integer.toString(material[position].getAnzahl()));
        tvMatpreis.setText(Integer.toString(material[position].getEinzelpreis()));
        tvMatgesamt.setText(Integer.toString(material[position].getGesamtpreis()));

        return rowView;
    }
}