package attor.shoiron;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

/**
 * Created by moses on 21/02/2017.
 */
public class Win extends MainActivity {

    ImageView continue_btn,double_btn;
    ImageView[] pics;
    TextView result_txt;
    final private UnityAdsListener unityAdsListener = new UnityAdsListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);

        UnityAds.initialize(this,"1325670",unityAdsListener);


        pics = new ImageView[4];

        pics[0] = (ImageView)findViewById(R.id.win_imageView_0);
        pics[1] = (ImageView)findViewById(R.id.win_imageView_1);
        pics[2] = (ImageView)findViewById(R.id.win_imageView_2);
        pics[3] = (ImageView)findViewById(R.id.win_imageView_3);

        for (int p = 0;p<4;p++){
            if (level<=24)
                pics[p].setImageResource(images[4*level+p]);
        }


        result_txt = (TextView)findViewById(R.id.win_name_textView);
        double_btn = (ImageView)findViewById(R.id.reward_double);
        double_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UnityAds.isReady()){
                    UnityAds.show(Win.this);
                    onBackPressed();
                }
            }
        });
        result_txt.setText(result);

        onPause();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), level_up_sound);
        mediaPlayer.start();
        continue_btn = (ImageView)findViewById(R.id.continue_btn);
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putBoolean("won",true);
                editor.apply();
                onBackPressed();
            }
        });
    }

    private void doubleReward(){
        editor.putBoolean("double_reward",true);
        editor.apply();
    }
    private class UnityAdsListener implements IUnityAdsListener{

        @Override
        public void onUnityAdsReady(String s) {

        }

        @Override
        public void onUnityAdsStart(String s) {

        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
                doubleReward();
        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

        }
    }


}
