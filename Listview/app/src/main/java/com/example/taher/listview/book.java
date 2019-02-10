package com.example.taher.listview;

/**
 * Created by Taher on 2/4/2019.
 */

public class book
{
    private String image ;
    private String title ;
    private String descrip ;

    public book(String image, String title, String descrip)
    {
        this.image=image;
        this.title=title;
        this.descrip=descrip;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
