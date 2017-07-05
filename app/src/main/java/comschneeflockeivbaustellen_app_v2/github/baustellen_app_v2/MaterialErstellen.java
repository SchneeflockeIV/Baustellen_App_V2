package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Material;

// Klasse um Material in Baustellen Details zu schreiben
public class MaterialErstellen extends AppCompatActivity {

    // Variablen anlegen
    EditText matname;
    EditText matanzahl;
    EditText mateinzelp;
    Material mat;
    int baustellen_id;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_erstellen);

        matname = (EditText)findViewById(R.id.MATERIAL_NAME);
        matanzahl = (EditText)findViewById(R.id.MATERIAL_ANZAHL);
        mateinzelp = (EditText)findViewById(R.id.MATERIAL_EINZELPREIS);

        extras = getIntent().getExtras();
        baustellen_id = extras.getInt("BAUSTELLEN_ID");

    }


    // Methode um Liste mit Material zu füllen
    private void fillMaterial(){
        mat = new Material();

        mat.setBauid(baustellen_id);

        mat.setMaterialname(matname.getText().toString());
        mat.setAnzahl(Integer.parseInt(matanzahl.getText().toString()));
        mat.setEinzelpreis(Integer.parseInt(mateinzelp.getText().toString()));
    }

    // Methode um Material in DB zu schreiben
    private void insertMatInDB(){
        DBManager db = new DBManager(this);
        db.insertMat(mat);
    }

    // Methode um cklicks zu handlen
    public void clicked(View v){
        if(v.getId() == R.id.MATERIAL_BUTTON_ERSTELLEN){
            if (!matname.getText().toString().equals("") && !matanzahl.getText().toString().equals("") &&
                    !mateinzelp.getText().toString().equals("")) {
                fillMaterial();
                insertMatInDB();
                Toast.makeText(this, "Material erstellt", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(this, MaterialViewActivity.class);
                myIntent.putExtra("BAUSTELLEN_ID", baustellen_id);
                startActivity(myIntent);
                finish();
            }
            else Toast.makeText(this, "Bitte füllen Sie alle Felder aus", Toast.LENGTH_SHORT).show();
        } else{
            Intent abbIntent = new Intent(this, MaterialViewActivity.class);
            abbIntent.putExtra("BAUSTELLEN_ID", baustellen_id);
            startActivity(abbIntent);
            finish();
        }

    }

}
