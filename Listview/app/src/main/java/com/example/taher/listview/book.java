package com.example.taher.listview;

/**
 * Created by Taher on 2/4/2019.
 */


public class book
{
    public String id;
    public String title;
    public String[] authors;
    public String publisher;
    public String publishedDate;
    public Double averageRating;
    public String description;
    public String imagelink;


    public book(String id, String title, String[] authors, String publisher, String publishedDate, Double averageRating, String description, String imagelink) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.averageRating = averageRating;
        this.description = description;
        this.imagelink = imagelink;
    }
}
