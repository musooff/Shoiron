package attor.shoiron;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public String result,attempt,indexes_str,alphabet_str,string_version_of_chars="";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String[] answers = {"РӮДАКӢ","ФИРДАВСӢ","БЕДИЛ","ҶОМӢ","СИНО","АТТОР","ҲИЛОЛӢ","ГАНҶАВӢ","ХУҶАНДӢ","ЗЕБУНИССО","ВОСИФӢ","САЪДӢ","ХАЙЁМ","ЗОКОНӢ","ДЕҲЛАВӢ","ҲОФИЗ","ТАБРЕЗӢ","ХУСРАВ","ҒАЗЗОЛӢ","ТӮСӢ","АНВАРӢ","ВАТВОТ","НАВОӢ","ГУЛШАНӢ","БАЛХӢ"};
    ImageView[] chars,dashes,imageViews;
    char[] char_string;
    Button nl,pl;
    final int[] count = {0};
    TextView textViewLevel,textViewCoin;
    Character[] alphabet_char_array = {'А','Б','В','Г','Ғ','Д','Е','Ё','Ж','З','И','Ӣ','Й','К','Қ','Л','М','Н','О','П','Р','С','Т','У','Ӯ','Ф','Х','Ҳ','Ч','Ҷ','Ш','Ъ','Э','Ю','Я'};
    Integer[] char_alphabet = {
            R.drawable.icon_char_a_40,
            R.drawable.icon_char_b_40,
            R.drawable.icon_char_v_40,
            R.drawable.icon_char_g_40,
            R.drawable.icon_char_gh_40,
            R.drawable.icon_char_d_40,
            R.drawable.icon_char_e_40,
            R.drawable.icon_char_yo_40,
            R.drawable.icon_char_zh_40,
            R.drawable.icon_char_z_40,
            R.drawable.icon_char_i_40,
            R.drawable.icon_char_ii_40,
            R.drawable.icon_char_y_40,
            R.drawable.icon_char_k_40,
            R.drawable.icon_char_q_40,
            R.drawable.icon_char_l_40,
            R.drawable.icon_char_m_40,
            R.drawable.icon_char_n_40,
            R.drawable.icon_char_o_40,
            R.drawable.icon_char_p_40,
            R.drawable.icon_char_r_40,
            R.drawable.icon_char_c_40,
            R.drawable.icon_char_t_40,
            R.drawable.icon_char_u_40,
            R.drawable.icon_char_uu_40,
            R.drawable.icon_char_f_40,
            R.drawable.icon_char_x_40,
            R.drawable.icon_char_h_40,
            R.drawable.icon_char_ch_40,
            R.drawable.icon_char_j_40,
            R.drawable.icon_char_w_40,
            R.drawable.icon_char_al_40,
            R.drawable.icon_char_ae_40,
            R.drawable.icon_char_yu_40,
            R.drawable.icon_char_ya_40
    };
    Integer[] dash_alphabet = {
            R.drawable.dash_chars_a,
            R.drawable.dash_chars_b,
            R.drawable.dash_chars_v,
            R.drawable.dash_chars_g,
            R.drawable.dash_chars_gh,
            R.drawable.dash_chars_d,
            R.drawable.dash_chars_e,
            R.drawable.dash_chars_yo,
            R.drawable.dash_chars_zh,
            R.drawable.dash_chars_z,
            R.drawable.dash_chars_i,
            R.drawable.dash_chars_ii,
            R.drawable.dash_chars_y,
            R.drawable.dash_chars_k,
            R.drawable.dash_chars_q,
            R.drawable.dash_chars_l,
            R.drawable.dash_chars_m,
            R.drawable.dash_chars_n,
            R.drawable.dash_chars_o,
            R.drawable.dash_chars_p,
            R.drawable.dash_chars_r,
            R.drawable.dash_chars_c,
            R.drawable.dash_chars_t,
            R.drawable.dash_chars_u,
            R.drawable.dash_chars_uu,
            R.drawable.dash_chars_f,
            R.drawable.dash_chars_x,
            R.drawable.dash_chars_h,
            R.drawable.dash_chars_ch,
            R.drawable.dash_chars_j,
            R.drawable.dash_chars_w,
            R.drawable.dash_chars_al,
            R.drawable.dash_chars_ae,
            R.drawable.dash_chars_yu,
            R.drawable.dash_chars_ya
    };

    Integer[] images = {
            R.drawable.level_1_1,
            R.drawable.level_1_2,
            R.drawable.level_1_3,
            R.drawable.level_1_4,
            R.drawable.level_2_1,
            R.drawable.level_2_2,
            R.drawable.level_2_3,
            R.drawable.level_2_4,
            R.drawable.level_3_1,
            R.drawable.level_3_2,
            R.drawable.level_3_3,
            R.drawable.level_3_4,
            R.drawable.level_4_1,
            R.drawable.level_4_2,
            R.drawable.level_4_3,
            R.drawable.level_4_4,
            R.drawable.level_5_1,
            R.drawable.level_5_2,
            R.drawable.level_5_3,
            R.drawable.level_5_4,
            R.drawable.level_6_1,
            R.drawable.level_6_2,
            R.drawable.level_6_3,
            R.drawable.level_6_4,
            R.drawable.level_7_1,
            R.drawable.level_7_2,
            R.drawable.level_7_3,
            R.drawable.level_7_4,
            R.drawable.level_8_1,
            R.drawable.level_8_2,
            R.drawable.level_8_3,
            R.drawable.level_8_4,
            R.drawable.level_9_1,
            R.drawable.level_9_2,
            R.drawable.level_9_3,
            R.drawable.level_9_4,
            R.drawable.level_10_1,
            R.drawable.level_10_2,
            R.drawable.level_10_3,
            R.drawable.level_10_4,
            R.drawable.level_11_1,
            R.drawable.level_11_2,
            R.drawable.level_11_3,
            R.drawable.level_11_4,
            R.drawable.level_12_1,
            R.drawable.level_12_2,
            R.drawable.level_12_3,
            R.drawable.level_12_4,
            R.drawable.level_13_1,
            R.drawable.level_13_2,
            R.drawable.level_13_3,
            R.drawable.level_13_4,
            R.drawable.level_14_1,
            R.drawable.level_14_2,
            R.drawable.level_14_3,
            R.drawable.level_14_4,
            R.drawable.level_15_1,
            R.drawable.level_15_2,
            R.drawable.level_15_3,
            R.drawable.level_15_4,
            R.drawable.level_16_1,
            R.drawable.level_16_2,
            R.drawable.level_16_3,
            R.drawable.level_16_4,
            R.drawable.level_17_1,
            R.drawable.level_17_2,
            R.drawable.level_17_3,
            R.drawable.level_17_4,
            R.drawable.level_18_1,
            R.drawable.level_18_2,
            R.drawable.level_18_3,
            R.drawable.level_18_4,
            R.drawable.level_19_1,
            R.drawable.level_19_2,
            R.drawable.level_19_3,
            R.drawable.level_19_4,
            R.drawable.level_20_1,
            R.drawable.level_20_2,
            R.drawable.level_20_3,
            R.drawable.level_20_4,
            R.drawable.level_21_1,
            R.drawable.level_21_2,
            R.drawable.level_21_3,
            R.drawable.level_21_4,
            R.drawable.level_22_1,
            R.drawable.level_22_2,
            R.drawable.level_22_3,
            R.drawable.level_22_4,
            R.drawable.level_23_1,
            R.drawable.level_23_2,
            R.drawable.level_23_3,
            R.drawable.level_23_4,
            R.drawable.level_24_1,
            R.drawable.level_24_2,
            R.drawable.level_24_3,
            R.drawable.level_24_4,
            R.drawable.level_25_1,
            R.drawable.level_25_2,
            R.drawable.level_25_3,
            R.drawable.level_25_4
    };

    Integer[] char_click_sound = {
            R.raw.choose_letter_01,
            R.raw.choose_letter_02,
            R.raw.choose_letter_03,
            R.raw.choose_letter_04,
            R.raw.choose_letter_05,
            R.raw.choose_letter_06,
            R.raw.choose_letter_07,
            R.raw.choose_letter_08,
            R.raw.choose_letter_08

    };
    Integer level_up_sound = R.raw.win_level,menu_click = R.raw.menu_open,wrong_answer_sound = R.raw.wrong_word_long;
    MediaPlayer mediaPlayer;

    Integer[] indexes = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    Integer char_empty,dash;
    ImageView undo,hint_button,ask_friend,coin_button;
    int level,coin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(),"ca-app-pub-8967799784519571~8542708042");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("91EA9768AB496C541B00CBD148B25849").build();
        mAdView.loadAd(adRequest);

        result = answers[level];
        attempt = "         ";
        indexes_str = "";

        // Shared Values
        sharedPreferences = getSharedPreferences("PlayerInfo", 0);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getInt("level",-1) == -1) //that means its first time entering
        {
            editor.putInt("coin", 24);
            editor.putInt("level", 0);
            editor.apply();
        }

        textViewLevel = (TextView)findViewById(R.id.textView_level);
        textViewLevel.setText((level + 1)+"");

        textViewCoin = (TextView)findViewById(R.id.textView_coin);


        alphabet_str = "АБВГҒДЕЁЖЗИӢЙКҚЛМНОПРСТУӮФХҲЧҶШЪЭЮЯ";

        char_empty = R.drawable.icon_char_empty;
        dash = R.drawable.dash;
        chars = new ImageView[13];
        dashes = new ImageView[9];
        imageViews = new ImageView[4];
        char_string = new char[13];

        undo = (ImageView)findViewById(R.id.undo);
        coin_button = (ImageView)findViewById(R.id.button_coins_main);
        coin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getCoins = new Intent(getApplicationContext(),GetCoins.class);
                startActivity(getCoins);
            }
        });

        chars[0] = (ImageView)findViewById(R.id.char_0);
        chars[1] = (ImageView)findViewById(R.id.char_1);
        chars[2] = (ImageView)findViewById(R.id.char_2);
        chars[3] = (ImageView)findViewById(R.id.char_3);
        chars[4] = (ImageView)findViewById(R.id.char_4);
        chars[5] = (ImageView)findViewById(R.id.char_5);
        chars[6] = (ImageView)findViewById(R.id.char_6);
        chars[7] = (ImageView)findViewById(R.id.char_7);
        chars[8] = (ImageView)findViewById(R.id.char_8);
        chars[9] = (ImageView)findViewById(R.id.char_9);
        chars[10] = (ImageView)findViewById(R.id.char_10);
        chars[11] = (ImageView)findViewById(R.id.char_11);
        chars[12] = (ImageView)findViewById(R.id.char_12);




        hint_button = (ImageView)findViewById(R.id.hint_button);
        hint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), menu_click);
                mediaPlayer.start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent hint = new Intent(MainActivity.this, Hint.class);
                        startActivity(hint);
                    }
                }, 100);


            }
        });

        ask_friend = (ImageView)findViewById(R.id.ask_friend_button);
        ask_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), menu_click);
                mediaPlayer.start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent askFriend = new Intent(MainActivity.this, Friend.class);
                        startActivity(askFriend);
                    }
                }, 100);

            }
        });

        imageViews[0] = (ImageView)findViewById(R.id.imageView_0);
        imageViews[1] = (ImageView)findViewById(R.id.imageView_1);
        imageViews[2] = (ImageView)findViewById(R.id.imageView_2);
        imageViews[3] = (ImageView)findViewById(R.id.imageView_3);

        dashes[0] = (ImageView)findViewById(R.id.dash_0);
        dashes[1] = (ImageView)findViewById(R.id.dash_1);
        dashes[2] = (ImageView)findViewById(R.id.dash_2);
        dashes[3] = (ImageView)findViewById(R.id.dash_3);
        dashes[4] = (ImageView)findViewById(R.id.dash_4);
        dashes[5] = (ImageView)findViewById(R.id.dash_5);
        dashes[6] = (ImageView)findViewById(R.id.dash_6);
        dashes[7] = (ImageView)findViewById(R.id.dash_7);
        dashes[8] = (ImageView)findViewById(R.id.dash_8);



        level = sharedPreferences.getInt("level",0);
        coin = sharedPreferences.getInt("coin",24)-1;
        levelUP(level);
        /*Here is our main work
        * We perform letter click operations and display on dashes what person typed.*/
        count[0] = sharedPreferences.getInt("count",0);
        for (int j = 0; j < 13; j++){
            final int temp = j;
            chars[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (char_string[temp]!=' '){
                        chars[temp].setImageResource(char_empty);
                        for (int q = count[0]; q<attempt.length();q++){
                            if (attempt.charAt(q)!=' '){
                                count[0]++;
                            }
                            else {
                                break;
                            }
                        }
                        attempt = changeCharInPosition(count[0],char_string[temp],attempt);
                        dashes[count[0]].setImageResource(dash_alphabet[alphabet_str.indexOf(char_string[temp])]);

                        onPause();
                        mediaPlayer = MediaPlayer.create(MainActivity.this,char_click_sound[count[0]]);
                        mediaPlayer.start();
                        
                        count[0]++;

                        char_string[temp] = ' ';
                        testIfFinished();
                    }


                }
            });
        }

        /*Idea of erasing per  index*/
        for (int l = 0;l<9;l++){
            final int temp_l = l;
            dashes[l].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (attempt.charAt(temp_l)!=' '){
                        for (int m = 0;m<13;m++){
                            if (char_string[m]==' '){
                                dashes[temp_l].setImageResource(dash);
                                char_string[m] = attempt.charAt(temp_l);
                                chars[m].setImageResource(char_alphabet[alphabet_str.indexOf(attempt.charAt(temp_l))]);
                                attempt = changeCharInPosition(temp_l,' ',attempt);
                                for (int w = 0;w<attempt.length();w++){
                                    if (attempt.charAt(w)==' '){
                                        count[0] = w;
                                        break;
                                    }
                                }
                                break;

                            }
                        }
                    }
                }
            });
        }


    }

    public String changeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

    public void levelUP(int nextLevel){

        if (nextLevel==25){
            Toast.makeText(getApplicationContext(),"Ташаккури зиёд барои бо мо будан!",Toast.LENGTH_LONG).show();
            level = 0;
            nextLevel = 0;
        }

        result = answers[nextLevel];
        attempt = "         ";
        textViewLevel.setText((level + 1) + "");
        coin+=1;
        textViewCoin.setText(coin + "");

        editor.putInt("level", nextLevel);
        editor.putInt("coin", coin);
        editor.apply();



        for (int p = 0;p<4;p++){
            if (level<=24)
                imageViews[p].setImageResource(images[4*level+p]);
        }
        Collections.shuffle(Arrays.asList(alphabet_char_array));
        for (int k = 0; k<13; k++){
            char_string[k] = alphabet_char_array[k];
            indexes_str+=alphabet_char_array[k];
            chars[k].setImageResource(char_alphabet[alphabet_str.indexOf(alphabet_char_array[k])]);
        }

        Collections.shuffle(Arrays.asList(indexes));
        for (int i = 0; i<result.length(); i++){
            indexes_str += " "+indexes[i];
            chars[indexes[i]].setImageResource(char_alphabet[alphabet_str.indexOf(result.charAt(i))]);
            char_string[indexes[i]] = result.charAt(i);
        }


        for (int z = 0; z<9;z++){
            if (z>=result.length())
                dashes[z].setImageDrawable(null);
            else
                dashes[z].setImageResource(dash);
        }
    }
    public void updateChars() {

        Collections.shuffle(Arrays.asList(alphabet_char_array));

        attempt = "         ";
        for (int k = 0; k<13; k++){
            char_string[k] = alphabet_char_array[k];
            indexes_str+=alphabet_char_array[k];
            chars[k].setImageResource(char_alphabet[alphabet_str.indexOf(alphabet_char_array[k])]);
        }

        Collections.shuffle(Arrays.asList(indexes));
        for (int i = 0; i<result.length(); i++){
            indexes_str += " "+indexes[i];
            chars[indexes[i]].setImageResource(char_alphabet[alphabet_str.indexOf(result.charAt(i))]);
            char_string[indexes[i]] = result.charAt(i);
        }


        for (int z = 0; z<9;z++){
            if (z>=result.length())
                dashes[z].setImageDrawable(null);
            else
                dashes[z].setImageResource(dash);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getBoolean("expose",false)){
            editor.putBoolean("expose", false);
            editor.apply();

            coin-=15;

            editor.putInt("coin", coin);
            editor.apply();
            textViewCoin.setText(coin+"");


            Random random = new Random();
            int temp = random.nextInt(result.length());
            while (attempt.charAt(temp)!=' '){
                temp = random.nextInt(result.length());
            }

            for (int u = 0;u<13;u++){
                if (char_string[u]==result.charAt(temp)){
                    attempt = changeCharInPosition(temp,result.charAt(temp),attempt);
                    dashes[temp].setImageResource(dash_alphabet[alphabet_str.indexOf(result.charAt(temp))]);

                    char_string[u] = ' ';
                    chars[u].setImageResource(char_empty);
                    break;
                }
            }
            testIfFinished();
        }
        else if (sharedPreferences.getBoolean("remove",false)){
            editor.putBoolean("remove", false);
            editor.apply();

            coin-=15;

            editor.putInt("coin", coin);
            editor.apply();
            textViewCoin.setText(coin + "");

            for (int ww = 0; ww<13;ww++){
                if (char_string[ww]!=' ' && result.indexOf(char_string[ww])==-1){
                    char_string[ww] = ' ';
                    chars[ww].setImageResource(char_empty);
                    break;
                }
            }
        }
        else if (sharedPreferences.getBoolean("solve",false)){
            editor.putBoolean("solve", false);
            editor.apply();
            attempt = result;


            coin-=30;

            editor.putInt("coin", coin);
            editor.apply();
            textViewCoin.setText(coin+"");

            for (int ee = 0; ee<result.length();ee++){
                dashes[ee].setImageResource(dash_alphabet[alphabet_str.indexOf(result.charAt(ee))]);
            }
            testIfFinished();
        }
        else if (sharedPreferences.getBoolean("watched",false)){
            editor.putBoolean("watched", false);

            coin+=15;
            editor.putInt("coin", coin);
            editor.apply();
            textViewCoin.setText(coin + "");
        }
        else if (sharedPreferences.getBoolean("shared",false)){
            editor.putBoolean("shared", false);

            coin+=15;
            editor.putInt("coin", coin);
            editor.apply();
            textViewCoin.setText(coin+"");
        }
        else if (sharedPreferences.getBoolean("won",false)){
            editor.putBoolean("won",false);
            editor.apply();
            level++;
            levelUP(level);
        }
        else if (sharedPreferences.getBoolean("double_reward",false)){
            editor.putBoolean("double_reward",false);
            coin++;
            editor.putInt("coin",coin);
            editor.apply();
            level++;
            levelUP(level);
        }
    }

    public void testIfFinished(){
        boolean hasnotemptyspot = false;

        for (int qq = 0; qq<result.length();qq++){
            if (attempt.charAt(qq)==' '){
                break;
            }
            if (qq==result.length()-1){
                hasnotemptyspot = true;
            }
        }

        if (hasnotemptyspot){//levelUp

            if (result.equals(attempt.substring(0,result.length()))){
                count[0] = 0;
                Intent win = new Intent(MainActivity.this,Win.class);
                startActivity(win);


            }
            else{

                for (int io =0; io <13;io++){
                    chars[io].setImageResource(char_empty);
                    char_string[io] = ' ';
                }
                Toast.makeText(MainActivity.this,"Мутаассифона иштибоҳ кардед!",Toast.LENGTH_SHORT).show();
                count[0] = 0;
                onPause();
                mediaPlayer = MediaPlayer.create(MainActivity.this,wrong_answer_sound);
                mediaPlayer.start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        updateChars();
                    }
                }, 3000);
            }
        }
    }
}
