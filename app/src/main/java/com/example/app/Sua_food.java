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
    private final int REQUEST_CODE_CAMERA = 123;
    private final int REQUEST_CODE_FOLDER = 100;

    EditText editTextMoTaSua, editTextGiaTienSua, editTextTenMonSua;
    ImageView imageMonAnSua;
    ImageButton imageLoadFolderSua, imageCameraSua;
    Button buttonHuySua, buttonThemSua;



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