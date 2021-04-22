package myteam.com.model;

import java.io.Serializable;

public class Video12 implements Serializable {
    private String name;
    private String link;
    public Video12(){

    }
    public Video12(String name, String link){
        this.name=name;
        this.link=link;

    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
}

