package gr04.cocox;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton retur;
    ImageButton home;
    Button language;
    Button reset;
    Button sound;

    SharedPreferences sharedPreferences;

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.retur: finish();
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.home: finish();
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.language:
                startActivity(new Intent(this, LanguageActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.reset:
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("Reset");
                builder.setMessage(R.string.resetbtn)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                resetPref();
                                resetLanguage();
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
            case R.id.sound:
                startActivity(new Intent(this, SoundActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }

    public void resetLanguage() {
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
}
