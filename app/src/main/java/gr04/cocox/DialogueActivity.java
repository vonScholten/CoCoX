package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DialogueActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;
    Button answers;
    Button keyboard;
    Button pain;
    Button mood;
    Button questions;
    Button aktivitet;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        retur = (ImageButton) findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(this);
        answers = (Button) findViewById(R.id.answer);
        answers.setOnClickListener(this);
        keyboard = findViewById(R.id.keyboard);
        keyboard.setOnClickListener(this);
        pain = findViewById(R.id.pain);
        pain.setOnClickListener(this);
        mood = findViewById(R.id.mood);
        mood.setOnClickListener(this);
        questions = findViewById(R.id.questions);
        questions.setOnClickListener(this);
        aktivitet = findViewById(R.id.activity);
        aktivitet.setOnClickListener(this);
        call = findViewById(R.id.call);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.retur:
                finish();
                break;
            case R.id.home:
                finish();
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.answer:
                startActivity(new Intent(this, AnswerActivity.class));
                break;
            case R.id.keyboard:
                startActivity(new Intent(this, KeyboardActivity.class));
                break;
            case R.id.pain:
                startActivity(new Intent(this, PainActivity.class));
                break;
            case R.id.mood:
                startActivity(new Intent(this, MoodActivity.class));
                break;
            case R.id.questions:
                startActivity(new Intent(this, QuestionsActivity.class));
                break;
            case R.id.activity:
                startActivity(new Intent(this, ActActivity.class));
                break;

        }

        if (view == call)
            startActivity(new Intent(this, CallActivity.class));
        
    }
}
