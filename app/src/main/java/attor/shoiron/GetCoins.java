package attor.shoiron;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by moses on 21/02/2017.
 */
public class GetCoins extends MainActivity{

    final private UnityAdsListener unityAdsListener = new UnityAdsListener();
    RelativeLayout rl_share,rl_watch;
    TextView textShare,textWatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_coins);
        UnityAds.initialize(this,"1325670",unityAdsListener);


        rl_share = (RelativeLayout)findViewById(R.id.share);
        rl_watch = (RelativeLayout)findViewById(R.id.watch_video);
        textShare = (TextView)findViewById(R.id.text_share);
        textWatch = (TextView)findViewById(R.id.text_watch);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/AmericanTypewriter.ttc");
        textWatch.setTypeface(typeface);
        textShare.setTypeface(typeface);

        final String last_day = sharedPreferences.getString("next_day","01/03/2017");
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final Date[] strDate = {null};

        try {
            strDate[0] = sdf.parse(last_day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (UnityAds.isReady()){
            textWatch.setAlpha(1);
        }

        if (new Date().after(strDate[0])){
            textShare.setAlpha(1);
        }
        rl_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editor.putBoolean("shared", true);
                //editor.apply();
                //onBackPressed();
                //Toast.makeText(getApplicationContext(),"Алъон дастраснораст аст!",Toast.LENGTH_SHORT).show();
                if (new Date().after(strDate[0])) {
                    shareApp(GetCoins.this);
                    editor.putBoolean("shared", true);
                    Date dt = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(dt);
                    c.add(Calendar.DATE, 1);
                    dt = c.getTime();
                    textShare.setAlpha((float) 0.5);
                    editor.putString("next_day",new SimpleDateFormat("dd/MM/yyyy").format(dt));
                    editor.apply();
                    onBackPressed();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Ин имконотро каме баъдтар истифода бурда метавонед.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        rl_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UnityAds.isReady()){
                    UnityAds.show(GetCoins.this);
                    onBackPressed();
                }
            }
        });
    }

    public void rewardCoins(){
        editor.putBoolean("watched", true);
        editor.apply();
    }
    private class UnityAdsListener implements IUnityAdsListener{

        @Override
        public void onUnityAdsReady(String s) {
            textWatch.setAlpha(1);
        }

        @Override
        public void onUnityAdsStart(String s) {

        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
            rewardCoins();

        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

        }
    }

    public static void shareApp(Context context)
    {
        final String appPackageName = context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Бо забони тоҷикӣ низ ҳаст!: https://play.google.com/store/apps/details?id=" + appPackageName);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }
}
