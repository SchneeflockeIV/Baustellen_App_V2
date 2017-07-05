package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        if(v.getId() == R.id.BAUSTELLE_BUTTON_ERSTELLEN){
            if (!bauname.getText().toString().equals("") && !baustrasse.getText().toString().equals("") &&
                    !bauort.getText().toString().equals("") && !bauplz.getText().toString().equals("") &&
                    !bauherr.getText().toString().equals("")) {
                fillBau();
                insertBauInDB();
                Toast.makeText(this, "Baustelle erstellt", Toast.LENGTH_SHORT).show();
                final Intent myIntent = new Intent(this, BaustellenViewActivity2.class);
                startActivity(myIntent);
                finish();
            } else Toast.makeText(this, "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.BAUSTELLE_BUTTON_ABBRECHEN) {
            Toast.makeText(this, "Abgebrochen", Toast.LENGTH_SHORT).show();
            final Intent abbIntent = new Intent(this, BaustellenViewActivity2.class);
            startActivity(abbIntent);
            finish();
        }
    }
}
