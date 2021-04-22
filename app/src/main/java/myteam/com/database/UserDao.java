package myteam.com.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import myteam.com.model.Student;

@Dao
public interface UserDao {

    @Query("select *from Student where username= :username and password = :password")
    Student getStudent(String username, String password);

    @Insert
    void insertStudent(Student student);
}
