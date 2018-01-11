package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button games;
    Button dialogue;
    ImageButton settings;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        LanguageActivity lan = new LanguageActivity();


        games = (Button) findViewById(R.id.games);
        games.setOnClickListener(this);
        dialogue = (Button) findViewById(R.id.dialogue);
        dialogue.setOnClickListener(this);
        settings = (ImageButton) findViewById(R.id.settings);
        settings.setOnClickListener(this);
        call = (Button) findViewById(R.id.call);
        call.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.games:
                startActivity(new Intent(this, GameActivity.class));
                break;
            case R.id.dialogue:
                startActivity(new Intent(this, DialogueActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(this, SettingsActivity.class));

        }


    }






}
