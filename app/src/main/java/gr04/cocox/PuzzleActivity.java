package gr04.cocox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class PuzzleActivity extends AppCompatActivity implements View.OnClickListener {

    Button hint;

    int[] image_ID = {
            R.id.puzzle1,
            R.id.puzzle2,
            R.id.puzzle3,
            R.id.puzzle4,
            R.id.puzzle5,
            R.id.puzzle6,
    };

    int[] grid_ID = {
            R.id.puzzle7,
            R.id.puzzle8,
            R.id.puzzle9,
            R.id.puzzle10,
            R.id.puzzle11,
            R.id.puzzle12
    };

    ArrayList<ImageView> empty = new ArrayList<>(grid_ID.length);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        for (int id : image_ID){
            ImageView iv = findViewById(id);
            iv.setOnClickListener(this);
        }
        for (int id : grid_ID){
            ImageView iv = findViewById(id);
            iv.setOnClickListener(this);
            empty.add(iv);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.puzzle1 :
                break;
            case R.id.puzzle2 :
                break;
            case R.id.puzzle3 :
                break;
            case R.id.puzzle4 :
                break;
            case R.id.puzzle5 :
                break;
            case R.id.puzzle6 :
                break;
            case R.id.puzzle7 :
                break;
            case R.id.puzzle8 :
                break;
            case R.id.puzzle9 :
                break;
            case R.id.puzzle10 :
                break;
            case R.id.puzzle11 :
                break;
            case R.id.puzzle12 :
                break;
        }

    }

    public void update(View view){
        for (int id : grid_ID){

        }
    }

    public void checkArray(View view){
        for(int i =0; i<empty.size(); i++){
            if (view.getId() == empty.get(i).getId()) {

            }

        }
    }
}
