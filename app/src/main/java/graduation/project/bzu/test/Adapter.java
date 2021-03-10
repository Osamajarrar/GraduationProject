package graduation.project.bzu.test;

import android.content.Context;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<Subject> subjects;
    LayoutInflater inflater;
    public Adapter(Context context,List<Subject> subjects){
        this.inflater= LayoutInflater.from(context);
        this.subjects=subjects;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subjectTitle.setText(subjects.get(position).getName());
        Picasso.get().load(subjects.get(position).getImageURL()).into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView subjectTitle;
        ImageView coverImage;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            subjectTitle=itemView.findViewById(R.id.subjectTitle);
            coverImage=itemView.findViewById(R.id.coverImage);
        }
    }
}
