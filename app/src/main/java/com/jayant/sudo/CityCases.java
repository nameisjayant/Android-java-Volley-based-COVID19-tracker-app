package com.jayant.sudo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jayant.sudo.Controller.DataAdapter;
import com.jayant.sudo.Modal.Data;
import com.jayant.sudo.Utils.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CityCases extends AppCompatActivity {
private RecyclerView recyclerView;
private List<Data> listdata;
private DataAdapter dataAdapter;
private static final String URL_DATA="https://api.rootnet.in/covid19-in/stats/latest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_cases);
        listdata=new ArrayList<>();
      recyclerView=findViewById(R.id.recyclerview);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setHasFixedSize(true);
        requestData();
    }

    private void requestData() {
        StringRequest request=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("main", "onResponse: "+response);
                    JSONObject getresponse=new JSONObject(response);
                    JSONObject getfirstrow=getresponse.getJSONObject("data");
                    JSONArray getsecondrow=getfirstrow.getJSONArray("regional");
                    for (int i=0;i<getsecondrow.length();i++)
                    {
                        JSONObject data=getsecondrow.getJSONObject(i);
                        Data getData=new Data(data.getString("loc"),data.getInt( "confirmedCasesIndian"),
                                data.getInt("confirmedCasesForeign"),data.getInt("discharged"),data.getInt("deaths"),
                                data.getInt("totalConfirmed"));
                        listdata.add(getData);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                dataAdapter=new DataAdapter(getApplicationContext(),listdata);
                recyclerView.setAdapter(dataAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("main", "onErrorResponse: "+error);
                Toast.makeText(CityCases.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        Singleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
}

