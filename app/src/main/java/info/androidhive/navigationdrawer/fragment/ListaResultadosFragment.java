package info.androidhive.navigationdrawer.fragment;

import android.content.Intent;
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
import info.androidhive.navigationdrawer.activity.FormulaSaveView2Activity;
import info.androidhive.navigationdrawer.activity.FormulaSaveViewActivity;


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
        mVerticalAdapter =new VerticalAdapter(verticalList);
        LinearLayoutManager verticalLayoutmanager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mVertical_recycler_view.setLayoutManager(verticalLayoutmanager);
        mVertical_recycler_view.setAdapter(mVerticalAdapter);

        return view;
    }

    private void findCategory(List<FormulasModel> formulasModels) {
        for (FormulasModel formula : formulasModels)
        {
            {
                verticalList.add(formula.name);
                mId.add(formula.getId().toString());
                continue;
            }
        }
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
            int newPosition = holder.getAdapterPosition();
            verticalList.remove(newPosition);
            notifyItemRemoved(newPosition);
            notifyItemRangeChanged(newPosition,verticalList.size());
            holder.txtView.setText(verticalList.get(position));



            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),mId.get(position).toString(),Toast.LENGTH_SHORT).show();
                    String id = formulasModel.selectId();
                    String name= formulasModel.nameId(mId.get(position));
                    String type= formulasModel.selectType(mId.get(position));

                    if (!id.equals("")){
                        String idFormula = String.valueOf(mId.get(position).toString());
                        if (type.equals("1")){
                            Intent intent = new Intent(v.getContext(), FormulaSaveViewActivity.class);
                            intent.removeExtra("id");
                            intent.removeExtra("name");
                            intent.putExtra("id",idFormula);
                            intent.putExtra("name",name);
                            v.getContext().startActivity(intent);
                        }else{
                            Intent intent = new Intent(v.getContext(), FormulaSaveView2Activity.class);
                            intent.removeExtra("id");
                            intent.removeExtra("name");
                            intent.putExtra("id",idFormula);
                            intent.putExtra("name",name);
                            v.getContext().startActivity(intent);
                        }
                    }else{
                        Toast.makeText(getContext(),"este resultado ya fue eliminado.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return verticalList.size();
        }


    }
}
