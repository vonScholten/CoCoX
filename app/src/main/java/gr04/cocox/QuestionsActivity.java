package gr04.cocox;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    public LocalLanguage lang = new LocalLanguage();

    public ImageButton retur;
    public ImageButton home;

    public Button selected;
    public Button refresh;
    public Button call;

    private int[] btn_ID = {
            R.id.doing,
            R.id.time,
            R.id.drink,
            R.id.rounds,
            R.id.what,
            R.id.wrong_with_me,
            R.id.why_here,
            R.id.examination,
            R.id.been_here,
            R.id.plan,
            R.id.where,
            R.id.stuff
    };

    private ArrayList<Button> inactive = new ArrayList<>(btn_ID.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lang.setLangauge(this); //change language from sharedPreferences BEFORE setContentView!
        setContentView(R.layout.activity_questions);

        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        call = findViewById(R.id.call);
        call.setOnClickListener(this);

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

        else if(view==call) {
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

        int activeIndex = inactive.indexOf(selected);

        selected.setBackground(getDrawable(R.drawable.button_active)); // set background to "activeIndex.xml"
        selected.setTextColor(ContextCompat.getColor(this, R.color.activeText)); // set text color
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
