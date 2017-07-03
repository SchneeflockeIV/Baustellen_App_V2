package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Daisu_000 on 29.05.2017.
 */

public class MeinAdapter extends CursorAdapter {

    LayoutInflater meinLayoutInflater;
    int itemLayout;
    String[] from;
    int[] to;

    public MeinAdapter(Context ctx, int itemLayout, Cursor c, String[] from, int[] to, int flags) {
        super(ctx, c, flags);
        meinLayoutInflater = LayoutInflater.from(ctx);
        this.itemLayout = itemLayout;
        this.from = from;
        this.to = to;
    }
    @Override
    public View newView(Context ctx, Cursor c, ViewGroup parent) {
        View v = meinLayoutInflater.inflate(itemLayout, parent, false);
        return v;
    }
    @Override
    public void bindView(View v, Context ctx, Cursor c) {

        int image = c.getInt(c.getColumnIndexOrThrow(from[0]));
        ImageView imageView = (ImageView) v.findViewById(to[0]);
        imageView.setImageResource(image);

        String text1 = c.getString(c.getColumnIndexOrThrow(from[1]));
        TextView textView1 = (TextView) v.findViewById(to[1]);
        textView1.setText(text1);

        String text2 = c.getString(c.getColumnIndexOrThrow(from[2]));
        TextView textView2 = (TextView) v.findViewById(to[2]);
        textView2.setText(text2);
    }
}
