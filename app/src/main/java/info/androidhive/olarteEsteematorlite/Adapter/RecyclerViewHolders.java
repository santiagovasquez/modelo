package info.androidhive.olarteEsteematorlite.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

import bolts.Task;
import info.androidhive.olarteEsteematorlite.EntityFirebase.User;
import info.androidhive.olarteEsteematorlite.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder {
    public ImageView deleteIcon;
    public RecyclerViewHolders(final View itemView, final HashMap<User, User> taskObject) {
        super(itemView);
        //this.taskObject = taskObject;
        deleteIcon = (ImageView)itemView.findViewById(R.id.imagen);
        /*deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete icon has been clicked", Toast.LENGTH_LONG).show();
                String taskTitle = taskObject.get(getAdapterPosition()).getName();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.orderByChild("task").equalTo(taskTitle);
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("", "onCancelled", databaseError.toException());
                    }
                });
            }
        });*/
    }
}
