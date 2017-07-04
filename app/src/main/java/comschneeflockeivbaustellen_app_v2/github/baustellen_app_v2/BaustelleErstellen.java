package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

public class BaustelleErstellen extends AppCompatActivity {

    EditText bauname;
    EditText baustrasse;
    EditText bauort;
    EditText bauplz;
    EditText bauherr;
    Baustellen bau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baustelle_erstellen);

        bauname = (EditText)findViewById(R.id.BAUSTELLEN_NAME);
        baustrasse = (EditText)findViewById(R.id.BAUSTELLEN_STRASSE);
        bauort = (EditText)findViewById(R.id.BAUSTELLEN_ORT);
        bauplz = (EditText)findViewById(R.id.BAUSTELLEN_PLZ);
        bauherr = (EditText)findViewById(R.id.BAUSTELLEN_BAUHERR);
    }

    private void fillBau(){
        bau = new Baustellen();

        bau.setBaustellenname(bauname.getText().toString());
        bau.setStrasse(baustrasse.getText().toString());
        bau.setOrt(bauort.getText().toString());
        bau.setPlz(bauplz.getText().toString());
        bau.setBauherr(bauherr.getText().toString());
    }

    private void insertBauInDB(){
        DBManager db = new DBManager(this);
        db.insertBau(bau);
    }

    public void clicked(View v){
        if(v.getId() == R.id.)
    }
}
