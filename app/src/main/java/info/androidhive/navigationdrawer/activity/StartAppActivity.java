package info.androidhive.navigationdrawer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import info.androidhive.navigationdrawer.R;

public class StartAppActivity extends AppCompatActivity implements View.OnClickListener {

    private static final long SPLASH_SCREEN_DELAY = 9000;
    ImageView mClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (Locale.getDefault().getLanguage().equals("en")){
            setContentView(R.layout.activity_start_app_eng);
        }else{
            setContentView(R.layout.activity_start_app);
        }
        mClose= (ImageView) findViewById(R.id.imageButtonClose);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);
                finish();


                // Show action bar when the main fragment is visible
                runOnUiThread(new Runnable() {
                    public void run() {

                    }
                });

            }

        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,StartAppActivity.class);
        startActivity(intent);
    }

}
