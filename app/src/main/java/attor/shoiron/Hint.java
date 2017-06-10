package attor.shoiron;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by moses on 19/02/2017.
 */
public class Hint extends MainActivity {

    SharedPreferences h_sharedPreferences;
    SharedPreferences.Editor h_editor;
    RelativeLayout rl_expose,rl_remove,rl_solve;

    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint);

        sharedPreferences = getSharedPreferences("PlayerInfo",0);
        editor = sharedPreferences.edit();

        rl_expose = (RelativeLayout)findViewById(R.id.rl_expose_letter);
        rl_remove = (RelativeLayout)findViewById(R.id.rl_remove_letter);
        rl_solve = (RelativeLayout)findViewById(R.id.rl_solve_the_question);

        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);
        t3 = (TextView)findViewById(R.id.textView3);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/AmericanTypewriter.ttc");


        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);

        rl_expose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coin>=15){
                    editor.putBoolean("expose", true);
                    editor.apply();
                    onBackPressed();
                }
            }
        });

        rl_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coin>=15){
                    editor.putBoolean("remove", true);
                    editor.apply();
                    onBackPressed();
                }
            }
        });

        rl_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (coin>=30){
                    editor.putBoolean("solve",true);
                    editor.apply();
                    onBackPressed();
                }
            }
        });
    }

}
