package gr04.cocox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


public class PainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView bodyfront;
    ImageView bodyback;
    Button retur;
    Button home;


    int[]btn_id = {
            R.id.leftfoot,
            R.id.leftlowerleg,
            R.id.leftupperleg,
            R.id.rightfoot,
            R.id.rightlowerleg,
            R.id.rightupperleg,
            R.id.abdomen,
            R.id.stomach,
            R.id.chest,
            R.id.lefthand,
            R.id.leftlowerarm,
            R.id.leftupperarmshoulder,
            R.id.righthand,
            R.id.rightlowerarm,
            R.id.rightupperarmshoulder,
            R.id.neck,
            R.id.head,
            R.id.bleftfoot,
            R.id.bleftlowerleg,
            R.id.bleftupperleg,
            R.id.brightfoot,
            R.id.brightlowerleg,
            R.id.brightupperleg,
            R.id.bupperback,
            R.id.blowerback,
            R.id.blefthand,
            R.id.bleftlowerarm,
            R.id.bleftupperarmshoulder,
            R.id.brighthand,
            R.id.brightlowerarm,
            R.id.brightupperarmshoulder,
            R.id.bneck,
            R.id.bhead,
            R.id.buttocks
    };

    ArrayList<Button> buttons = new ArrayList<>(btn_id.length);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        for (int id : btn_id){
            Button button = findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }

        bodyfront = findViewById(R.id.bodyfront);
        bodyback = findViewById(R.id.bodyback);

    }

    @Override
    public void onClick(View view) {
        if(view == retur) {
            finish();
        }
        else if (view == home) {
            this.startActivity(new Intent(this,MainActivity.class));
        }
        else { pain(view); } }

    public void pain(View view) {
        switch (view.getId()) {
            case R.id.leftfoot:
                bodyfront.setImageResource(R.drawable.leftfoot);
                break;
            case R.id.leftlowerleg:
                bodyfront.setImageResource(R.drawable.leftlowerleg);
                break;
            case R.id.leftupperleg:
                bodyfront.setImageResource(R.drawable.leftupperleg);
                break;
            case R.id.rightfoot:
                bodyfront.setImageResource(R.drawable.rightfoot);
                break;
            case R.id.rightlowerleg:
                bodyfront.setImageResource(R.drawable.rightlowerleg);
                break;
            case R.id.rightupperleg:
                bodyfront.setImageResource(R.drawable.rightupperleg);
                break;
            case R.id.abdomen:
                bodyfront.setImageResource(R.drawable.abdomen);
                break;
            case R.id.stomach:
                bodyfront.setImageResource(R.drawable.stomach);
                break;
            case R.id.chest:
                bodyfront.setImageResource(R.drawable.chest);
                break;
            case R.id.lefthand:
                bodyfront.setImageResource(R.drawable.lefthand);
                break;
            case R.id.leftlowerarm:
                bodyfront.setImageResource(R.drawable.leftlowerarm);
                break;
            case R.id.leftupperarmshoulder:
                bodyfront.setImageResource(R.drawable.leftupperarmshoulder);
                break;
            case R.id.righthand:
                bodyfront.setImageResource(R.drawable.righthand);
                break;
            case R.id.rightlowerarm:
                bodyfront.setImageResource(R.drawable.rightlowerarm);
                break;
            case R.id.rightupperarmshoulder:
                bodyfront.setImageResource(R.drawable.rightupperarmshoulder);
                break;
            case R.id.neck:
                bodyfront.setImageResource(R.drawable.neck);
                break;
            case R.id.head:
                bodyfront.setImageResource(R.drawable.head);
                break;
            case R.id.bleftfoot:
                bodyback.setImageResource(R.drawable.bleftfoot);
                break;
            case R.id.bleftlowerleg:
                bodyback.setImageResource(R.drawable.bleftlowerleg);
                break;
            case R.id.bleftupperleg:
                bodyback.setImageResource(R.drawable.bleftupperleg);
                break;
            case R.id.brightfoot:
                bodyback.setImageResource(R.drawable.brightfoot);
                break;
            case R.id.brightlowerleg:
                bodyback.setImageResource(R.drawable.brightlowerleg);
                break;
            case R.id.brightupperleg:
                bodyback.setImageResource(R.drawable.brightupperleg);
                break;
            case R.id.bupperback:
                bodyback.setImageResource(R.drawable.bupperback);
                break;
            case R.id.blowerback:
                bodyback.setImageResource(R.drawable.blowerback);
                break;
            case R.id.blefthand:
                bodyback.setImageResource(R.drawable.blefthand);
                break;
            case R.id.bleftlowerarm:
                bodyback.setImageResource(R.drawable.bleftlowerarm);
                break;
            case R.id.bleftupperarmshoulder:
                bodyback.setImageResource(R.drawable.bleftupperarmshoulder);
                break;
            case R.id.brighthand:
                bodyback.setImageResource(R.drawable.brighthand);
                break;
            case R.id.brightlowerarm:
                bodyback.setImageResource(R.drawable.brightlowerarm);
                break;
            case R.id.brightupperarmshoulder:
                bodyback.setImageResource(R.drawable.brightupperarmshoulder);
                break;
            case R.id.bneck:
                bodyback.setImageResource(R.drawable.bneck);
                break;
            case R.id.bhead:
                bodyback.setImageResource(R.drawable.bhead);
                break;
            case R.id.buttocks:
                bodyback.setImageResource(R.drawable.buttocks);
                break;
        }
    }
}

