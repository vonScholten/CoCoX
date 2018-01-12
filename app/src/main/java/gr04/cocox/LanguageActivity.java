package gr04.cocox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity implements View.OnClickListener {

    Button danish;
    Button english;
    Locale myLocale;
    String dk = "da";
    String en = "en";
    ImageButton retur;
    ImageButton home;
    static int check = 0;

    SharedPreferences sharedLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        sharedLang = PreferenceManager.getDefaultSharedPreferences(this);

        changeLang(loadLocale());

        danish = findViewById(R.id.danish);
        danish.setOnClickListener(this);
        english = findViewById(R.id.english);
        english.setOnClickListener(this);
        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        check = 1;
        if(view == retur){
            finish();
            startActivity(new Intent(this, SettingsActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        else if (view == home){
            finish();
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }

        else
            if (view == danish) {
            Toast.makeText(this, "opdaterer sprog", Toast.LENGTH_SHORT).show();

            changeLang(dk);
            saveLocale(dk);
        }
        else
            if(view == english){
            Toast.makeText(this, "opdaterer sprog", Toast.LENGTH_SHORT).show();

            changeLang(en);
            saveLocale(en);
        }
        recreate();
    }

    public String loadLocale() {
        String lang = sharedLang.getString("lang", "da");
        System.out.println("lang: " + lang + " loaded");
        return lang;
    }

    public void changeLang(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    public void saveLocale(String lang) {
        sharedLang.edit().putString("lang",lang).apply();
        System.out.println("lang: " + lang + " saved");
    }

    @Override
    public void onResume() {
        super.onResume();
        changeLang(loadLocale());
    }
}

