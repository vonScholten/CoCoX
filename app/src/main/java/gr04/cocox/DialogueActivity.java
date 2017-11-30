package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DialogueActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;
    ImageButton answers;
    ImageButton keyboard;
    ImageButton pain;
    ImageButton mood;
    ImageButton questions;
    ImageButton aktivitet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        retur = (ImageButton) findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(this);
        answers = (ImageButton) findViewById(R.id.answersButton);
        answers.setOnClickListener(this);
        keyboard = findViewById(R.id.keyboard);
        keyboard.setOnClickListener(this);
        pain = findViewById(R.id.painButton);
        pain.setOnClickListener(this);
        mood = findViewById(R.id.moodButton);
        mood.setOnClickListener(this);
        questions = findViewById(R.id.questionButton);
        questions.setOnClickListener(this);
        aktivitet = findViewById(R.id.activitiesButton);
        aktivitet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.retur: finish();
                break;
            case R.id.home: finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.answersButton: startActivity(new Intent(this, AnswerActivity.class));
                break;
            case R.id.keyboard: startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.painButton: startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.moodButton: startActivity(new Intent(this, MoodActivity.class));
                break;
            case R.id.questionButton: startActivity(new Intent(this, questionsActivity.class));
                break;
            case R.id.activitiesButton: startActivity(new Intent(this, ActActivity.class));
                break;

        }


    }
}
