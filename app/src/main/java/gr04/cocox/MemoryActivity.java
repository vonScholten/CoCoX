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

    int clicked_1;
    int clicked_2;

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

    ArrayList<Integer> array_1 = new ArrayList<>(set_1.length);
    ArrayList<Integer> array_2 = new ArrayList<>(set_2.length);

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

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mem1:
                cardmem1.setSelected(true);
                if(clicked_1 != 0){
                    clicked_1 = R.id.mem1;
                }
                else if(clicked_2 != 0){
                    clicked_2 = R.id.mem1;
                }
                check(clicked_1, clicked_2);
                break;

            case R.id.mem2:
                cardmem2.setSelected(true);
                if(clicked_1 != 0){
                    clicked_1 = R.id.mem1;
                }
                else if(clicked_2 != 0){
                    clicked_2 = R.id.mem1;
                }
                check(clicked_1, clicked_2);
                break;

            case R.id.mem3:
                cardmem3.setSelected(true);
                if(clicked_1 != 0){
                    clicked_1 = R.id.mem1;
                }
                else if(clicked_2 != 0){
                    clicked_2 = R.id.mem1;
                }
                check(clicked_1, clicked_2);
                break;

            case R.id.mem4:
                cardmem4.setSelected(true);
                if(clicked_1 != 0){
                    clicked_1 = R.id.mem1;
                }
                else if(clicked_2 != 0){
                    clicked_2 = R.id.mem1;
                }
                check(clicked_1, clicked_2);
                break;

            case R.id.mem5:
                cardmem5.setSelected(true);
                if(clicked_1 != 0){
                    clicked_1 = R.id.mem1;
                }
                else if(clicked_2 != 0){
                    clicked_2 = R.id.mem1;
                }
                check(clicked_1, clicked_2);
                break;

            case R.id.mem6:
                cardmem6.setSelected(true);
                if(clicked_1 != 0){
                    clicked_1 = R.id.mem1;
                }
                else if(clicked_2 != 0){
                    clicked_2 = R.id.mem1;
                }
                check(clicked_1, clicked_2);
                break;
        }
    }

    public void check(int first, int second){

        if(array_1.indexOf(first) == array_2.indexOf(second)){
            System.out.println("yEAEea!");
        }

    }
}



