package myteam.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import myteam.com.database.UserDao;
import myteam.com.database.UserDatabase;
import myteam.com.model.Student;

public class MainActivity extends AppCompatActivity {
//    EditText editUsername, editPassword;
//    Button buttonLogin;
//    TextView textViewRegister;
//    UserDao userDao;
//    UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        init();
//        userDatabase = Room.databaseBuilder(this,UserDatabase.class,"student")
//                .allowMainThreadQueries()
//                .build();
//
//        userDao = userDatabase.getUserDao();
//
//        textViewRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,register.class);
//            }
//        });
//
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = editUsername.getText().toString().trim();
//                String password = editPassword.getText().toString().trim();
//
//                Student student = userDao.getStudent(username,password);
//
//                if (student != null){
//                    Intent intent = new Intent(MainActivity.this,home.class);
//                    intent.putExtra("student",student);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    Toast.makeText(MainActivity.this, "Đăng ký với username và pasword không đúng",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
    }

//    private void init(){
//        editUsername = findViewById(R.id.edUserName2);
//        editPassword = findViewById(R.id.edPassWord2);
//        buttonLogin = findViewById(R.id.btn_DangNhap);
//        textViewRegister = findViewById(R.id.textViewRegister);
//    }
}