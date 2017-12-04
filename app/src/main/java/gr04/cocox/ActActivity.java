package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ActActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;

    Button selected;
    Button refresh;

    int activeIndex;

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

        selected.setBackground(getDrawable(R.drawable.dialogue_active)); // set background to "activeIndex.xml"
        selected.setTextColor(getColor(R.color.activeText)); // set text color
        selected.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cat_active, 0, 0); // set cat

        inactive.remove(activeIndex);

        for (int id : btn_ID) {
            if(inactive.contains(findViewById(id))) {
                refresh = findViewById(id);
                refresh.setBackground(getDrawable(R.drawable.dialogue_inactive));
                refresh.setTextColor(getColor(R.color.inactiveText));
                refresh.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cat_inactive, 0, 0);
            }
        }
    }
}
