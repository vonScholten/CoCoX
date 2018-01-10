package gr04.cocox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageButton home;
    public ImageButton retur;

    public ImageButton selected;

    int[] set_1 = {
            R.id.mem1,
            R.id.mem2,
            R.id.mem3
    };

    int[] set_2 = {
            R.id.mem4,
            R.id.mem5,
            R.id.mem6
    };

    ArrayList<ImageButton> array_1 = new ArrayList<ImageButton>(set_1.length);
    ArrayList<ImageButton> array_2 = new ArrayList<ImageButton>(set_2.length);

    int i0;
    int i1;
    int i2;
    int flipCount;
    int matchCount;
    int winningNbr;

    boolean isSet_i1;
    boolean isSet_i2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        System.out.println("----------------------|MemoryGame|---------------------- \n started");

        home = (ImageButton) findViewById(R.id.home);
        retur = (ImageButton) findViewById(R.id.retur);

        System.out.println("INITIAL SETUP");

        i1 = set_1.length+1;
        isSet_i1 = false;
        i2 = set_1.length+1;
        isSet_i2 = false;
        flipCount = 0;
        matchCount = 0;
        winningNbr = set_1.length;

        setCards();
    }

    @Override
    public void onClick(View view) {
        if(view == retur) {
            finish();
        }
        else if (view == home) {
            this.startActivity(new Intent(this,MainActivity.class));
        }
        else { game(view); }
    }

    public void setCards(){
        System.out.println("setCards ");
        for (int id : set_1) {
            ImageButton card = findViewById(id);
            card.setOnClickListener(this);
            array_1.add(card);
            System.out.println("ADDED -> card nr: " + array_1.indexOf(card) + " in set 1");
        }
        for (int id : set_2) {
            ImageButton card = findViewById(id);
            card.setOnClickListener(this);
            array_2.add(card);
            System.out.println("ADDED -> card nr: " + array_2.indexOf(card) + " in set 2");
        }
    }

    public void game (View view){
        System.out.println("view id: " + view.getId());

        selected = findViewById(view.getId());

        switch (view.getId()) {
            case R.id.mem1:
                logic(index(selected));
                break;

            case R.id.mem2:
                logic(index(selected));
                break;

            case R.id.mem3:
                logic(index(selected));
                break;

            case R.id.mem4:
                logic(index(selected));
                break;

            case R.id.mem5:
                logic(index(selected));
                break;

            case R.id.mem6:
                logic(index(selected));
                break;
        }

        if (flipCount == 2) {
            System.out.println("update on flip nr 3");
            update();
        }
    }

    public int index(ImageButton ib) {
        System.out.println("INDEX -> ");
        if (array_1.contains(ib)) {
            i0 = array_1.indexOf(ib);
            System.out.println("is " + i0 + " in array 1");
        }
        else if (array_2.contains(ib)) {
            i0 = array_2.indexOf(ib);
            System.out.println("is " + i0 + " in array 2");
        }
        return i0;
    }

    public void logic(int i) {
        System.out.println("LOGIC -> ");
        System.out.println("flip nr: " + flipCount);
        if (!selected.isSelected()) {
            flipCount = flipCount + 1;
            selected.setSelected(true);
            if (!isSet_i1) {
                i1 = i;
                isSet_i1 = true;
                System.out.println("i1 ");
            } else if (!isSet_i2) {
                i2 = i;
                isSet_i2 = true;
                System.out.println("i2 ");
            }
            check(i1, i2);
        }
        else { System.out.println("is selected"); }
    }

    public void check(int i, int j) {
        System.out.println("CHECK -> " +
                "\n array size: " + array_1.size() + " & " + array_2.size());

        if (isSet_i1 && isSet_i2) {
            System.out.println("index: " + i  + " & " + j);
            if (i == j) {
                matchCount = matchCount + 1;
                System.out.println("MATCH nr " + matchCount + " found");

                array_1.remove(i);
                System.out.println("REMOVE -> card nr: " + i + " in array 1");
                array_2.remove(j);
                System.out.println("REMOVE -> card nr: " + j + " in array 2");

                update();

                if (matchCount == winningNbr){ gameWon(); }
            }
        }
    }

    public void update() {
        System.out.println("UPDATE -> ");

        for (int i = 0; i < array_1.size(); i++) {
            array_1.get(i).setSelected(false);
        }
        for (int i = 0; i < array_2.size(); i++) {
            array_2.get(i).setSelected(false);
        }

        i1 = set_1.length+1;
        isSet_i1 = false;
        i2 = set_1.length+1;
        isSet_i2 = false;
        flipCount = 0;
    }

    public void gameWon() {
        System.out.println("GAME WON \n ----------------------|MemoryGame|----------------------");
    }
}



