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

/**
 * Created by Daisu_000 on 04.07.2017.
 */

public class MeinAdapterBaustelle extends BaseAdapter {

    private Context context;
    private Baustellen[] baustellen;
    private TextView tvBauname;
    private TextView tvBauherr;

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
        rowView = inflater.inflate(R.layout.simple_list_image_item_2, null);
        tvBauname = (TextView) rowView.findViewById(R.id.MEIN_BAUSTELLEN_NAME);
        tvBauherr = (TextView) rowView.findViewById(R.id.MEIN_BAUSTELLEN_HERR);

        tvBauname.setText(baustellen[position].getBaustellenname());
        tvBauherr.setText(baustellen[position].getBauherr());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });
        return rowView;
    }
}