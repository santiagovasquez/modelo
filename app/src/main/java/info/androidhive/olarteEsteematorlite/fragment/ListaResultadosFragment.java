package info.androidhive.olarteEsteematorlite.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseRecyclerViewAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import info.androidhive.olarteEsteematorlite.EntityFirebase.FormulasResult;
import info.androidhive.olarteEsteematorlite.EntityLocal.FormulasModel;
import info.androidhive.olarteEsteematorlite.R;
import info.androidhive.olarteEsteematorlite.activity.FormulaSaveView2Activity;
import info.androidhive.olarteEsteematorlite.activity.FormulaSaveViewActivity;


public class ListaResultadosFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FirebaseRecyclerViewAdapter adapter;
    RecyclerView recyclerView;



    private String mParam1;
    private String mParam2;



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
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

}
