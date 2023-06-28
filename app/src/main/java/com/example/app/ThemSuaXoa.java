package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
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

    private void getData(){
        //get data
        Cursor cursor = database.GetData("SELECT * FROM MonAn");
        arrayMonAn.clear();
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

    public void DialogXoaCV(String ten, int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa món ăn "+ten+" không ?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM MonAn WHERE Id ='"+id+"'");
                Toast.makeText(ThemSuaXoa.this, "Đã Xóa "+ten, Toast.LENGTH_SHORT).show();
                getData();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

    public void DialogCapNhatCongViec(String ten, String moTa, int giaTien, int id){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_sua_food);

          EditText editTextTenMonSua = dialog.findViewById(R.id.editTextTenMonSua);
          EditText editTextGiaTienSua = dialog.findViewById(R.id.editTextGiaTienSua);
          EditText editTextMoTaSua = dialog.findViewById(R.id.editTextMoTaSua);

        Button buttonThemSua = dialog.findViewById(R.id.buttonThemSua);
        Button buttonHuySua = dialog.findViewById(R.id.buttonHuySua);


        editTextTenMonSua.setText(ten);
        editTextMoTaSua.setText(moTa);
        editTextGiaTienSua.setText(giaTien+"");

        buttonThemSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = editTextTenMonSua.getText().toString().trim();
                String giaMoi = editTextGiaTienSua.getText().toString().trim();
                String moTaMoi = editTextMoTaSua.getText().toString().trim();
                database.QueryData("UPDATE MonAn SET Ten = '"+tenMoi+"', MoTa = '"+moTaMoi+"', Gia = '"+giaMoi+"' WHERE Id ='"+id+"'");
                Toast.makeText(ThemSuaXoa.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getData();
            }
        });

        buttonHuySua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        buttonThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemSuaXoa.this, MainActivity.class);
                startActivity(intent);
            }
        });

        dialog.show();
    }
}