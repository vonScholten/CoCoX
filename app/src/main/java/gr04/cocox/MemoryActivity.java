package gr04.cocox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity implements View.OnClickListener {


    public ImageButton cardmem1;
    public ImageButton cardmem2;
    public ImageButton cardmem3;
    public ImageButton cardmem4;
    public ImageButton cardmem5;
    public ImageButton cardmem6;

    public ImageButton home;
    public ImageButton retur;
    public Button selected;
    public Button refresh;


    int[] btn_ID = {
            R.id.mem1,
            R.id.mem2,
            R.id.mem3,
            R.id.mem4,
            R.id.mem5,
            R.id.mem6,
    };

    int activeIndex;

    ArrayList<Button> cards = new ArrayList<>(btn_ID.length);

    Integer[] cardsArray = {1, 2, 3, 11, 22, 33};

    int memcar1, memcat2, memtree3, memcar11, memcar22, memcar33;

    int card1, card2;
    int clickedFirst, clickedSecond;
    int cardnumber = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);


        cardmem1 = (ImageButton) findViewById(R.id.mem1);
        cardmem2 = (ImageButton) findViewById(R.id.mem2);
        cardmem3 = (ImageButton) findViewById(R.id.mem3);
        cardmem4 = (ImageButton) findViewById(R.id.mem4);
        cardmem5 = (ImageButton) findViewById(R.id.mem5);
        cardmem6 = (ImageButton) findViewById(R.id.mem6);

        home = (ImageButton) findViewById(R.id.home);
        retur = (ImageButton) findViewById(R.id.retur);

        cardmem1.setOnClickListener(this);
        cardmem2.setOnClickListener(this);
        cardmem3.setOnClickListener(this);
        cardmem4.setOnClickListener(this);
        cardmem5.setOnClickListener(this);
        cardmem6.setOnClickListener(this);


 /*       for (int id : btn_ID){
            Button card = findViewById(id);
            card.setOnClickListener(this);
            cards.add(card);
        }
        */

    }

    @Override
    public void onClick(View view) {

     /*   for (int id : btn_ID){

            if(id == view.getId()){
                cards.add(selected);
                selected = findViewById(id);
            }
        }
        */



        switch (view.getId()) {
            case R.id.mem1:
                System.out.println("1");
                if (!cardmem1.isSelected()) {
                    System.out.println("2");
                    cardmem1.setSelected(true);
                }
                else cardmem1.setSelected(false);
                break;

            case R.id.mem2:
                if (!cardmem2.isSelected()) {
                    cardmem2.setSelected(true);
                }
                else cardmem2.setSelected(false);
                break;

            case R.id.mem3:
                if (!cardmem3.isSelected()) {
                    cardmem3.setSelected(true);
                }
                else cardmem3.setSelected(false);
                break;

            case R.id.mem4:
                if (!cardmem4.isSelected()) {
                    cardmem4.setSelected(true);
                }
                else cardmem4.setSelected(false);
                break;

            case R.id.mem5:
                if (!cardmem5.isSelected()) {
                    cardmem5.setSelected(true);
                }
                else cardmem5.setSelected(false);
                break;

            case R.id.mem6:
                if (!cardmem6.isSelected()) {
                    cardmem6.setSelected(true);
                } else cardmem6.setSelected(false);
                break;
        }

    }

/*    public void update() {

        int i;
        while(i<2) {
            i++;
            selected.setSelected(true); //Set button selected state as true
        }

        i = 0;

        for (int id : btn_ID) {
            if(cards.contains(findViewById(id))) {
                refresh = findViewById(id);
                refresh.setSelected(false); //Set button selected state as false
            }
        }
        */
    }



