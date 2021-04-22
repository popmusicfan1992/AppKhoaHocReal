package myteam.com.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String masinhvien;
    private String username;
    private String password;

    public Student(String masinhvien, String username, String password) {
        this.masinhvien = masinhvien;
        this.username = username;
        this.password = password;
    }

    @NonNull
    public int getId() {
        return id;
    }
    @NonNull
    public void setId(int id) {
        this.id = id;
    }

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", masinhvien='" + masinhvien + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
