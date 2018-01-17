package gr04.cocox;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LocalLanguage {

    private Context myContext;

    public LocalLanguage(){

    }

    public void setLangauge(Context context){
        myContext = context;
        setLocale(loadLocale(myContext));
    }

    public String loadLocale(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String lang = sharedPreferences.getString("lang", "da");
        System.out.println("lang: " + lang + " loaded");
        return lang;
    }

    public void setLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        Locale myLocale = new Locale(lang);
        Locale.setDefault(myLocale);

        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;

        myContext.getResources().updateConfiguration(config, myContext.getResources().getDisplayMetrics());
    }
}
