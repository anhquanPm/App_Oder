
package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowMore extends AppCompatActivity {
    public static final String FOOD_ID = "id";
    ImageView imageShowMore;
    Button buttonBack;
    TextView nameFoodShowMore, textShowMore;

    public static Database database;

    private ArrayList<MonAn> arrayMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more);

        this.getViews();
        this.arrayMonAn = new ArrayList<>();

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

        int foodId = (Integer)getIntent().getExtras().get(FOOD_ID);
        MonAn monAn = arrayMonAn.get(foodId);


        byte[] hinhanh = monAn.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);

        this.imageShowMore.setImageBitmap(bitmap);
        this.nameFoodShowMore.setText(monAn.getTen());
        this.textShowMore.setText(monAn.getMoTa());

        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowMore.this, FoodList.class);
                startActivity(intent);
            }
        });

    }

    public void getViews() {
        this.imageShowMore = findViewById(R.id.imageShowMore);
        this.buttonBack = findViewById(R.id.buttonBack);
        this.nameFoodShowMore = findViewById(R.id.nameFoodShowMore);
        this.textShowMore = findViewById(R.id.textShowMore);
    }
}