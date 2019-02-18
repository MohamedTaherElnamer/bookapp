package com.example.taher.listview;

import android.content.SharedPreferences;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_expandable_list_item_1;

public class MainActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
     RequestQueue mQueue;
     String choice;
     ListView lstt ;
     String url;
    public ArrayList<book> arrayList=new ArrayList<>() ;
    public ArrayList<book> arrayListt=new ArrayList<>() ;

    adapter adapt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.rcy);

        choice=getIntent().getStringExtra("choice");

       //String url="https://www.googleapis.com/books/v1/volumes?q=time&amp;printType=books";




        if(choice.equals("time")){

            url="https://www.googleapis.com/books/v1/volumes?q=time&amp;printType=books";

        }
        if(choice.equals("sport")){
             url="https://www.googleapis.com/books/v1/volumes?q=Sport&amp;printType=books";

        }

        /*else if(choice=="love"){

            url="https://www.googleapis.com/books/v1/volumes?q=love&amp;printType=books";

        }
        else if(choice=="time"){
            url="https://www.googleapis.com/books/v1/volumes?q=time&amp;printType=books";

        }*/


        /*SharedPreferences sharedPreferences =getSharedPreferences("shared preference",MODE_PRIVATE);
        Gson gson =new Gson();
        String json = sharedPreferences.getString("task",null);
        Type type = new TypeToken<ArrayList<book>>() {}.getType();
        arrayListt=gson.fromJson(json,type);*/

        mQueue=Volley.newRequestQueue(this);

        jsonparse(url);
















    }
    private void jsonparse(String url){

        //String url="https://www.googleapis.com/books/v1/volumes?q=time&amp;printType=books";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray itemArray = response.getJSONArray("items");


                            for(int i=0;i<itemArray.length();i++){



                                JSONObject employee=itemArray.getJSONObject(i);
                                String id = employee.getString("id");

                                JSONObject volumeInfoitem = employee.getJSONObject("volumeInfo");

                                String title = volumeInfoitem.getString("title");


                                String publisher = volumeInfoitem.getString("publisher");
                                String publishedDate = volumeInfoitem.getString("publishedDate");


                                //double averageRating = volumeInfoitem.getDouble("averageRating");
                                double averageRating=1;
                                String description="mm";
                                /*if (volumeInfoitem.get("description") == null) {
                                    description="mohamed";

                                }

                                else{
                                    description= volumeInfoitem.getString("description");


                                }*/

                                JSONObject imageLinks = volumeInfoitem.getJSONObject("imageLinks");
                                String imagelink = imageLinks.getString("smallThumbnail");

                                JSONArray authorsArray = volumeInfoitem.getJSONArray("authors");
                                String [] authorarray=new String[authorsArray.length()];
                                for(int i2=0;i2<authorsArray.length();i2++){
                                    String  value=authorsArray.getString(i2);
                                    authorarray[i2]=value;
                                }


                                arrayList.add(new book(id,title,authorarray,publisher,publishedDate,description,imagelink));




                            }
                            adapt = new adapter(MainActivity.this,arrayList);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            recyclerView.setAdapter(adapt);
                            /*SharedPreferences sharedPreferences =getSharedPreferences("shared preference",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            Gson gson =new Gson();
                            String json = gson.toJson(arrayList);
                            editor.putString("task",json);
                            editor.apply();*/









                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        mQueue.add(request);






    }



}
