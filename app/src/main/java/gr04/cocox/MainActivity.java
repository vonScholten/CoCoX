package gr04.cocox;

import android.content.Intent;
import android.media.Image;
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
        if (view == spil){
            startActivity(new Intent(this, GameActivity.class));
        }
        else
            if (view == dialog){
                startActivity(new Intent(this, DialogueActivity.class));
            }
            else
                if (view == settings){

                }
                else {

                }

    }
}
