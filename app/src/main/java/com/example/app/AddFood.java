package com.example.app;

import android.content.Intent;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddFood extends AppCompatActivity {
    Button btnAdd, btnDelete;
    EditText editTen, editMoTa, editTien;
    ImageButton btnCamera, btnLoadFolder;
    ImageView imageHinh;
    private final int REQUEST_CODE_CAMERA = 123;
    private final int REQUEST_CODE_FOLDER = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        this.getViews();

        this.btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });

        this.btnLoadFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen data imageview ->byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageHinh.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] hinhAnh = byteArray.toByteArray();

                ThemSuaXoa.database.INSERT_MOAN(
                        editTen.getText().toString().trim(),
                        editMoTa.getText().toString().trim(),
                        Integer.parseInt(editTien.getText().toString().trim()),
                        hinhAnh
                );
                Toast.makeText(AddFood.this, "Đâ thêm", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddFood.this, ThemSuaXoa.class));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            this.imageHinh.setImageBitmap(bitmap);
        }

        if(requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try{
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageHinh.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void getViews() {
        this.btnAdd = findViewById(R.id.buttonThemSua);
        this.btnDelete = findViewById(R.id.buttonHuySua);
        this.editTen = findViewById(R.id.editTextTenMonSua);
        this.editMoTa = findViewById(R.id.editTextMoTaSua);
        this.editTien = findViewById(R.id.editTextGiaTienSua);
        this.btnCamera = findViewById(R.id.imageCameraSua);
        this.btnLoadFolder = findViewById(R.id.imageLoadFolderSua);
        this.imageHinh = findViewById(R.id.imageMonAnSua);
    }
}
