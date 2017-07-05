package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Account;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

/**
 * Created by Daisu_000 on 26.05.2017.
 */

public class AccErstellen extends AppCompatActivity {

    RadioGroup anrede;
    RadioGroup rang;

    RadioButton herr;
    RadioButton frau;
    RadioButton meister;
    RadioButton geselle;

    EditText benutzer;
    EditText vorname;
    EditText nachname;
    EditText telenummer;
    EditText password1;
    EditText password2;
    Account acc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc_erstellen);

        anrede = (RadioGroup) findViewById(R.id.GESCHLECHT);
        herr = (RadioButton) findViewById(R.id.HERR);
        frau = (RadioButton) findViewById(R.id.FRAU);

        herr.setChecked(true);


        rang = (RadioGroup) findViewById(R.id.GRAD);
        meister = (RadioButton) findViewById(R.id.MEISTER);
        geselle = (RadioButton) findViewById(R.id.GESELLE);


        geselle.setChecked(true);

        benutzer = (EditText)findViewById(R.id.BENUTZERNAME);
        vorname = (EditText)findViewById(R.id.vorName);
        nachname = (EditText)findViewById(R.id.nachName);
        telenummer = (EditText)findViewById(R.id.TNUMMER);
        password1 = (EditText)findViewById(R.id.PASSWORD1);
        password2 = (EditText)findViewById(R.id.PASSWORD2);

    }
    //daten aus den textfeldern/radiobuttons in acc objekt reinschreiben
    private void fillAccount() {
        acc = new Account();
        int selectedGeschlechtID = anrede.getCheckedRadioButtonId();
        int selectedRangID = rang.getCheckedRadioButtonId();

        RadioButton geschlecht = (RadioButton)findViewById(selectedGeschlechtID);
        RadioButton rang = (RadioButton)findViewById(selectedRangID);

        acc.setAnrede(geschlecht.getText().toString());
        acc.setGrad(rang.getText().toString());
        acc.setBenutzerName(benutzer.getText().toString());
        acc.setNachname(nachname.getText().toString());
        acc.setVorname(vorname.getText().toString());
        acc.setTelenummer(telenummer.getText().toString());
        acc.setPassword(password1.getText().toString());
    }
    //daten in db reinschreiben
    private void insertAccInDB() {
        DBManager db = new DBManager(this);
        db.insertAcc(acc);
    }


    private Account getAccountFromDB(String accountname) {
        DBManager db = new DBManager(this);
        Account acc = db.selectAccount(accountname);
        return acc;
    }
    //ueberprüfen ob acc schon vorhanden ist in der db
    private boolean checkaccvorhanden(String Benutzername)
    {
        DBManager db = new DBManager(this);
        if(db.accvorhanden(Benutzername)<=0)
            return true;
        return false;
    }

    //buttons für erstellen und abbrechen implementiert
    public void clicked(View v) {
            if(v.getId() == R.id.buttonACCERSTELLEN) {

                if (!benutzer.getText().toString().equals("") && !vorname.getText().toString().equals("") &&
                        !nachname.getText().toString().equals("") && !telenummer.getText().toString().equals("")) {

                    if (checkaccvorhanden(benutzer.getText().toString())) {

                        String pw1 = password1.getText().toString();
                        String pw2 = password2.getText().toString();

                        if (pw1.equals(pw2)) {
                            fillAccount();
                            insertAccInDB();
                            Toast.makeText(this, "Account erstellt", Toast.LENGTH_SHORT).show();
                            finish();

                        } else
                            Toast.makeText(this, "Passwörter stimmen nicht überein!", Toast.LENGTH_SHORT).show();

                    } else
                        Toast.makeText(this, "Benutzername schon vorhanden", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
                    if (v.getId() == R.id.buttonAbbrechen) {
                        finish();
                    }
                }
            } else{
                finish();
            }

    }
}
