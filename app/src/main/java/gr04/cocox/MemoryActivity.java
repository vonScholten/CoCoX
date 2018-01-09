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

    ImageButton clicked_1;
    ImageButton clicked_2;
    int indexOfFirst;
    int indexOfSecond;

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

        for (int id : set_1){
            ImageButton button = findViewById(id);
            button.setOnClickListener(this);
            array_1.add(button);
            System.out.println(array_1.indexOf(button));
        }
        for (int id : set_2){
            ImageButton button = findViewById(id);
            button.setOnClickListener(this);
            array_2.add(button);
            System.out.println(array_2.indexOf(button));
        }


    }

    @Override
    public void onClick(View view) {

        selected = findViewById(view.getId());
        System.out.println(view.getId());

        switch (view.getId()) {
            case R.id.mem1:
                selected.setSelected(true);
                if(clicked_1 == null){
                    clicked_1 = selected;
                }
                else if(clicked_2 == null){
                    clicked_2 = selected;
                }
                System.out.println(clicked_1 + ", " + clicked_2);
                check(clicked_1, clicked_2);
                break;

            case R.id.mem2:
                selected.setSelected(true);
                if(clicked_1 == null){
                    clicked_1 = selected;
                }
                else if(clicked_2 == null){
                    clicked_2 = selected;
                }
                System.out.println(clicked_1 + ", " + clicked_2);
                check(clicked_1, clicked_2);
                break;

            case R.id.mem3:
                selected.setSelected(true);
                if(clicked_1 == null){
                    clicked_1 = selected;
                }
                else if(clicked_2 == null){
                    clicked_2 = selected;
                }
                System.out.println(clicked_1 + ", " + clicked_2);
                check(clicked_1, clicked_2);
                break;

            case R.id.mem4:
                selected.setSelected(true);
                if(clicked_1 == null){
                    clicked_1 = selected;
                }
                else if(clicked_2 == null){
                    clicked_2 = selected;
                }
                System.out.println(clicked_1 + ", " + clicked_2);
                check(clicked_1, clicked_2);
                break;

            case R.id.mem5:
                selected.setSelected(true);
                if(clicked_1 == null){
                    clicked_1 = selected;
                }
                else if(clicked_2 == null){
                    clicked_2 = selected;
                }
                System.out.println(clicked_1 + ", " + clicked_2);
                check(clicked_1, clicked_2);
                break;

            case R.id.mem6:
                selected.setSelected(true);
                if(clicked_1 == null){
                    clicked_1 = selected;
                }
                else if(clicked_2 == null){
                    clicked_2 = selected;
                }
                System.out.println(clicked_1 + ", " + clicked_2);
                check(clicked_1, clicked_2);
                break;
        }
    }

    public void check(ImageButton first, ImageButton second){

        if(array_1.contains(first)){
            indexOfFirst = array_1.indexOf(first);
            System.out.println(indexOfFirst);
        }
        else if(array_2.contains(first)){
            indexOfFirst = array_1.indexOf(first);
            System.out.println(indexOfFirst);
        }

        if(array_1.contains(second)){
            indexOfSecond = array_1.indexOf(second);
            System.out.println(indexOfSecond);
        }
        else if(array_2.contains(second)){
            indexOfSecond = array_1.indexOf(second);
            System.out.println(indexOfSecond);
        }

        if(indexOfFirst == indexOfSecond){
            System.out.println("yEAEea!");
        }

    }
}



