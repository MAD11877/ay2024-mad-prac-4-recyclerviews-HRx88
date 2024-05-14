package sg.edu.np.mad.madpractical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> list_objects;
    public UserAdapter(ArrayList<User> list_objects,ListActivity activity){
        this.list_objects=list_objects;
    }
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list,parent,false);
        UserViewHolder holder = new UserViewHolder(view);
        return  holder;
    }
    public void onBindViewHolder(UserViewHolder holder,int position){
        User list_item = list_objects.get(position);
        holder.name.setText(list_item.getName());
        holder.description.setText(list_item.getDescription());
    }
    public int getItemCount(){return list_objects.size();}

}
