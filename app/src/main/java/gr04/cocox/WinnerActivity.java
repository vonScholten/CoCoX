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

    public LocalLanguage lang = new LocalLanguage();

    public KonfettiView kv;

    public ImageButton retur;
    public ImageButton home;

    public Button call;
    public Button replay;

    private String lastReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lang.setLangauge(this); //change language from sharedPreferences BEFORE setContentView!
        setContentView(R.layout.activity_winner);

        replay = findViewById(R.id.btn_replay);
        replay.setOnClickListener(this);

        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);

        home = findViewById(R.id.home);
        home.setOnClickListener(this);

        call = findViewById(R.id.call);
        call.setOnClickListener(this);

        Bundle replayData = getIntent().getExtras(); //get bundle

        if (replayData != null) { //if the bundle is not empty
            lastReplay = replayData.getString("replay");
            System.out.println(replay);
        }

        kv = findViewById(R.id.konfettiView);

        int width = getResources().getDisplayMetrics().widthPixels;
        kv.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12,5f))
                .setPosition(-50f, width + 50f, -50f, -50f)
                .stream(300, 5000L);
    }

    @Override
    public void onClick(View view) {

        if(view==replay) {
            switch (lastReplay) {
                case "pop": {
                    Intent replay = new Intent(WinnerActivity.this, PopActivity.class);
                    this.startActivity(replay);
                    finish();
                    break;
                }
                case "memo": {
                    Intent replay = new Intent(WinnerActivity.this, MemoryActivity.class);
                    this.startActivity(replay);
                    finish();
                    break;
                }
                default: {
                    Intent replay = new Intent(WinnerActivity.this, GameActivity.class);
                    this.startActivity(replay);
                    finish();
                    break;
                }
            }
        }

        else if (view==home){
            Intent home = new Intent(WinnerActivity.this, MainActivity.class);
            this.startActivity(home);
        }

        else if(view==call){
            startActivity(new Intent(this, CallActivity.class));
        }

        else if (view==retur) {
            finish();
        }
    }
}


