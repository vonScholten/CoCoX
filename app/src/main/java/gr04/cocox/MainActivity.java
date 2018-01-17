package gr04.cocox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.crashlytics.android.Crashlytics;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public ImageButton settings;

    public Button games;
    public Button dialogue;
    public Button call;

    public Locale myLocale;

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        changeLang(loadLocale()); //change language from sharedPreferences BEFORE setContentView!
        setContentView(R.layout.activity_main);

        games = findViewById(R.id.games);
        games.setOnClickListener(this);

        dialogue = findViewById(R.id.dialogue);
        dialogue.setOnClickListener(this);

        settings = findViewById(R.id.settings);
        settings.setOnClickListener(this);

        call = findViewById(R.id.call);
        call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==call){
            startActivity(new Intent(this, CallActivity.class));
        }
        else {
            switch (view.getId()) {
                case R.id.games:
                    startActivity(new Intent(this, GameActivity.class));
                    break;
                case R.id.dialogue:
                    startActivity(new Intent(this, DialogueActivity.class));
                    break;
                case R.id.settings:
                    startActivity(new Intent(this, SettingsActivity.class));
            }
        }
    }

    public String loadLocale() {
        String lang = sharedPreferences.getString("lang", "da");
        System.out.println("lang: " + lang + " loaded");
        return lang;
    }

    public void changeLang(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }
}
