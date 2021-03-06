package gr04.cocox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class PuzzleActivity extends AppCompatActivity implements View.OnClickListener {

    public LocalLanguage lang = new LocalLanguage();

    public Button hint;
    public Button call;

    public ImageButton retur;
    public ImageButton home;

    private int index;
    private boolean check;

    private int[] image_ID = {
            R.id.puzzle1,
            R.id.puzzle2,
            R.id.puzzle3,
            R.id.puzzle4,
            R.id.puzzle5,
            R.id.puzzle6,
    };

    private boolean[] filled = {
            false,
            false,
            false,
            false,
            false,
            false
    };

    private int[] draw = {
            R.drawable.puzzlecat1,
            R.drawable.puzzlecat2,
            R.drawable.puzzlecat3,
            R.drawable.puzzlecat4,
            R.drawable.puzzlecat5,
            R.drawable.puzzlecat6
    };

    private int[] grid_ID = {
            R.id.puzzle7,
            R.id.puzzle8,
            R.id.puzzle9,
            R.id.puzzle10,
            R.id.puzzle11,
            R.id.puzzle12
    };

    private ArrayList<ImageView> empty = new ArrayList<>(grid_ID.length);
    private ArrayList<ImageView> pieces = new ArrayList<>(image_ID.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lang.setLangauge(this); //change language from sharedPreferences BEFORE setContentView!
        setContentView(R.layout.activity_puzzle);

        retur = findViewById(R.id.retur);
        retur.setOnClickListener(this);

        home = findViewById(R.id.home);
        home.setOnClickListener(this);

        call = findViewById(R.id.call);
        call.setOnClickListener(this);

        hint = findViewById(R.id.hint);
        hint.setOnClickListener(this);

        for (int id : image_ID){
            ImageView iv = findViewById(id);
            iv.setOnClickListener(this);
            iv.setTag(id);
            pieces.add(iv);
        }
        for (int id : grid_ID){
            ImageView iv = findViewById(id);
            iv.setOnClickListener(this);
            iv.setTag(id);
            empty.add(iv);
        }
    }

    @Override
    public void onClick(View view) {

        if(view == retur) {
            finish();
        }

        else if (view == home) {
            startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }

        else if(view==call){
            startActivity(new Intent(this, CallActivity.class));
        }

        else if(view==hint){
            showImage();
        }

        else {
            switch (view.getId()) {
                case R.id.puzzle1:
                    checkPiecesArray(view);
                    break;
                case R.id.puzzle2:
                    checkPiecesArray(view);
                    break;
                case R.id.puzzle3:
                    checkPiecesArray(view);
                    break;
                case R.id.puzzle4:
                    checkPiecesArray(view);
                    break;
                case R.id.puzzle5:
                    checkPiecesArray(view);
                    break;
                case R.id.puzzle6:
                    checkPiecesArray(view);
                    break;
                case R.id.puzzle7:
                    checkGridArray(view);
                    break;
                case R.id.puzzle8:
                    checkGridArray(view);
                    break;
                case R.id.puzzle9:
                    checkGridArray(view);
                    break;
                case R.id.puzzle10:
                    checkGridArray(view);
                    break;
                case R.id.puzzle11:
                    checkGridArray(view);
                    break;
                case R.id.puzzle12:
                    checkGridArray(view);
                    break;
            }
        }
    }

    public void checkGridArray(View view){

      for(int i =0; i<empty.size(); i++) {
          if (view.getId() == empty.get(i).getId()) {
              index = i;
          }
          else if (!filled[i]) {
              ImageView temp1 = findViewById(empty.get(i).getId());
              temp1.setImageResource(R.drawable.puzzleborder);
          }
      }

      if (filled[index]) {
          ImageView temp1 = findViewById(empty.get(index).getId());
          temp1.setImageResource(R.drawable.puzzlemarked);
          filled[index] = false;
      }
      else{
          ImageView v = (ImageView) view;
          v.setImageResource(R.drawable.puzzlemarked);
      }
      check = true;
    }

    public void checkPiecesArray(View view){
        for (int i = 0; i < pieces.size(); i++){

            ImageView temp1 = findViewById(empty.get(index).getId());
            if ((view.getId() == pieces.get(i).getId()) && check){

                temp1.setImageResource(draw[i]);

                if (filled[index] == false) {
                    filled[index] = true;
                }
            }
            else if ((view.getId() == pieces.get(i).getId()) && check && filled[index] == true) {
                        filled[index] = false;
            }
        }
    }

    public void showImage() {
        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.puzzlecat);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }

    public void checkIfCorrect(View view){

    }
    }

