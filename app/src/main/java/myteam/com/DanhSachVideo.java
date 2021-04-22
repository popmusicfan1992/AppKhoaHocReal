package myteam.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

import myteam.com.Adapter.ListVideoAdapter;
import myteam.com.model.Course;
import myteam.com.model.Video12;

public class DanhSachVideo extends AppCompatActivity {

    private Intent intent;


    private GridView gv;
    private List<Video12> arr;
    private ListVideoAdapter adapter;
    private ImageView imageView;
    private TextView txtmota;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        InitWidget();
        Init();

    }

    private void Init() {
        arr=new ArrayList<>();
        imageView = (ImageView) findViewById(R.id.anhItem);


        intent=getIntent();

        Course course= (Course) intent.getSerializableExtra("COURSE");
        txtmota.setText(course.getDecription());
        Glide.with(this)
                .load(course.getImage_Course())
                .into(imageView);

        int k =intent.getIntExtra("ID",0);
// cứ theo thứ tự .
        //từ 0?-> cho đến hết list
        switch (k){
            case 0: VideoSo1();break;
            case 1: VideoLapTrinhC();break;
            case 2: VideoLapTrinhJava();break;
            case 3: VideoLapTrinhPython();break;
        }



        adapter=new ListVideoAdapter(this,arr);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DanhSachVideo.this, VideoActivity.class);
                intent.putExtra("VIDEO",arr.get(position));
                startActivity(intent);
            }
        });



    }

    private void VideoLapTrinhJava() {
        // tự thêm nhé tuongtu 2 cái trên ok a
    }
    private void VideoLapTrinhPython() {
    }

    private void VideoSo1() {

        arr.add(new Video12("Con Trỏ - Cốt lỗi về con trỏ","https://firebasestorage.googleapis.com/v0/b/checkjed.appspot.com/o/46%20-%20Con%20Tr%E1%BB%8F%20-%20C%E1%BB%91t%20l%E1%BB%97i%20v%E1%BB%81%20con%20tr%E1%BB%8F.mp4?alt=media&token=90836fc9-a0ae-40b7-bc7b-ef334a447d2c"));
        arr.add(new Video12("Con Trỏ - Khai niem con tro ","https://firebasestorage.googleapis.com/v0/b/checkjed.appspot.com/o/47%20-%20Con%20tr%E1%BB%8F%20-%20Kh%C3%A1i%20ni%E1%BB%87m%20con%20tr%E1%BB%8F.mp4?alt=media&token=c6cc1c55-ab82-4eb6-89f1-224c122d8e9a"));
        arr.add(new Video12(" Con trỏ - Các biến Con Trở","https://firebasestorage.googleapis.com/v0/b/checkjed.appspot.com/o/48%20-%20Con%20tr%E1%BB%8F%20-%20C%C3%A1c%20bi%E1%BA%BFn%20Con%20Tr%E1%BB%9F.mp4?alt=media&token=471e4f32-6de0-4fc3-bd3f-abc3b50e3db8"));

    }
    private void VideoLapTrinhC() {
        arr.add(new Video12("Lập trình C++ P1","https://firebasestorage.googleapis.com/v0/b/checkjed.appspot.com/o/50%20-%20Con%20tr%E1%BB%8F%20-%20%C4%90%E1%BB%ABng%20nh%E1%BA%A7m%20l%E1%BA%ABn.mp4?alt=media&token=1012763b-3502-435e-a2ac-492abe1ee971"));
        arr.add(new Video12("Lập trình C++ P2","https://firebasestorage.googleapis.com/v0/b/checkjed.appspot.com/o/51%20-%20Con%20tr%E1%BB%8F%20-%20B%C3%A0i%20t%E1%BA%ADp%20Con%20Tr%E1%BB%8F.mp4?alt=media&token=866ec55b-db7a-457f-a97f-cc9bd4a51549"));
        arr.add(new Video12("Lập trình C++ P3","https://firebasestorage.googleapis.com/v0/b/checkjed.appspot.com/o/52%20-%20Con%20tr%E1%BB%8F%20-%20B%C3%A0i%20t%E1%BA%ADp%20Con%20Tr%E1%BB%8F.mp4?alt=media&token=dcc76012-b1ba-4c56-92f6-adfdb052e2cb"));

    }

    private void InitWidget() {

        gv=findViewById(R.id.gv);
        txtmota=findViewById(R.id.txtmota);
        imageView=findViewById(R.id.anhItem);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
