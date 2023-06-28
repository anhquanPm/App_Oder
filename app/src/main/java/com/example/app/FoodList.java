package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    Button GioHang, ThanhToan;
    public static TextView tongTien;
    ListView danhsachMon;
    ArrayList<MonAn> arrayMonAn;
    MenuAdapter adapter;
    public static Database database;
    public static int tongtien = 0;
    public static String[] order;
    public static String nhaBep;
    public static int[] soLuong = new int[10000];


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        this.getViews();
        for(int i=0;i<10000;i++){
            FoodList.soLuong[i]=0;
        }
        this.arrayMonAn = new ArrayList<>();
        this.adapter = new MenuAdapter(this, R.layout.item_food, arrayMonAn);
        this.danhsachMon.setAdapter(adapter);


        this.database = new Database(this, "QuanLyMonn.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), Gia INTEGER, HinhAnh BLOB)");


        Cursor cursor = database.GetData("SELECT * FROM MonAn");
        order = new String[cursor.getCount()];
        int k =0;
        while (cursor.moveToNext()) {
            arrayMonAn.add(new MonAn(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getBlob(4)
            ));
            order[k] = cursor.getString(1);
            k++;
        }

        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body",cmd());
                intent.setData(Uri.parse("sms:"+ nhaBep));
                startActivity(intent);
            }
        });
    }
    public void getViews() {
        //this.GioHang = findViewById(R.id.GioHang);
        this.ThanhToan = findViewById(R.id.ThanhToan);
        this.tongTien = findViewById(R.id.TongTien);
        this.danhsachMon = findViewById(R.id.listFood);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_thuc_don, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_thuc_don){

        }
        return super.onOptionsItemSelected(item);
    }
    public static void tinhTongTien(int x){
        tongtien+=x;
        tongTien.setText(""+ tongtien);
    }
    public static void soluong(int i,int k){
        soLuong[i]+=k;
    }
    public static String cmd(){
        String cmd = "";
        for(int i=0;i<order.length;i++){
            cmd += "\n"+order[i]+": "+FoodList.soLuong[i];
        }
        return cmd;
    }
}
