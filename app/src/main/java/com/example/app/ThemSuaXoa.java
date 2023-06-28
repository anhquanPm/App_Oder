package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Currency;

public class ThemSuaXoa extends AppCompatActivity {

    Button buttonAdd, buttonThoat;
    ListView danhSachMon;

    ArrayList<MonAn> arrayMonAn;
    MonAnAdapter adapter;
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_mon);
        this.getViews();

        this.arrayMonAn = new ArrayList<>();
        this.adapter = new MonAnAdapter(this, R.layout.dong_mon_an, arrayMonAn);
        this.danhSachMon.setAdapter(adapter);


        this.database = new Database(this, "QuanLyMonn.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), Gia INTEGER, HinhAnh BLOB)");

        //get data
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

        this.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemSuaXoa.this, AddFood.class);
                startActivity(intent);
            }
        });

        this.buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemSuaXoa.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void getViews() {
        this.buttonAdd = findViewById(R.id.buttonAdd);
        this.buttonThoat = findViewById(R.id.buttonThoat);
        this.danhSachMon = findViewById(R.id.danhsachmon);

    }
}