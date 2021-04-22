package myteam.com.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.cardview.widget.CardView;



import java.util.List;

import myteam.com.R;
import myteam.com.VideoActivity;
import myteam.com.model.Video12;

public class ListVideoAdapter  extends BaseAdapter {
    private List<Video12> arrrList;
    private Context context;
    public ListVideoAdapter(Context context,List<Video12> arrrList){
        this.context=context;
        this.arrrList=arrrList;
    }
    @Override
    public int getCount() {
        return arrrList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public  class  ViewHolder{

        TextView txtname;
        CardView c1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.layout_video,null);
            viewHolder=new ViewHolder();

            viewHolder.txtname=convertView.findViewById(R.id.txtname);
            viewHolder.c1=convertView.findViewById(R.id.c1);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.txtname.setText(arrrList.get(position).getName()+"");
        viewHolder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, VideoActivity.class);
                intent.putExtra("VIDEO",arrrList.get(position));
                context.startActivity(intent);

            }
        });
        return convertView;
    }
}
