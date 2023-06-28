package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Sua_food extends AppCompatActivity {
    public static final String ID_FOOD = "id";
    public static Database database;
    private ArrayList<MonAn> monAnArrayList;
    private final int REQUEST_CODE_CAMERA = 123;
    private final int REQUEST_CODE_FOLDER = 100;

    EditText editTextMoTaSua, editTextGiaTienSua, editTextTenMonSua;
    ImageView imageMonAnSua;
    ImageButton imageLoadFolderSua, imageCameraSua;
    Button buttonHuySua, buttonThemSua;


    //@Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sua_food);
//
//        this.database = new Database(this, "QuanLyMonn.sqlite", null, 1);
//
//        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), Gia INTEGER, HinhAnh BLOB)");
//
//        this.monAnArrayList = new ArrayList<>();
//        //get data
//        Cursor cursor = database.GetData("SELECT * FROM MonAn");
//        while (cursor.moveToNext()) {
//            monAnArrayList.add(new MonAn(
//                    cursor.getInt(0),
//                    cursor.getString(1),
//                    cursor.getString(2),
//                    cursor.getInt(3),
//                    cursor.getBlob(4)
//            ));
//        }
//        this.getViews();
//        int foodId = (Integer)getIntent().getExtras().get(ID_FOOD);
//
//        this.editTextTenMonSua.setText(monAnArrayList.get(foodId).getTen());
//        this.editTextGiaTienSua.setText(String.valueOf(monAnArrayList.get(foodId).getGia()));
//        this.editTextMoTaSua.setText(monAnArrayList.get(foodId).getMoTa());
//        byte[] hinhanh = monAnArrayList.get(foodId).getHinh();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);
//        this.imageMonAnSua.setImageBitmap(bitmap);
//
//        this.imageCameraSua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_CODE_CAMERA);
//            }
//        });
//
//        this.imageLoadFolderSua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, REQUEST_CODE_FOLDER);
//            }
//        });
//
//        this.buttonThemSua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageMonAnSua.getDrawable();
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
//
//                byte[] hinhAnh = byteArray.toByteArray();
//                String tenMoi = editTextTenMonSua.getText().toString().trim();
//                int TienMoi = Integer.parseInt(editTextGiaTienSua.getText().toString());
//                String MoTaMoi = editTextMoTaSua.getText().toString().trim();
//
//                database.QueryData("UPDATE MonAn SET Ten = '" + tenMoi +"', MoTa ='"+ MoTaMoi +"', gia = '"+ TienMoi +"', HinhAnh='"+hinhAnh+"' WHERE Id = '"+foodId+"' ");
//                Toast.makeText(Sua_food.this, "Đã cập nhập", Toast.LENGTH_SHORT).show();
//                //Intent intent = new Intent(Sua_food.this, ThemSuaXoa.class);
//                //startActivity(intent);
//
//            }
//        });
//
//        this.buttonHuySua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Sua_food.this, ThemSuaXoa.class);
//                startActivity(intent);
//            }
//        });
//    }

    public void getViews() {
        this.editTextMoTaSua = findViewById(R.id.editTextMoTaSua);
        this.editTextGiaTienSua = findViewById(R.id.editTextGiaTienSua);
        this.editTextTenMonSua = findViewById(R.id.editTextTenMonSua);
        this.imageMonAnSua = findViewById(R.id.imageMonAnSua);
        this.imageLoadFolderSua = findViewById(R.id.imageLoadFolderSua);
        this.imageCameraSua = findViewById(R.id.imageCameraSua);
        this.buttonHuySua = findViewById(R.id.buttonHuySua);
        this.buttonThemSua = findViewById(R.id.buttonThemSua);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            this.imageMonAnSua.setImageBitmap(bitmap);
        }

        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try{
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageMonAnSua.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}