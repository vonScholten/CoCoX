package gr04.cocox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SoundActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;

    Button sound1;
    Button sound2;
    Button sound3;

    MediaPlayer main;
    MediaPlayer second;
    MediaPlayer third;

    int currentSound = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);

        sound1 = findViewById(R.id.lyd1);
        sound1.setOnClickListener(this);
        sound2 = findViewById(R.id.lyd2);
        sound2.setOnClickListener(this);
        sound3 = findViewById(R.id.lyd3);
        sound3.setOnClickListener(this);

        main = MediaPlayer.create(this, R.raw.sweet_sms);
        second = MediaPlayer.create(this, R.raw.alert);
        third = MediaPlayer.create(this, R.raw.galaxy_note);

    }

    @Override
    public void onClick(View view) {
        if(view == retur) {
            finish();
        }

        else if (view == home) {
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        }

        else if (view == sound1){
            main.start();
            currentSound = 1;
            saveSound(currentSound);
        }
        else if (view == sound2){
            second.start();
            currentSound = 2;
            saveSound(currentSound);
        }
        else if (view == sound3){
            third.start();
            currentSound = 3;
            saveSound(currentSound);
        }



    }

    public void saveSound(int cs){
        SharedPreferences sharedSound = PreferenceManager.getDefaultSharedPreferences(this);
        sharedSound.edit().putInt("currentSound",cs).apply();

        System.out.println("sound " + sharedSound.getInt("currentSound",1));
    }


}
