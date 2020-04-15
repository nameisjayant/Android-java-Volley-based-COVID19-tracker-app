package com.jayant.sudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private CardView total_cases,city_cases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total_cases=findViewById(R.id.total_cases);
        city_cases=findViewById(R.id.city_cases);

        total_cases.setOnClickListener(this);
        city_cases.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      switch(view.getId())
      {
          case R.id.total_cases:
                  startActivity(new Intent(MainActivity.this,TotalCases.class));
                  break;
          case R.id.city_cases:
              startActivity(new Intent(MainActivity.this,CityCases.class));
                   break;
      }
    }
}
