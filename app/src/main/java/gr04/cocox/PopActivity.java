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
import java.util.Random;


public class PopActivity extends AppCompatActivity implements View.OnClickListener{

    public GridLayout popGrid;
    public int balloons = R.drawable.balloons;
    public int explosions = R.drawable.explosion;
    public ImageButton home;
    public ImageButton retur;
    public ImageButton clicked;
    Button call;
    public Random rand = new Random();
    public int counter = 0;



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
        ArrayList <ImageButton> items = new ArrayList<ImageButton>();

        for(int i=0; i<10; i++){
            ImageButton blop = new ImageButton(this);
            GridLayout.LayoutParams para = new GridLayout.LayoutParams();
            para.setMargins(1,1,1,1);
            blop.setImageResource(R.drawable.pop_selector);
            blop.setLayoutParams(para);
            blop.setTag(1);
            blop.setMaxWidth(40);
            blop.setMaxHeight(40);
            blop.setBackgroundColor(Color.TRANSPARENT);
            blop.setOnClickListener(this);
            items.add(blop);
        }
        for(int i=0;i<40;i++){
            ImageButton empty = new ImageButton(this);
            GridLayout.LayoutParams para = new GridLayout.LayoutParams();
            para.setMargins(1,1,1,1);
            empty.setLayoutParams(para);
            empty.setTag(0);
            empty.setMaxWidth(40);
            empty.setMaxHeight(40);
            empty.setBackgroundColor(Color.TRANSPARENT);
            items.add(empty);
            }

        Collections.shuffle(items);

        for(ImageButton ib: items){
            popGrid.addView(ib);
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
            clicked = (ImageButton) view;
            clicked.setSelected(true);
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
