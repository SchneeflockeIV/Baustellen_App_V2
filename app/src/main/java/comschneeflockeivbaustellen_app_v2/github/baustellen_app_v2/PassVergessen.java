package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Account;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

/**
 * Created by Daisu_000 on 26.05.2017.
 */

public class PassVergessen extends AppCompatActivity {

    EditText benutzername;
    EditText password1;
    EditText password2;
    Account acc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_vergessen);

        benutzername = (EditText)findViewById(R.id.ACCNAME);
        password1 = (EditText)findViewById(R.id.VERGESSEN_PASSWORD1);
        password2 = (EditText)findViewById(R.id.VERGESSEN_PASSWORD2);

    }
    //TODO Abfragen ob acc vorhanden ist
    public void PassAendern(View v){
        if(v.getId()==R.id.BUTTONPASSWORD){
            if (!benutzername.getText().toString().equals("") && !password1.getText().toString().equals("") &&
                    !password2.getText().toString().equals("")) {
                DBManager db = new DBManager(this);
                String bname = benutzername.getText().toString();
                String pw1 = password1.getText().toString();
                String pw2 = password2.getText().toString();
                //acc = getAccountFromDB(bname);
                if (pw1.equals(pw2)) {
                    db.setNewPassword(bname, pw1);
                    Toast.makeText(this,
                            "Passwort erfolgreich abgeändert!",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this,
                            "Passwörter stimmen nicht überein!",
                            Toast.LENGTH_SHORT).show();
                }
            } else{                    Toast.makeText(this,
                    "Bitte füllen Sie alle Felder aus",
                    Toast.LENGTH_SHORT).show();

            }
        }
        else{
               finish();
        }
    }

    private Account getAccountFromDB(String accountname) {
        DBManager db = new DBManager(this);
        Account acc = db.selectAccount(accountname);
        return acc;
    }



}
