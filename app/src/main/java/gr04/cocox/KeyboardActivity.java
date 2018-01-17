package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KeyboardActivity extends AppCompatActivity implements View.OnClickListener {

    public LocalLanguage lang = new LocalLanguage();

    public ImageButton back;
    public ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lang.setLangauge(this); //change language from sharedPreferences BEFORE setContentView!
        setContentView(R.layout.activity_keyboard);

        back = findViewById(R.id.keyboard_back);
        back.setOnClickListener(this);

        home = findViewById(R.id.keyboard_home);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == back){
            finish();
        }
        else if (view == home){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

    }
}
