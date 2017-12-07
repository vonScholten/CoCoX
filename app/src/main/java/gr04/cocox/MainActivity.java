package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton spil;
    ImageButton dialog;
    ImageButton settings;
    ImageButton kald;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spil = (ImageButton) findViewById(R.id.spil);
        spil.setOnClickListener(this);
        dialog = (ImageButton) findViewById(R.id.kommunikation);
        dialog.setOnClickListener(this);
        settings = (ImageButton) findViewById(R.id.settings);
        settings.setOnClickListener(this);
        kald = (ImageButton) findViewById(R.id.call);
        kald.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.spil:
                startActivity(new Intent(this, GameActivity.class));
                break;
            case R.id.kommunikation:
                startActivity(new Intent(this, DialogueActivity.class));
                break;
            case R.id.settings: startActivity(new Intent(this, SettingsActivity.class));
        }


    }
}
