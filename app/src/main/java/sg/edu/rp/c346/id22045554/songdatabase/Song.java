package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    private 	String songContent;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers;}

    public int getYear() { return year;}
    public int getStars() { return stars;}

    @NonNull
    @Override
    public String toString() {
        return id + "\n" + title + "\n" + singers + "\n" + year + "\n" + stars;
    }



    public String getSongContent() { return songContent; }

    public void setSongContent(String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }






}
