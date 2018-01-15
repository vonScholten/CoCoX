package gr04.cocox;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;

    Button language;
    Button reset;
    Button sound;
    Button evaluation;
    Button input;

    SharedPreferences sharedPreferences;

    AlertDialog selectLocal;
    AlertDialog selectSound;
    AlertDialog selectSize;
    AlertDialog selectInput;

    Locale myLocale;

    MediaPlayer defualt;
    MediaPlayer s1;
    MediaPlayer s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);

        home = findViewById(R.id.home);
        home.setOnClickListener(this);

        language = findViewById(R.id.language);
        language.setOnClickListener(this);

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);

        sound = findViewById(R.id.sound);
        sound.setOnClickListener(this);

        evaluation = findViewById(R.id.evaluation);
        evaluation.setOnClickListener(this);

        input = findViewById(R.id.input);
        input.setOnClickListener(this);

        defualt = MediaPlayer.create(this, R.raw.sweet_sms);
        s1 = MediaPlayer.create(this, R.raw.alert);
        s2 = MediaPlayer.create(this, R.raw.galaxy_note);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.retur:
                stopSound();
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                break;
            case R.id.home:
                stopSound();
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
                break;
            case R.id.reset:
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("Reset");
                builder.setMessage(R.string.reset_btn)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                resetPref();
                                resetLocal();
                                recreate();
                            }

                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }

                        });

                builder.show();
                break;
            case R.id.language:
                //startActivity(new Intent(this, LanguageActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                selectLocal();
                break;
            case R.id.sound:
                //startActivity(new Intent(this, SoundActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                selectSound();
                break;
            case R.id.evaluation:
                selectEvaluation();
                break;
            case R.id.input:
                selectInput();
                break;
        }
    }

    /** Select local / language
     *
     */

    public void selectLocal() {
        selectLocal = new AlertDialog.Builder(this).create();
        selectLocal.setCancelable(true);
        selectLocal.setTitle(getString(R.string.select_lang));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ListView listView = new ListView(this);

        //The array containing strings of available languages for ui (full name)
        final String[] language = {
                "Dansk",
                "English"
        };

        //Use ISO 639-1 Code language code
        final String[] languageCode = {
                "da",
                "en"
        };

        final ArrayList<String> listLocal = new ArrayList<String>();
        for (String local : languageCode) { listLocal.add(local); }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, language);
        listView.setAdapter(adapter);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        layout.addView(listView);
        selectLocal.setView(layout);
        selectLocal.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                setLocal(listLocal.get(pos));
                selectLocal.dismiss();
                recreate();
            }
        });
    }

    public String loadLocale() {
        String lang = sharedPreferences.getString("lang", "da");
        System.out.println("lang: " + lang + " loaded");
        return lang;
    }

    public void setLocal(String lang) {
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
        sharedPreferences.edit().putString("lang",lang).apply();
        System.out.println("lang: " + lang + " saved");
    }

    /** Select sound
     *
     */

    public void selectSound(){
        selectSound = new AlertDialog.Builder(this).create();
        selectSound.setCancelable(true);
        selectSound.setTitle(getString(R.string.select_sound));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ListView listView = new ListView(this);

        //The array containing strings of available sound for ui (full name)
        final String[] sound = {
                "default",
                "sound 1",
                "sound 2"
        };

        //Uses ints as id
        final int[] soundId = {
                1,
                2,
                3
        };

        final ArrayList<Integer> listSound = new ArrayList<Integer>();
        for (int id : soundId) { listSound.add(id); }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sound);
        listView.setAdapter(adapter);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        layout.addView(listView);
        selectSound.setView(layout);
        selectSound.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                if(pos == 0) {defualt.start(); }
                else if(pos == 1) {s1.start(); }
                else if(pos == 2) {s2.start(); }

                saveSound(listSound.get(pos));
            }
        });
    }

    public void saveSound(int cs){
        SharedPreferences sharedSound = PreferenceManager.getDefaultSharedPreferences(this);
        sharedSound.edit().putInt("currentSound",cs).apply();

        System.out.println("sound " + sharedSound.getInt("currentSound",1));
    }

    public void stopSound(){
        defualt.stop();
        s1.stop();
        s2.stop();
    }

    /** Evaluation
     * Some methods is missing
     */

    public void selectEvaluation(){
        selectSize = new AlertDialog.Builder(this).create();
        selectSize.setCancelable(true);
        selectSize.setTitle(getString(R.string.select_evaluation));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ListView listView = new ListView(this);

        //The array containing strings of available sizes for ui (full name)
        final String[] size = {
                getString(R.string.size_small),
                getString(R.string.size_default),
                getString(R.string.size_large)
        };

        //Uses ints as id
        final int[] sizeId = {
                1,
                2,
                3
        };

        final ArrayList<Integer> listSound = new ArrayList<Integer>();
        for (int id : sizeId) { listSound.add(id); }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, size);
        listView.setAdapter(adapter);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        layout.addView(listView);
        selectSize.setView(layout);
        selectSize.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                //TODO: make some methode to evaluation
                selectSize.dismiss();
            }
        });
    }

    /** Input
     * Some methods is missing
     */

    public void selectInput(){
        selectInput = new AlertDialog.Builder(this).create();
        selectInput.setCancelable(true);
        selectInput.setTitle(getString(R.string.select_input));

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ListView listView = new ListView(this);

        //The array containing strings of available input methods for ui (full name)
        final String[] size = {
                getString(R.string.input_touch),
                getString(R.string.input_head),
        };

        //Uses ints as id
        final int[] inputId = {
                1,
                2
        };

        final ArrayList<Integer> listSound = new ArrayList<Integer>();
        for (int id : inputId) { listSound.add(id); }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, size);
        listView.setAdapter(adapter);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        layout.addView(listView);
        selectInput.setView(layout);
        selectInput.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                //TODO: make some methode to font
                selectInput.dismiss();
            }
        });
    }

    /** Reset
     *
     */

    public void resetLocal() {
        Toast.makeText(this, "Resetter tablet", Toast.LENGTH_SHORT).show();

        Locale locale = new Locale("da", "DK");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
    }

    public void resetPref(){
        sharedPreferences.edit().putString("lang","da").apply();
        sharedPreferences.edit().putInt("currentSound",1).apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        setLocal(loadLocale());
    }

}
