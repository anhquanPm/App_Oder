package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu1) {
            // Xử lý sự kiện khi người dùng nhấn nút mũi tên quay lại trên ActionBar
            // Ví dụ: Đóng Activity, hiển thị thông báo, ...
            Intent intent = new Intent(MainActivity.this, FoodList.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}