package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

public class FoodList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Danh sách món ăn");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff00DDED));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Xử lý sự kiện khi người dùng nhấn nút mũi tên quay lại trên ActionBar
            // Ví dụ: Đóng Activity, hiển thị thông báo, ...
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}