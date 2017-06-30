package info.androidhive.olarteEsteematorlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.Locale;

import info.androidhive.olarteEsteematorlite.R;

public class EsteematorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("esteemator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Locale.getDefault().getLanguage().equals("en")){
            setContentView(R.layout.activity_start_app_eng);
        }else{
            setContentView(R.layout.activity_start_app);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
