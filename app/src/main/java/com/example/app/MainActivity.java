package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_datMonNgay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Order Food");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff00DDED));
        }
        getView();


        btn_datMonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DinnerTable.class);
                startActivity(intent);
            }
        });
    }


    private void getView()
    {
        btn_datMonNgay = findViewById(R.id.btn_datMonNgay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu1){
            Intent intent = new Intent(MainActivity.this, SettingAcivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}