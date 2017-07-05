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
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Material;

/**
 * Created by Daisu_000 on 04.07.2017.
 */

public class MeinAdapterMaterial extends BaseAdapter {

    private Context context;
    private Material[] material;
    private TextView tvMatname;
    private TextView tvMatanzahl;
    private TextView tvMatpreis;
    private TextView tvMatgesamt;

    private static LayoutInflater inflater = null;
    public MeinAdapterMaterial(Activity someActivity, ArrayList<Material> listMaterial) {
        // TODO Auto-generated constructor stub
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
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
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

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });
        return rowView;
    }
}