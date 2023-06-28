package com.example.app;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    Button GioHang, ThanhToan;
    TextView tongTien;
    ListView danhsachMon;
    ArrayList<MonAn> arrayMonAn;
    MenuAdapter adapter;
    public static Database database;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        this.getViews();

        this.arrayMonAn = new ArrayList<>();
        this.adapter = new MenuAdapter(this, R.layout.item_food, arrayMonAn);
        this.danhsachMon.setAdapter(adapter);



        this.database = new Database(this, "QuanLyMon.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), Gia INTEGER, HinhAnh BLOB)");


        Cursor cursor = database.GetData("SELECT * FROM MonAn");
        while (cursor.moveToNext()) {
            arrayMonAn.add(new MonAn(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getBlob(4)
            ));
        }
        adapter.notifyDataSetChanged();

    }

    public void getViews() {
        this.GioHang = findViewById(R.id.GioHang);
        this.ThanhToan = findViewById(R.id.ThanhToan);
        this.tongTien = findViewById(R.id.TongTien);
        this.danhsachMon = findViewById(R.id.listFood);
    }
}
