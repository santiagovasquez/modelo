package info.androidhive.olarteEsteematorlite.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import info.androidhive.olarteEsteematorlite.R;

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
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

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


        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imageButtonClose){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

}
