package info.androidhive.olarteEsteematorlite.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import info.androidhive.olarteEsteematorlite.R;
import info.androidhive.olarteEsteematorlite.fragment.FragmentFormula1;
import info.androidhive.olarteEsteematorlite.fragment.FragmentFormula2;

public class GenericActivity extends AppCompatActivity {

    private final int VIEW_FORM_0 = 0;
    private final int VIEW_FORM_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);
        Bundle data = getIntent().getExtras();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon( R.drawable.trategee );
        replaceView(data.getInt("view"));
    }

    private void replaceView(int view){

        if( view == VIEW_FORM_0){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment fragment = new FragmentFormula1();

            ft.replace(R.id.fragmentContainer, fragment);
            ft.commit();
        }

        if (view == VIEW_FORM_1){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment fragment = new FragmentFormula2();

            ft.replace(R.id.fragmentContainer, fragment);
            ft.commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }

}
