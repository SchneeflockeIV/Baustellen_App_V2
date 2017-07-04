package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Baustellen;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Material;

public class MaterialErstellen extends AppCompatActivity {

    EditText matname;
    EditText matanzahl;
    EditText mateinzelp;
    Baustellen bau;
    Material mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_erstellen);

        matname = (EditText)findViewById(R.id.MATERIAL_NAME);
        matanzahl = (EditText)findViewById(R.id.MATERIAL_ANZAHL);
        mateinzelp = (EditText)findViewById(R.id.MATERIAL_EINZELPREIS);

    }


    private void fillMaterial(){
        mat = new Material();

        mat.setMaterialname(matname.getText().toString());
        mat.setAnzahl(Integer.parseInt(matanzahl.getText().toString()));
        mat.setEinzelpreis(Double.parseDouble(mateinzelp.getText().toString()));
    }

    private void insertMatInDB(){
        DBManager db = new DBManager(this);
        db.insertMat(mat);
    }

    public void clicked(View v){
        if(v.getId() == R.id.MATERIAL_BUTTON_ERSTELLEN){
            fillMaterial();
            insertMatInDB();
            Toast.makeText(this, "Material erstellt", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

}
