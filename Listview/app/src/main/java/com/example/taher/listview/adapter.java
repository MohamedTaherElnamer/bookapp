package com.example.taher.listview;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.taher.listview.book;
import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>{


    public static class ViewHolder extends RecyclerView .ViewHolder{
        public TextView title,author;
        public ImageView photo;


        public ViewHolder(View itemView) {
            super(itemView);

            title=(TextView) itemView.findViewById(R.id.title);
            author=(TextView)itemView.findViewById(R.id.author);
            photo=(ImageView) itemView.findViewById(R.id.image);


        }
    }
    private Context context;
    private List<book>books;

    public adapter(Context c, ArrayList<book>lst){

        this.context=c;
        this.books=lst;


    }


    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(adapter.ViewHolder holder, int position) {


        book b = books.get(position);
        holder.title.setText(b.title);
        holder.author.setText(b.authors[0]);
       Picasso.with(context).load(b.imagelink).into(holder.photo);


    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}

