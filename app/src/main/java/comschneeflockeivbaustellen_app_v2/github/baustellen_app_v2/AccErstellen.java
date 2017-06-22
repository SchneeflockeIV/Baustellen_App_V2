package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.os.Bundle;
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

        anrede = (RadioGroup)findViewById(R.id.GESCHLECHT);
        rang = (RadioGroup)findViewById(R.id.GRAD);
        benutzer = (EditText)findViewById(R.id.BENUTZERNAME);
        vorname = (EditText)findViewById(R.id.vorName);
        nachname = (EditText)findViewById(R.id.nachName);
        telenummer = (EditText)findViewById(R.id.TNUMMER);
        password1 = (EditText)findViewById(R.id.PASSWORD1);
        password2 = (EditText)findViewById(R.id.PASSWORD2);

    }

    private Account fillAccount() {
        Account acc = new Account();
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
        return acc;
    }

    private void insertAccInDB() {
        DBManager db = new DBManager(this);
        db.insertAcc(acc);
    }


    private Account getAccountFromDB(String accountname) {
        DBManager db = new DBManager(this);
        Account acc = db.selectAccount(accountname);
        return acc;
    }

    public void clicked(View v) {
        if(v.getId() == R.id.buttonACCERSTELLEN) {
            String pw1 = password1.getText().toString();
            String pw2 = password2.getText().toString();
            if(pw1.equals(pw2)) {
                acc = fillAccount();
                insertAccInDB();
                Toast.makeText(this, "Account erstellt", Toast.LENGTH_SHORT).show();
            }

            else Toast.makeText(this, "Passwörter stimmen nicht überein!", Toast.LENGTH_SHORT).show();
        }
        if(v.getId() == R.id.buttonAbbrechen) {
            Account acc = getAccountFromDB("arsch");
            Toast.makeText(this, acc.getPassword(), Toast.LENGTH_SHORT).show();
        }
    }
}
