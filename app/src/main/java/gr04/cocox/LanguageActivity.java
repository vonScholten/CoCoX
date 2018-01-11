package gr04.cocox;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        danish = findViewById(R.id.danish);
        danish.setOnClickListener(this);
        english = findViewById(R.id.english);
        english.setOnClickListener(this);
        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);
        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        loadLocale();

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
            loadLocale();
            changeLang(dk);
            saveLocale(dk);
        }
        else
            if(view == english){
            Toast.makeText(this, "opdaterer sprog", Toast.LENGTH_SHORT).show();
            loadLocale();
            changeLang(en);
            saveLocale(en);
        }
        //setupLanguage(view);
        recreate();

    }

    //void setupLanguage(View v) {
    //   Toast.makeText(this, "opdaterer sprog", Toast.LENGTH_SHORT).show();

/*
        Resources resources = this.getApplicationContext().getResources();
        Configuration overrideConfiguration = resources.getConfiguration();
        Locale overrideLocale = new Locale("da");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            overrideConfiguration.setLocale(overrideLocale);
        } else {
            overrideConfiguration.locale = overrideLocale;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.getApplicationContext().createConfigurationContext(overrideConfiguration);
        } else {
            resources.updateConfiguration(overrideConfiguration, null);
        }
        */
       /* if (v == danish){

        Locale locale = new Locale("da", "DK");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        //startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
        }
        else if(v == english){
            Locale locale = new Locale("en", "US");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);
        }*/


    public void loadLocale() {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        changeLang(language);
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
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.apply();
    }



}

