package info.androidhive.olarteEsteematorlite.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.androidhive.olarteEsteematorlite.EntityFirebase.Formula;
import info.androidhive.olarteEsteematorlite.R;


public class FormulasAdapter extends RecyclerView.Adapter<FormulasAdapter.ViewHolderFormulas>{


    private Formula.Formulas formulas;
    public FormulasAdapter(Formula.Formulas formulas) {
        this.formulas=formulas;
    }

    @Override
    public ViewHolderFormulas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_results, parent ,false);
        final ViewHolderFormulas viewHolderFormulas = new ViewHolderFormulas(view);
        return viewHolderFormulas;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolderFormulas extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt_name;
        public ViewHolderFormulas(View itemView) {
            super(itemView);
            txt_name=(TextView) itemView.findViewById(R.id.txtItem);
        }

        @Override
        public void onClick(View v) {

        }
    }


    @Override
    public void onBindViewHolder(ViewHolderFormulas holder, int position) {
        //holder.txt_name.setText(formulas.g);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
