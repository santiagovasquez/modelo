package info.androidhive.olarteEsteematorlite.Adapter;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import info.androidhive.olarteEsteematorlite.EntityFirebase.User;
import info.androidhive.olarteEsteematorlite.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormulasAdapter extends RecyclerView.Adapter<FormulasAdapter.ViewHolderOfferts> {


    User user;
    public FormulasAdapter(List<User> list) {
//this.user=list;
    }

    @Override
    public ViewHolderOfferts onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_results, parent, false);
        final ViewHolderOfferts holder = new ViewHolderOfferts(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return Integer.parseInt(null);
    }


    @Override
    public void onBindViewHolder(final ViewHolderOfferts holder, final int position) {
            //holder.txt_name.setText( data.get(position).getNombre().toString());
    }

    static class ViewHolderOfferts extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_name;
        int id;

        public ViewHolderOfferts(View itemView) {
            super(itemView);
            txt_name = (TextView)itemView.findViewById(R.id.txtItem);
        }

        @Override
        public void onClick(final View v) {
        }
    }
}
