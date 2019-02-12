package com.example.taher.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private TextView  mText;
    private RequestQueue mQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText=(TextView) findViewById(R.id.text_view);
        Button  buttonparse =(Button)findViewById(R.id.button_parse) ;

        mQueue=Volley.newRequestQueue(this);
        buttonparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonparse();

            }
        });



    }
    private void jsonparse(){

        String url="https://www.googleapis.com/books/v1/volumes?q=Sport&amp;printType=books";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            JSONArray jsonArray = response.getJSONArray("items");

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject employee=jsonArray.getJSONObject(i);
                                JSONObject x = employee.getJSONObject("volumeInfo");
                                JSONArray jsonArray2 = x.getJSONArray("authors");
                                for(int i2=0;i2<jsonArray2.length();i2++){
                                    String  value=jsonArray2.getString(i2);


                                   // Log.e("json",i2+"="+jsonArray2);
                                    mText.append(value+"\n\n");

                                }









                            }




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
