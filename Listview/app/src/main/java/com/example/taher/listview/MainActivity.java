package com.example.taher.listview;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_expandable_list_item_1;

public class MainActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
     RequestQueue mQueue;
     ListView lstt ;
    public ArrayList<book> arrayList=new ArrayList<>() ;
     adapter adapt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.rcy);

        mQueue=Volley.newRequestQueue(this);
        jsonparse();














    }
    private void jsonparse(){

        String url="https://www.googleapis.com/books/v1/volumes?q=Sport&amp;printType=books";
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


                                arrayList.add(new book(id,title,authorarray,publisher,publishedDate,averageRating,description,imagelink));




                            }


                            adapt = new adapter(MainActivity.this,arrayList);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            recyclerView.setAdapter(adapt);






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
