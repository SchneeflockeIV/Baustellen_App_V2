package comschneeflockeivbaustellen_app_v2.github.baustellen_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button PassVergessenButton;
    private Button KeinAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PassVergessenButton = (Button) findViewById(R.id.passVergessen);
        KeinAccountButton = (Button) findViewById(R.id.keinAcc);

        PassVergessenButton.setOnClickListener(this);
        KeinAccountButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == PassVergessenButton) {
            Intent myIntent = new Intent(this, PassVergessen.class);
            startActivity(myIntent);
        }
        if(v == KeinAccountButton) {
            Intent myIntent = new Intent(this, AccErstellen.class);
            startActivity(myIntent);
        }

    }
}
