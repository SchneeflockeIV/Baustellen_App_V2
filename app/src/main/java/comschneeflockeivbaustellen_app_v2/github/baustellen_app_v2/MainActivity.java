package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked1(View v) {
      //  if (v.getId() == R.id.passVergessen) {
            Intent myIntent = new Intent(MainActivity.this, PassVergessen.class);
            startActivity(myIntent);
       // }
    }
    public void clicked2(View v) {
        // if(v.getId() == R.id.keinAcc) {
        Intent myIntent = new Intent(MainActivity.this, AccErstellen.class);
        startActivity(myIntent);
        //     setContentView(R.layout.acc_erstellen);
        //  }
    }
}
