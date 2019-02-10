package com.example.taher.listview;

/**
 * Created by Taher on 2/4/2019.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<book> {

    ArrayList<book> booksArrayList;
    Context context;

    public adapter(@NonNull Context context, ArrayList<book> movieArrayList) {
        super(context, 0, movieArrayList);
        this.booksArrayList=booksArrayList ;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) getContext().
                    getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.row,null,true);
        }
        book books =getItem(position);
        ImageView imageView =(ImageView) convertView.findViewById(R.id.image);
        Picasso.with(context)
                .load(books.getImage())
                .into(imageView);
        TextView title=convertView.findViewById(R.id.Title);
        title.setText(books.getTitle());
        TextView descrip=convertView.findViewById(R.id.descrip);
        descrip.setText(books.getDescrip());
        return convertView ;
    }
}
