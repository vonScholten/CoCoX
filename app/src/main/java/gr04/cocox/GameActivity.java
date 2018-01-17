package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    public ImageButton retur;
    public ImageButton home;

    public Button mememoryGame;
    public Button pop;
    public Button puzzle;
    public Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        retur = (ImageButton) findViewById(R.id.retur);
        retur.setOnClickListener(this);

        home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(this);

        mememoryGame = (Button) findViewById(R.id.memory);
        mememoryGame.setOnClickListener(this);

        pop = (Button) findViewById(R.id.balloon);
        pop.setOnClickListener(this);

        puzzle = findViewById(R.id.puzzle);
        puzzle.setOnClickListener(this);

        call = findViewById(R.id.call);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == retur){
            finish();
        }
        else if (view == home){
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        else if (view == mememoryGame){
            startActivity(new Intent(this,MemoryActivity.class));
        }
        else if(view == pop){
            startActivity(new Intent(this, PopActivity.class));
        }
        else if (view == puzzle){
            startActivity(new Intent(this,PuzzleActivity.class));
        }
        else if (view == call){
            startActivity(new Intent(this,CallActivity.class));
        }
    }
}
