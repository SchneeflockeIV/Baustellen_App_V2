package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.Account;
import comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2.classes.DBManager;


public class MainActivity extends AppCompatActivity {
    EditText benutzername;
    EditText password;
    Account acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        benutzername = (EditText)findViewById(R.id.benutzerName);
        password = (EditText) findViewById(R.id.passwort);

    }

    private void getAccountFromDB(String accountname) {
        DBManager db = new DBManager(this);
        acc = db.selectAccount(accountname);

    }

    public void login(View v){
        if(v.getId()==R.id.buttonLogin){
            getAccountFromDB(benutzername.getText().toString());
            String accpass = acc.getPassword();
            String pass = password.getText().toString();

            if(accpass.equals(pass)){
                Intent myIntent = new Intent(this, BaustellenViewActivity.class);
                startActivity(myIntent);
            }
            else Toast.makeText(this, "Password oder Benutzername falsch.", Toast.LENGTH_SHORT).show();
        }



    }

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
