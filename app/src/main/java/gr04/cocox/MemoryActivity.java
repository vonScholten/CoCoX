package gr04.cocox;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryActivity extends AppCompatActivity implements View.OnClickListener {

    public GridLayout grid;

    Button call;

    public ImageButton backHome;
    public ImageButton back;

    public ImageButton selected;

    int[] set = {
            R.id.mem1,
            R.id.mem2,
            R.id.mem3,
            R.id.mem4,
            R.id.mem5,
            R.id.mem6
    };

    int[] deck = {
            R.drawable.mem1_selector,
            R.drawable.mem2_selector,
            R.drawable.mem3_selector
    };

    ArrayList<ImageButton> listSet = new ArrayList<ImageButton>(set.length);
    ArrayList<Integer> listDeck = new ArrayList<Integer>(deck.length);

    int i0;
    int tag1;
    int tag2;
    int index1;
    int index2;
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


        grid = findViewById(R.id.board);

        back = findViewById(R.id.memory_back);
        back.setOnClickListener(this);

        backHome = findViewById(R.id.memory_home);
        backHome.setOnClickListener(this);

        call = findViewById(R.id.call);
        call.setOnClickListener(this);

        System.out.println("INITIAL SETUP");

        tag1 = 0;
        isSet_i1 = false;
        tag2 = 0;
        isSet_i2 = false;
        flipCount = 0;
        matchCount = 0;
        winningNbr = deck.length;

        shuffle();
        setCards();
    }

    @Override
    public void onClick(View view) {
        if(view == back) {
            this.startActivity(new Intent(this, GameActivity.class));
            finish();
        }
        else if (view == backHome) {
            this.startActivity(new Intent(this,MainActivity.class));
            finish();
        }

        else if(view==call){
            startActivity(new Intent(this, CallActivity.class));
        }
        else { game(view); }
    }

    public void setCards(){
        System.out.println("setCards ");

        int i = 0;
        for (int id : set){
            ImageButton card = findViewById(id);
            card.setOnClickListener(this);

            card.setImageResource(listDeck.get(i));
            card.setTag(listDeck.get(i));

            listSet.add(card);

            i = i + 1;
            System.out.println("ADDED -> card tag: " + card.getTag() + " on index " + i);
        }
    }

    public void shuffle() {
        for (int i = 0; i < 2; i++) {
            for (int id : deck) {
                listDeck.add(id);
            }
        }
        System.out.println("Deck size is: " + listDeck.size());
        Collections.shuffle(listDeck);
    }

    public void game (View view){
        System.out.println("view id: " + view.getId());

        selected = findViewById(view.getId());
        int tag = (int) selected.getTag();
        int index = listSet.indexOf(selected);
        System.out.println("tag: " + tag);
        logic(tag,index);

        if (flipCount == 3) {
            System.out.println("update on flip nr 3");
            update();
        }
    }

    public void logic(int tag, int index) {
        System.out.println("LOGIC -> ");
        System.out.println("flip nr: " + flipCount);

        if (!selected.isSelected()) {
            flipCount = flipCount + 1;
            selected.setSelected(true);
            if (!isSet_i1) {
                tag1 = tag;
                index1 = index;
                isSet_i1 = true;
                System.out.println("tag1 " + tag1 + "index " + index1);
            } else if (!isSet_i2) {
                tag2 = tag;
                index2 = index;
                isSet_i2 = true;
                System.out.println("tag2 " + tag2 + "index " + index2);
            }
            check(tag1, tag2, index1, index2);
        }
        else { System.out.println("is selected"); }
    }

    public void check(int tag1, int tag2, int index1, int index2) {
        System.out.println("CHECK -> ");

        if (isSet_i1 && isSet_i2) {
            System.out.println("id: " + tag1  + " & " + tag2);
            if (tag1 == tag2) {
                matchCount = matchCount + 1;
                System.out.println("MATCH nr " + matchCount + " found");
                Toast.makeText(this, R.string.found_match,
                        Toast.LENGTH_LONG).show();

                for (int id : set) {
                    ImageButton card = findViewById(id);
                    int i = (int) card.getTag();
                    if(tag1 == i){
                        card.setBackgroundColor(Color.GRAY);
                        listSet.remove(listSet.indexOf(card));
                        System.out.println("REMOVE -> card  with id: " + tag1);
                    }
                }

                if(matchCount == winningNbr) { gameWon(); }
                else { update(); }
            }
        }
    }

    public void update() {
        System.out.println("UPDATE -> ");

        for (int i = 0; i < listSet.size(); i++) {
            listSet.get(i).setSelected(false);
        }

        tag1 = 0;
        isSet_i1 = false;
        tag2 = 0;
        isSet_i2 = false;
        flipCount = 0;
    }

    public void gameWon() {
        System.out.println("GAME WON \n ----------------------|MemoryGame|----------------------");

        startActivity(new Intent(this, WinnerActivity.class));
        finish();
    }
}



