package myteam.com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import myteam.com.DanhSachVideo;
import myteam.com.R;
import myteam.com.SetOnItemClick;
import myteam.com.model.Course;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context mContext;
    private List<Course> mData;

    public Adapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.activity_item_cardview,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.namecourse.setText(mData.get(position).getNamecourse());
        holder.decription.setText(mData.get(position).getDecription());
        holder.episode.setText(mData.get(position).getEpisode());
        Glide.with(mContext)
                .load(mData.get(position).getImage_Course()).into(holder.image_Course);
        holder.SetOnITem(new SetOnItemClick() {
            @Override
            public void SetOnItemClickListenr(View view, int position) {
                Intent intent=new Intent(mContext, DanhSachVideo.class);
                intent.putExtra("ID",position);
                intent.putExtra("COURSE",mData.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
     implements  View.OnClickListener{
        TextView namecourse;
        TextView decription;
        TextView episode;
        ImageView image_Course;
        SetOnItemClick itemClick;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namecourse = itemView.findViewById(R.id.course_name);
            decription = itemView.findViewById(R.id.decription_course);
            episode = itemView.findViewById(R.id.episode_course);
            image_Course = itemView.findViewById(R.id.image_course);
            itemView.setOnClickListener(this);
        }
public void SetOnITem(SetOnItemClick itemClick){
            this.itemClick=itemClick;
}
        @Override
        public void onClick(View v) {
            itemClick.SetOnItemClickListenr(v,getAdapterPosition());
        }
    }
}
