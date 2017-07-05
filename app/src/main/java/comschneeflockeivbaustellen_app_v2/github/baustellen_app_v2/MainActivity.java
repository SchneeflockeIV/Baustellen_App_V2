package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Account;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;

// Login Fenster, erscheint nacht dem starten der App
public class MainActivity extends AppCompatActivity {

    // Variablen anlegen
    EditText benutzername;
    EditText password;
    Account acc;
    DBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        benutzername = (EditText)findViewById(R.id.benutzerName);
        password = (EditText) findViewById(R.id.passwort);

    }

    // Methode um Account Informationen aus der Datenbank auszulesen
    private void getAccountFromDB(String accountname) {
        db = new DBManager(this);
        acc = db.selectAccount(accountname);

    }

    // Methode um gültigen Account mit der in der DB hinterlegten Accounts zu vergleichen,
    // Button handling
    public void login(View v){
        db = new DBManager(this);
        if(v.getId()==R.id.buttonLogin){
            String userName = benutzername.getText().toString();
            if(db.accvorhanden(userName)>0) {
                getAccountFromDB(userName);
                String accpass = acc.getPassword();
                String pass = password.getText().toString();

                String accName = acc.getBenutzerName();
                String name = benutzername.getText().toString();

                if(accpass.equals(pass) && accName.equals(name)){
                              Intent myIntent = new Intent(this, BaustellenViewActivity2.class);
                              startActivity(myIntent);
                }
                else Toast.makeText(this, "Password oder Benutzername falsch.", Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(this, "Password oder Benutzername falsch.", Toast.LENGTH_SHORT).show();
        }
        benutzername.setText("");
        password.setText("");
    }

    // Überprüfen ob Textfelder angeklickt wurden
    public void clicked(View v) {
        if (v.getId() == R.id.passVergessen) {
            Intent myIntent = new Intent(this, PassVergessen.class);
            startActivity(myIntent);
        }
        if(v.getId() == R.id.keinAcc) {
            Intent myIntent = new Intent(this, AccErstellen.class);
            startActivity(myIntent);
        }

    }
}
