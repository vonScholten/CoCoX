package gr04.cocox;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class CallActivity extends Activity implements View.OnClickListener {

    public Button call;
    private int currentSound;
    public MediaPlayer alertsound1;
    public MediaPlayer alertsound2;
    public MediaPlayer alertsound3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.47), (int) (height*.8));

        call = findViewById(R.id.call);
        call.setOnClickListener(this);
        alertsound1 = MediaPlayer.create(this, R.raw.sweet_sms);
        alertsound2 = MediaPlayer.create (this, R.raw.alert);
        alertsound3 = MediaPlayer.create (this, R.raw.galaxy_note);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        currentSound = sharedPreferences.getInt("currentSound",1);
    }

    @Override
    public void onClick(View view) {
        playSound();
    }

    public void playSound(){

        if (currentSound == 1){
            alertsound1.start();
        }
        else if (currentSound == 2){
            alertsound2.start();
        }
        else if (currentSound == 3){
            alertsound3.start();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (currentSound == 1){
            alertsound1.stop();
        }
        else if (currentSound == 2){
            alertsound2.stop();
        }
        else if (currentSound == 3){
            alertsound3.stop();
        }
    }
}
