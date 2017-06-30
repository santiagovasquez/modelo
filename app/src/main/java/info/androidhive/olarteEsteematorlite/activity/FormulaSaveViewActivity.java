package info.androidhive.olarteEsteematorlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.olarteEsteematorlite.R;


public class FormulaSaveViewActivity extends AppCompatActivity {

    String mName, mTxt2, mTxt1, mVal1, mVal3, mVal2;
    EditText mTxt_result_uno,mTxt_result_dos;
    TextView mTxt_resultado1,mTxt_resultado2,mTxt_resultado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_save_view);
        iniciarVariables();
        Bundle bundle = getIntent().getExtras();
        mTxt1 =bundle.getString("txt1", mTxt1).toString();
        mTxt2 =bundle.getString("txt2", mTxt2).toString();
        mVal1 =bundle.getString("val1", mVal1).toString();
        mVal2 =bundle.getString("val2", mVal2).toString();
        mVal3 =bundle.getString("val3", mVal3).toString();
        mName=bundle.getString("nombre",mName).toString();

        mTxt_result_uno.setText(mTxt1.toString());
        mTxt_result_dos.setText(mTxt2.toString());
        mTxt_resultado1.setText(mVal1.toString());
        mTxt_resultado2.setText(mVal2.toString());
        mTxt_resultado3.setText(mVal3.toString());

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(mName);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void iniciarVariables() {
        mTxt_result_uno=(EditText)findViewById(R.id.txt_result_uno);
        mTxt_result_dos=(EditText)findViewById(R.id.txt_result_dos);
        mTxt_resultado1=(TextView)findViewById(R.id.txt_resultado1);
        mTxt_resultado2=(TextView)findViewById(R.id.txt_resultado2);
        mTxt_resultado3=(TextView)findViewById(R.id.txt_resultado3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
