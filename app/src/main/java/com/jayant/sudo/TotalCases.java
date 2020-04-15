package com.jayant.sudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jayant.sudo.Utils.Singleton;

import org.json.JSONException;
import org.json.JSONObject;


public class TotalCases extends AppCompatActivity {
private TextView total,confirm_cases_india,confirm_cases_foreign,discharge,deaths,confim_but_no_location;
private static final String URL_DATA="https://api.rootnet.in/covid19-in/stats/latest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_cases);

        total=findViewById(R.id.total);
        confirm_cases_india=findViewById(R.id.confirm_cases_india);
        confirm_cases_foreign=findViewById(R.id.confirm_cases_foreign);
        discharge=findViewById(R.id.dischage);
        deaths=findViewById(R.id.deaths);
        confim_but_no_location=findViewById(R.id.confirm_but_no_location);

        requestData();

    }

    private void requestData() {
        StringRequest request=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    Log.d("main", "onResponse: "+response);
                    JSONObject jsonObject1=jsonObject.getJSONObject("data");
                    JSONObject jsonObject2=jsonObject1.getJSONObject("summary");
                    total.setText("Total: "+jsonObject2.getInt("total"));
                    confirm_cases_india.setText("Confirm cases indian: "+jsonObject2.getInt("confirmedCasesIndian"));
                    confirm_cases_foreign.setText("Confirm cases foreign: "+jsonObject2.getInt("confirmedCasesForeign"));
                    discharge.setText("Discharged: "+jsonObject2.getInt("discharged"));
                    deaths.setText("Deaths: "+jsonObject2.getInt("deaths"));
                    confim_but_no_location.setText("Confirm but location undefine: "+jsonObject2.getInt("confirmedButLocationUnidentified"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
     Singleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }
}
