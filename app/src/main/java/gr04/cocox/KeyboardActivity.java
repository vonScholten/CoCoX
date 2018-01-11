package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KeyboardActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton back;
    ImageButton backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        back = (ImageButton) findViewById(R.id.keyboard_back);
        back.setOnClickListener(this);
        backHome = (ImageButton) findViewById(R.id.keyboard_home);
        backHome.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view == back){
            finish();
        }
        else if (view == backHome){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

    }
}
