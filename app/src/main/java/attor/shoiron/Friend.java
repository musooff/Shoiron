package attor.shoiron;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by moses on 20/02/2017.
 */
public class Friend extends MainActivity {

    RelativeLayout r1,r2,r3,r4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);

        r1 = (RelativeLayout)findViewById(R.id.relativeLayout);
        r2 = (RelativeLayout)findViewById(R.id.relativeLayout2);
        r3 = (RelativeLayout)findViewById(R.id.relativeLayout3);
        r4 = (RelativeLayout)findViewById(R.id.relativeLayout4);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ask(Friend.this,level+1,"com.facebook.katana");
                //Toast.makeText(getApplicationContext(),"Алъон дастнорас аст!",Toast.LENGTH_SHORT).show();
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ask(Friend.this,level+1,"com.whatsapp");
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ask(Friend.this,level+1,null);
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ask(Friend.this,level+1,null);
            }
        });
    }

    public static void ask(Context context,int level, String pack)
    {
        final String appPackageName = context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String text = "Ба ман дар зинаи "+ level + " кӯмак кунед. ";
        sendIntent.putExtra(Intent.EXTRA_TEXT, text + "https://play.google.com/store/apps/details?id=" + appPackageName);
        sendIntent.setType("text/plain");
        if (pack != null){
            sendIntent.setPackage(pack);
        }
        context.startActivity(sendIntent);
    }
}
