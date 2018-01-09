package gr04.cocox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class PainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView bodyfront;
    Button leftfoot;
    Button leftlowerleg;
    Button leftupperleg;
    Button rightfoot;
    Button rightlowerleg;
    Button rightupperleg;
    Button abdomen;
    Button stomach;
    Button chest;
    Button lefthand;
    Button leftlowerarm;
    Button leftupperarmshoulder;
    Button righthand;
    Button rightlowerarm;
    Button rightupperarmshoulder;
    Button neck;
    Button head;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        bodyfront = findViewById(R.id.bodyfront);

        leftfoot = findViewById(R.id.leftfoot);
        leftfoot.setOnClickListener(this);

        leftlowerleg = findViewById(R.id.leftlowerleg);
        leftlowerleg.setOnClickListener(this);

        leftupperleg = findViewById(R.id.leftupperleg);
        leftupperleg.setOnClickListener(this);

        rightfoot = findViewById(R.id.rightfoot);
        rightfoot.setOnClickListener(this);

        rightlowerleg = findViewById(R.id.rightlowerleg);
        rightlowerleg.setOnClickListener(this);

        rightupperleg = findViewById(R.id.rightupperleg);
        rightupperleg.setOnClickListener(this);

        abdomen = findViewById(R.id.abdomen);
        abdomen.setOnClickListener(this);

        stomach = findViewById(R.id.stomach);
        stomach.setOnClickListener(this);

        chest = findViewById(R.id.chest);
        chest.setOnClickListener(this);

        lefthand = findViewById(R.id.lefthand);
        lefthand.setOnClickListener(this);

        leftlowerarm = findViewById(R.id.leftlowerarm);
        leftlowerarm.setOnClickListener(this);

        leftupperarmshoulder = findViewById(R.id.leftupperarmshoulder);
        leftupperarmshoulder.setOnClickListener(this);

        righthand = findViewById(R.id.righthand);
        righthand.setOnClickListener(this);

        rightlowerarm = findViewById(R.id.rightlowerarm);
        rightlowerarm.setOnClickListener(this);

        rightupperarmshoulder = findViewById(R.id.rightupperarmshoulder);
        rightupperarmshoulder.setOnClickListener(this);

        neck = findViewById(R.id.neck);
        neck.setOnClickListener(this);

        head = findViewById(R.id.head);
        head.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == leftfoot) {
            bodyfront.setImageResource(R.drawable.leftfoot);
        }

        if (view == leftlowerleg) {
            bodyfront.setImageResource(R.drawable.leftlowerleg);
        }

        if (view == leftupperleg) {
            bodyfront.setImageResource(R.drawable.leftupperleg);
        }

        if (view == rightfoot) {
            bodyfront.setImageResource(R.drawable.rightfoot);
        }

        if (view == leftlowerleg) {
            bodyfront.setImageResource(R.drawable.leftlowerleg);
        }

        if (view == leftupperleg) {
            bodyfront.setImageResource(R.drawable.leftupperleg);
        }

        if (view == rightfoot) {
            bodyfront.setImageResource(R.drawable.rightfoot);
        }

        if (view == rightlowerleg) {
            bodyfront.setImageResource(R.drawable.rightlowerleg);
        }

        if (view == rightupperleg) {
            bodyfront.setImageResource(R.drawable.rightupperleg);
        }

        if (view == abdomen) {
            bodyfront.setImageResource(R.drawable.abdomen);
        }

        if (view == stomach) {
            bodyfront.setImageResource(R.drawable.stomach);
        }

        if (view == chest) {
            bodyfront.setImageResource(R.drawable.chest);
        }

        if (view == lefthand) {
            bodyfront.setImageResource(R.drawable.lefthand);
        }

        if (view == leftlowerarm) {
            bodyfront.setImageResource(R.drawable.leftlowerarm);
        }

        if (view == leftupperarmshoulder) {
            bodyfront.setImageResource(R.drawable.leftupperarmshoulder);
        }

        if (view == righthand) {
            bodyfront.setImageResource(R.drawable.righthand);
        }

        if (view == rightlowerarm) {
            bodyfront.setImageResource(R.drawable.rightlowerarm);
        }

        if (view == rightupperarmshoulder) {
            bodyfront.setImageResource(R.drawable.rightupperarmshoulder);
        }

        if (view == neck) {
            bodyfront.setImageResource(R.drawable.neck);
        }

        if (view == head) {
            bodyfront.setImageResource(R.drawable.head);
        }
    }
}

