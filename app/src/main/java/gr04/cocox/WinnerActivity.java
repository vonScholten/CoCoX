package gr04.cocox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class WinnerActivity extends AppCompatActivity implements View.OnClickListener{

    public KonfettiView kv;
    public Button menu;
    public ImageButton retur;
    public ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        menu = (Button) findViewById(R.id.btn_menu);
        retur = (ImageButton) findViewById(R.id.retur);
        home = (ImageButton) findViewById(R.id.home);

        menu.setOnClickListener(this);


        kv.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12,5f))
                .setPosition(-50f, kv.getWidth() + 50f, -50f, -50f)
                .stream(300, 5000L);
    }

    @Override
    public void onClick(View view) {
        if(view==menu) {
            Intent won = new Intent(WinnerActivity.this, GameActivity.class);
            this.startActivity(won); }
        else if (view==home){
            Intent home = new Intent(WinnerActivity.this, MainActivity.class);
            this.startActivity(home); }
        else if (view==retur) {
            finish();
            }



    }
}


