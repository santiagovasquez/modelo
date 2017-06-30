package info.androidhive.olarteEsteematorlite.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import info.androidhive.olarteEsteematorlite.R;

public class StartAppActivity extends AppCompatActivity{

    private static final long SPLASH_SCREEN_DELAY = 100;
    ImageView mImgStrategee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash);
        mImgStrategee= (ImageView) findViewById(R.id.imgStrategee);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainActivity = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(mainActivity);
                finish();


                // Show action bar when the main fragment is visible
                runOnUiThread(new Runnable() {
                    public void run() {

                    }
                });

            }

        };


        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
