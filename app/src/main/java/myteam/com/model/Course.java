package myteam.com.model;

import java.io.Serializable;

public class Course implements Serializable {
    String namecourse;
    String decription;
    String episode;
    String image_Course;

    public Course(String namecourse, String decription, String episode, String image_Course) {
        this.namecourse = namecourse;
        this.decription = decription;
        this.episode = episode;
        this.image_Course = image_Course;
    }

    public Course() {
    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getImage_Course() {
        return image_Course;
    }

    public void setImage_Course(String image_Course) {
        this.image_Course = image_Course;
    }
}
