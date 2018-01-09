package gr04.cocox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity implements View.OnClickListener {


    /*
    public ImageButton cardmem1;
    public ImageButton cardmem2;
    public ImageButton cardmem3;
    public ImageButton cardmem4;
    public ImageButton cardmem5;
    public ImageButton cardmem6;
    */

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

    int indexOf;
    int first = set_1.length;
    int second = set_2.length;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        /*
        cardmem1 = (ImageButton) findViewById(R.id.mem1);
        cardmem2 = (ImageButton) findViewById(R.id.mem2);
        cardmem3 = (ImageButton) findViewById(R.id.mem3);
        cardmem4 = (ImageButton) findViewById(R.id.mem4);
        cardmem5 = (ImageButton) findViewById(R.id.mem5);
        cardmem6 = (ImageButton) findViewById(R.id.mem6);
        */

        home = (ImageButton) findViewById(R.id.home);
        retur = (ImageButton) findViewById(R.id.retur);

        /*
        cardmem1.setOnClickListener(this);
        cardmem2.setOnClickListener(this);
        cardmem3.setOnClickListener(this);
        cardmem4.setOnClickListener(this);
        cardmem5.setOnClickListener(this);
        cardmem6.setOnClickListener(this);
        */

        for (int id : set_1) {
            ImageButton button = findViewById(id);
            button.setOnClickListener(this);
            array_1.add(button);
            System.out.println(array_1.indexOf(button));
        }
        for (int id : set_2) {
            ImageButton button = findViewById(id);
            button.setOnClickListener(this);
            array_2.add(button);
            System.out.println(array_2.indexOf(button));
        }


    }

    @Override
    public void onClick(View view) {

        count = count + 1;

        System.out.println(view.getId());
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

        if (count == 2) {
            update();
            count = 0;
        }
    }

    public int index(ImageButton ib) {
        if (array_1.contains(ib)) {
            indexOf = array_1.indexOf(ib);
        }
        else if (array_2.contains(ib)) {
            indexOf = array_2.indexOf(ib);
        }
        System.out.println(indexOf);
        return indexOf;
    }

    public void logic(int i) {
        selected.setSelected(true);
        if (first == set_1.length) {
            first = i;
        } else if (second == set_2.length) {
            second = i;
        }
        check(first, second);
    }

    public void check(int i, int j) {
        System.out.println(i + ", " + j);

        if (i == j) {
            System.out.println("yEAEea!");
            array_1.remove(i);
            array_2.remove(i);
        }

    }

    public void update() {

        for (int i = 0; i < array_1.size(); i++) {
            array_1.get(i).setSelected(false);
        }
        for (int i = 0; i < array_2.size(); i++) {
            array_2.get(i).setSelected(false);
        }

        first = set_1.length;
        second = set_2.length;
    }
}



