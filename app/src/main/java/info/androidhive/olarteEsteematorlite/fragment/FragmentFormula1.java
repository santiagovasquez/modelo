package info.androidhive.olarteEsteematorlite.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import info.androidhive.olarteEsteematorlite.EntityLocal.FormulasModel;
import info.androidhive.olarteEsteematorlite.R;
import info.androidhive.olarteEsteematorlite.activity.Formulas;


public class FragmentFormula1 extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText txtuno, txtdos,mEditText;
    private Button btncalcular;
    private TextView resultado1,resultado2,resultado3;
    private String mParam1;
    private String mParam2;
    private String mTexto = "";
    FormulasModel formulasModel = new FormulasModel();
    public FragmentFormula1() {

        // Required empty public constructor
    }


    public static FragmentFormula1 newInstance(String param1, String param2) {
        FragmentFormula1 fragment = new FragmentFormula1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_fragment_formula1, container, false);
        iniciarVariables(rootView);
        return rootView;
    }


    public void iniciarVariables(View view) {
        txtuno = (EditText) view.findViewById(R.id.txtuno);
        txtdos = (EditText) view.findViewById(R.id.txtdos);
        resultado1=(TextView) view.findViewById(R.id.resultado1);
        resultado2=(TextView) view.findViewById(R.id.resultado2);
        resultado3=(TextView) view.findViewById(R.id.resultado3);
        btncalcular = (Button) view.findViewById(R.id.btncalcular);
        mEditText= (EditText) view.findViewById(R.id.input);
        btncalcular.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.btncalcular) {

            if (txtuno.getText().toString().matches("") || txtdos.getText().toString().matches("")) {
                Toast.makeText(view.getContext(), getResources().getString(R.string.nullcamp), Toast.LENGTH_LONG).show();
                return;
            }
            final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService( Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            Formulas formulas = new Formulas(Float.parseFloat(txtuno.getText().toString()), Float.parseFloat(txtdos.getText().toString()));
            final Float[] data = formulas.Formula1();

            final DecimalFormat df = new DecimalFormat("#,###,##0.00");

            resultado1.setText(df.format(data[0]));
            resultado2.setText(df.format(data[2]));
            resultado3.setText(df.format(data[1]));

            final AlertDialog.Builder b = new AlertDialog.Builder(getContext());
            b.setTitle(getResources().getString(R.string.result));
            b.setMessage(df.format(data[0]));
            final View view1=LayoutInflater.from(getContext()).inflate(R.layout.modal, (ViewGroup) getView(),false);

            final EditText input = (EditText) view1.findViewById(R.id.input);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            b.setView(view1);

            b.setPositiveButton(getResources().getString(R.string.save_resultt), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mTexto=input.getText().toString();
                    if (!mTexto.equals("")){
                        String name=mTexto;
                        String s =txtuno.getText().toString();
                        String s1=txtdos.getText().toString();
                        String s2=df.format(data[0]).toString();
                        String s3=df.format(data[2]).toString();
                        String s4=df.format(data[1]).toString();
                        String s5="1";
                        formulasModel.saveData(name,s,s1,s2,s3,s4,s5);
                        Toast.makeText(getContext(),getResources().getString(R.string.save_success),Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getContext(),getResources().getString(R.string.val_null),Toast.LENGTH_SHORT).show();
                    }
                }
            });
            b.setNegativeButton(getResources().getString(R.string.salir), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            b.create().show();
        }

    }



}
