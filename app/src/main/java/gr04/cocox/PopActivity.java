package gr04.cocox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Collections;

public class PopActivity extends AppCompatActivity implements View.OnClickListener{

    public GridLayout popGrid;

    public ImageButton home;
    public ImageButton retur;

    public Button call;

    private int counter = 0;

    private ArrayList <ImageButton> items = new ArrayList<ImageButton>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        home = findViewById(R.id.pop_home);
        home.setOnClickListener(this);

        retur = findViewById(R.id.pop_back);
        retur.setOnClickListener(this);

        call = findViewById(R.id.call);
        call.setOnClickListener(this);

        popGrid = (GridLayout) findViewById(R.id.popGrid);

        createBalloon();
        createEmpty();

        Collections.shuffle(items);

        for(ImageButton ib: items){
            popGrid.addView(ib);
        }
    }

    public void createBalloon(){
        for(int i=0; i<10; i++){
            ImageButton balloon = new ImageButton(this);
            GridLayout.LayoutParams para = new GridLayout.LayoutParams();
            para.setMargins(1,1,1,1);
            balloon.setLayoutParams(para);
            balloon.setImageResource(R.drawable.pop_selector);
            balloon.setMaxWidth(40);
            balloon.setMaxHeight(40);
            balloon.setBackgroundColor(Color.TRANSPARENT);
            balloon.setOnClickListener(this);
            items.add(balloon);
        }
    }

    public void createEmpty(){
        for(int i=0;i<40;i++){
            ImageButton empty = new ImageButton(this);
            GridLayout.LayoutParams para = new GridLayout.LayoutParams();
            para.setMargins(1,1,1,1);
            empty.setLayoutParams(para);
            empty.setMaxWidth(40);
            empty.setMaxHeight(40);
            empty.setBackgroundColor(Color.TRANSPARENT);
            items.add(empty);
        }
    }

    @Override
    public void onClick(View view) {
        if(view==home){
            startActivity(new Intent(this, MainActivity.class));
        }
        else if(view==retur){
            finish();
        }
        else if(view==call){
            startActivity(new Intent(this, CallActivity.class));
        }
        else{
            view.setSelected(true);
            counter++;
            check();
        }
    }

    public void check(){
        if(counter==10){
            startActivity(new Intent(this, WinnerActivity.class));
            finish();
        }
    }
}
