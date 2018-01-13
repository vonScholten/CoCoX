package gr04.cocox;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class ActActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;
    Button call;

    Button selected;
    Button refresh;

    int activeIndex;

    int activeColor;
    int inactiveColor;


    int[] btn_ID = {
            R.id.visit,
            R.id.silence,
            R.id.toilet,
            R.id.tv,
            R.id.air,
            R.id.light,
            R.id.walk,
            R.id.sleep,
            R.id.sit,
            R.id.turn,
            R.id.painkillers,
            R.id.suction
    };

    ArrayList<Button> inactive = new ArrayList<>(btn_ID.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);


        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        call = findViewById(R.id.call);
        call.setOnClickListener(this);

        int inactiveColor = Color.parseColor("#EEEDDE");
        int activeColor = Color.parseColor("#1C87B0");

        for (int id : btn_ID){
            Button button = findViewById(id);
            button.setOnClickListener(this);
            inactive.add(button);
        }

    }

    @Override
    public void onClick(View view) {

        if(view == retur) {
            finish();
        }

        else if (view == home) {
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        }

        else if(view==call){
            startActivity(new Intent(this, CallActivity.class));

        }

        else {
            System.out.println("[1] DEBUG: button id: " + view.getId());
            for (int id : btn_ID){

                if(id == view.getId()){
                    inactive.add(selected);
                    selected = findViewById(id);
                }
            }
            update();
        }
    }

    public void update() {

        activeIndex = inactive.indexOf(selected);

        selected.setBackground(getDrawable(R.drawable.button_active)); // set background to "activeIndex.xml"
        selected.setTextColor(ContextCompat.getColor(this,R.color.activeText)); // set text color
        selected.setSelected(true); //Set button selected state as true
        inactive.remove(activeIndex);

        for (int id : btn_ID) {
            if(inactive.contains(findViewById(id))) {
                refresh = findViewById(id);
                refresh.setBackground(getDrawable(R.drawable.button_inactive_shadow));
                refresh.setTextColor(ContextCompat.getColor(this, R.color.inactiveText));
                refresh.setSelected(false); //Set button selected state as false
            }
        }
    }





}



