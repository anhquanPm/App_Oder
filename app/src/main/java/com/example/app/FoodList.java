package com.example.app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {
    ListView lvFood;
    ArrayList<Food> lsData = new ArrayList<>();
    FoodAdapter adapter;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_food_list);
        this.lvFood = findViewById(R.id.listFood);

        FoodDB foodDB = new FoodDB(FoodList.this);
        foodDB.initData();
        this.lsData = (ArrayList<Food>) foodDB.getData();

        this.adapter = new FoodAdapter(this, R.layout.item_food, lsData);
        this.lvFood.setAdapter(adapter);
    }
}
