package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;

    Button cat;
    boolean active; // buttons state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        cat = findViewById(R.id.light);
        cat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.retur:
                finish();
                break;
            case R.id.home:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.light: // til test
                update();
                break;
        }
    }

    /** eksemple på select/update metoden af knapperne
     * måske der kan bruges en liste til at holde aktiv/inaktiv status for hver knap?
     */

    public void update() {
        if (!active) {
            System.out.println("state is inactive");
            cat.setBackground(getDrawable(R.drawable.comm_active)); // set background to "active.xml"
            cat.setTextColor(getColor(R.color.activeText)); // set text color
            cat.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.light_active, 0, 0); // set cat
            active = true; // set state to active
            System.out.println("state is now active");
        } else {
            System.out.println("state is active");
            cat.setBackground(getDrawable(R.drawable.comm_inactive));
            cat.setTextColor(getColor(R.color.inactiveText));
            cat.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.newlight, 0, 0);
            active = false;
            System.out.println("state is now inactive");
        }
    }
}
