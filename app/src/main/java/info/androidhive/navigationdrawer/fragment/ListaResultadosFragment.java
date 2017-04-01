package info.androidhive.navigationdrawer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.navigationdrawer.EntityLocal.FormulasModel;
import info.androidhive.navigationdrawer.R;


public class ListaResultadosFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FormulasModel formulasModel = new FormulasModel();
    private RecyclerView mVertical_recycler_view;
    private ArrayList<String> verticalList,mId;
    private  VerticalAdapter mVerticalAdapter;


    private String mParam1;
    private String mParam2;



    public ListaResultadosFragment() {
        // Required empty public constructor
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //String formulas= String.valueOf(formulasModel.);
        mId =new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        mVertical_recycler_view = (RecyclerView) view.findViewById(R.id.vertical_recycler_view);
        verticalList = new ArrayList<>();



        findCategory(formulasModel.selectAll());

        Log.e(verticalList.toString(),"HOLAAAAAAA");
        mVerticalAdapter =new VerticalAdapter(verticalList);
        LinearLayoutManager verticalLayoutmanager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mVertical_recycler_view.setLayoutManager(verticalLayoutmanager);
        mVertical_recycler_view.setAdapter(mVerticalAdapter);

        return view;
    }

    private void findCategory(List<FormulasModel> formulasModels) {
        FormulasModel result = null;
        for (FormulasModel cat : formulasModels) //assume categories isn't null.
        { //assumes name isn't null.
            {
                verticalList.add(cat.name);
                mId.add(cat.getId().toString());
                continue;
            }

            //return fo;
        }
    }



    static FormulasModel findCategoryByName(ArrayList<FormulasModel> categories, String name)
    {
        if(categories == null
                || name == null
                || name.length() == 0)
            return null;

        FormulasModel result = null;

        for(FormulasModel c : categories) {
            if(!c.getName().equals(name))

                continue;
            Log.e(c.name.toString(),"QQQQQQQ");
            result = c;
            break;
        }

        return result;
    }

    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {
        private ArrayList<String> verticalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);

            }
        }

        public VerticalAdapter(ArrayList<String> verticalList){
            this.verticalList=verticalList;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vertical_item,parent,false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(verticalList.get(position));
            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),mId.get(position).toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return verticalList.size();
        }


    }
}
