package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton retur;
    ImageButton home;
    Button mememoryGame;
    Button puzzle;

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
        puzzle = findViewById(R.id.puzzle);
        puzzle.setOnClickListener(this);
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
        else if (view == puzzle){
            startActivity(new Intent(this,PuzzleActivity.class));
        }

    }
}
