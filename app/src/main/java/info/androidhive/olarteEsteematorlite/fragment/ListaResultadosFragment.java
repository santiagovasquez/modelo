package info.androidhive.olarteEsteematorlite.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

import info.androidhive.olarteEsteematorlite.Config.Config;
import info.androidhive.olarteEsteematorlite.EntityFirebase.Formulas;
import info.androidhive.olarteEsteematorlite.R;
import info.androidhive.olarteEsteematorlite.activity.FormulaSaveView2Activity;
import info.androidhive.olarteEsteematorlite.activity.FormulaSaveViewActivity;
import info.androidhive.olarteEsteematorlite.activity.MainActivity;

public class ListaResultadosFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    static final String FIREBASE_URL="https://fir-esteemator-lite.firebaseio.com/";
    Query firebase;
    RecyclerView mRecycler_vertical;
    private TextView mTxtItem;
    FirebaseRecyclerViewAdapter mAdapter;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    String mUid;
    private String mParam1;
    private String mParam2;
    Firebase users;


    public ListaResultadosFragment() {

    }


    public static ListaResultadosFragment newInstance(String param1, String param2) {
        ListaResultadosFragment fragment = new ListaResultadosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //Toast.makeText(getActivity(),"Ya tienes una sesión activa111 "+ mUid ,Toast.LENGTH_SHORT).show();
                }
            }

        };
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        compruebaConexion(getContext());
        if (!compruebaConexion(getContext())) {
            Toast.makeText(getContext(),R.string.sin_internet, Toast.LENGTH_SHORT).show();
        }

}

    public static boolean compruebaConexion(Context context) {
        boolean connected = false;
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Firebase.setAndroidContext(getActivity());
        final View view = inflater.inflate(R.layout.fragment_results, container, false);
        mRecycler_vertical= (RecyclerView)view.findViewById(R.id.vertical_recycler_view);
        mTxtItem=(TextView) view.findViewById(R.id.txtItem);
        Bundle extras = getArguments();
        mUid= (String) extras.get("uidd");
        firebase=new Firebase(FIREBASE_URL).child("Formulas").orderByChild("uid").equalTo(mUid);

        mAdapter = new FirebaseRecyclerViewAdapter<Formulas, ToDoItemViewHolder>(Formulas.class,R.layout.item_formula,ToDoItemViewHolder.class,firebase) {
            @Override
            public void populateViewHolder(ToDoItemViewHolder toDoItemViewHolder, Formulas formula) {
                String descripcionElemento=formula.getNombre();
                toDoItemViewHolder.txt_lemento.setText(descripcionElemento);
            }

            @Override
            public ToDoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ViewGroup viewGroup=  (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(mModelLayout,parent,false);
                return new ToDoItemViewHolder(viewGroup);
            }
        };

        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mRecycler_vertical.scrollToPosition(mAdapter.getItemCount()-1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRecycler_vertical.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler_vertical.setAdapter(mAdapter);
        return view;
    }



    public class ToDoItemViewHolder extends RecyclerView.ViewHolder{
        TextView txt_lemento;
        ImageView imagen;

        public ToDoItemViewHolder(View itemView) {
            super(itemView);
            txt_lemento=(TextView)itemView.findViewById(R.id.txtItem);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    b.setTitle(R.string.eliminar_resultado);
                    b.setPositiveButton(R.string.eliminar, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int position = getAdapterPosition();
                            Firebase referencia = mAdapter.getRef(position);
                            referencia.removeValue();
                            Toast.makeText(getContext(),R.string.removeSuccess,Toast.LENGTH_SHORT).show();
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
            });
            txt_lemento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Formulas item = (Formulas) mAdapter.getItem(position);
                    if (item.getType_formula().equals("1")){
                        Intent bundle = new Intent(getActivity(), FormulaSaveViewActivity.class);
                        bundle.putExtra("txt1",item.getTxt1());
                        bundle.putExtra("txt2",item.getTxt2());
                        bundle.putExtra("val1",item.getVal1());
                        bundle.putExtra("val2",item.getVal2());
                        bundle.putExtra("val3",item.getVal3());
                        bundle.putExtra("nombre",item.getNombre());
                        startActivity(bundle);
                    }else if(item.getType_formula().equals("2")){
                        Intent bundle = new Intent(getActivity(), FormulaSaveView2Activity.class);
                        bundle.putExtra("txt1",item.getTxt1());
                        bundle.putExtra("txt2",item.getTxt2());
                        bundle.putExtra("val1",item.getVal1());
                        bundle.putExtra("val2",item.getVal2());
                        bundle.putExtra("val3",item.getVal3());
                        bundle.putExtra("val4",item.getVal4());
                        bundle.putExtra("val5",item.getVal5());
                        bundle.putExtra("nombre",item.getNombre());
                        startActivity(bundle);
                    }
                }
            });
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }




}