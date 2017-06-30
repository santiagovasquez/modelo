package info.androidhive.olarteEsteematorlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import info.androidhive.olarteEsteematorlite.EntityLocal.FormulasModel;
import info.androidhive.olarteEsteematorlite.R;

public class FormulaSaveView2Activity extends AppCompatActivity {

    String mName;
    String mId;
    List<FormulasModel> mResultado;
    EditText mTxt_result_uno,mTxt_result_dos;
    TextView mTxt_resultado1,mTxt_resultado2,mTxt_resultado3,mTxt_resultado4,mTxt_resultado5;
    FormulasModel formulasModel = new FormulasModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_save_view2);
        iniciarVariables();
        Bundle bundle = getIntent().getExtras();
        mName=bundle.getString("name",mName).toString();
        mId=bundle.getString("id",mId).toString();
        mResultado=formulasModel.selectFormula(mId);
        for (FormulasModel formula: mResultado ){
            mTxt_result_uno.setText(formula.txt_1.toString());
            mTxt_result_dos.setText(formula.txt_2.toString());
            mTxt_resultado1.setText(formula.value_3.toString());
            mTxt_resultado2.setText(formula.value_4.toString());
            mTxt_resultado3.setText(formula.value_5.toString());
            mTxt_resultado4.setText(formula.value_7.toString());
            mTxt_resultado5.setText(formula.value_6.toString());
        }

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
        mTxt_resultado4=(TextView)findViewById(R.id.txt_resultado4);
        mTxt_resultado5=(TextView)findViewById(R.id.txt_resultado5);
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
