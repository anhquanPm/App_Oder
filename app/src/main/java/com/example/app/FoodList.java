package com.example.app;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodList extends AppCompatActivity {
    ListView lvFood;
    List<Food> lsData = new ArrayList<Food>();
    FoodAdapter adapter;

    TextView tongTien;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_food_list);
        this.lvFood = findViewById(R.id.listFood);
        this.tongTien = findViewById(R.id.TongTien);

        FoodDB foodDB = new FoodDB(FoodList.this);
        foodDB.initData();
        this.lsData = foodDB.getDataAll();

        this.adapter = new FoodAdapter(FoodList.this, R.layout.item_food, lsData);
        this.lvFood.setAdapter(adapter);




    }
}
