package myteam.com;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import myteam.com.Adapter.Adapter;
import myteam.com.model.Course;
import myteam.com.model.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class home extends AppCompatActivity {
    private static String JSON_URL = "https://run.mocky.io/v3/16cbe972-cd0e-49f4-a318-b490cfb3b7e8";
    private TextView tvStudent;
    private Student student;
    List<Course> CourseList;
    RecyclerView recyclerView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        student = (Student) getIntent().getSerializableExtra("student");
        tvStudent = findViewById(R.id.textUsername);

        if (student != null){
            tvStudent.setText(student.getUsername());
        }

        CourseList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycle_course);

        GetData getData = new GetData();
        getData.execute();
    }
    public class GetData extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            String current = "";
            try{
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data  = isr.read();
                    while (data != -1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {


            try {
                JSONObject jsonObject = new JSONObject(s);


                JSONArray jsonArray = jsonObject.getJSONArray("khoaHoc");

                for(int i = 0; i< jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    Course model = new Course();
                    model.setNamecourse(jsonObject1.getString("namecourse"));
                    model.setDecription(jsonObject1.getString("decription"));
                    model.setEpisode(jsonObject1.getString("episode"));
                    model.setImage_Course(jsonObject1.getString("image_course"));
                    CourseList.add(model);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            PutDataInRecyclerView( CourseList);
        }
    }
    private void PutDataInRecyclerView(List<Course> CourseList){
        Adapter adapter = new Adapter(this,CourseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }


}