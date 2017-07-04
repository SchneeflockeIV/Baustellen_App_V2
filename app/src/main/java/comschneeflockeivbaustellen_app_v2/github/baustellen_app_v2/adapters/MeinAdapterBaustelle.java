package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.BaustellenViewActivity2;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.MainActivity;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.R;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

/**
 * Created by Daisu_000 on 04.07.2017.
 */

public class MeinAdapterBaustelle extends BaseAdapter {

    private Context context;
    private Baustellen[] baustellen;
    private TextView tvBauname;
    private TextView tvBauherr;
    private DBManager db;
    public BaustellenViewActivity2 view = null;

    private static LayoutInflater inflater = null;
    public MeinAdapterBaustelle(Activity someActivity, ArrayList<Baustellen> listBaustellen) {
        // TODO Auto-generated constructor stub
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
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final View rowView;
        rowView = inflater.inflate(R.layout.simple_list_image_item_2, null);
        tvBauname = (TextView) rowView.findViewById(R.id.MEIN_BAUSTELLEN_NAME);
        tvBauherr = (TextView) rowView.findViewById(R.id.MEIN_BAUSTELLEN_HERR);

        tvBauname.setText(baustellen[position].getBaustellenname());
        tvBauherr.setText(baustellen[position].getBauherr());

        return rowView;
    }
}