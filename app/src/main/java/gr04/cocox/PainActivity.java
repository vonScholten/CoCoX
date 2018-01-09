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

    }

    @Override
    public void onClick(View view) {

        if (view == leftfoot) {
            bodyfront.setImageResource(R.drawable.leftfoot);
        }

        if (view == leftlowerleg) {
            bodyfront.setImageResource(R.drawable.leftlowerleg);
        }
    }
}

