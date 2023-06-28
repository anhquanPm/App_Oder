package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class DinnerTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_table);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Chọn bàn ăn");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff00DDED));
        }

        Button button1 = findViewById(R.id.btn_banAn1);
        Button button2 = findViewById(R.id.btn_banAn2);
        Button button3 = findViewById(R.id.btn_banAn3);
        Button button4 = findViewById(R.id.btn_banAn4);
        Button button5 = findViewById(R.id.btn_banAn5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ColorDrawable)(( button1).getBackground())).getColor() == getResources().getColor(R.color.red)){
                    AlertDialog.Builder adb = new AlertDialog.Builder(DinnerTable.this);
                    adb.setTitle("Thông báo");
                    adb.setMessage("Khách đã trả bàn?");
                    adb.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            button1.setBackgroundColor(getResources().getColor(R.color.blue));
                        }
                    });
                    adb.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adb.show();
                }
                else {
                    button1.setBackgroundColor(getResources().getColor(R.color.red));
                    Intent intent = new Intent(DinnerTable.this, FoodList.class);
                    startActivity(intent);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ColorDrawable)(( button2).getBackground())).getColor() == getResources().getColor(R.color.red)){
                    AlertDialog.Builder adb = new AlertDialog.Builder(DinnerTable.this);
                    adb.setTitle("Thông báo");
                    adb.setMessage("Khách đã trả bàn?");
                    adb.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            button2.setBackgroundColor(getResources().getColor(R.color.blue));
                        }
                    });
                    adb.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adb.show();
                }
                else {
                    button2.setBackgroundColor(getResources().getColor(R.color.red));
                    Intent intent = new Intent(DinnerTable.this, FoodList.class);
                    startActivity(intent);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ColorDrawable)(( button3).getBackground())).getColor() == getResources().getColor(R.color.red)){
                    AlertDialog.Builder adb = new AlertDialog.Builder(DinnerTable.this);
                    adb.setTitle("Thông báo");
                    adb.setMessage("Khách đã trả bàn?");
                    adb.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            button3.setBackgroundColor(getResources().getColor(R.color.blue));
                        }
                    });
                    adb.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adb.show();
                }
                else {
                    button3.setBackgroundColor(getResources().getColor(R.color.red));
                    Intent intent = new Intent(DinnerTable.this, FoodList.class);
                    startActivity(intent);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ColorDrawable)(( button4).getBackground())).getColor() == getResources().getColor(R.color.red)){
                    AlertDialog.Builder adb = new AlertDialog.Builder(DinnerTable.this);
                    adb.setTitle("Thông báo");
                    adb.setMessage("Khách đã trả bàn?");
                    adb.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            button4.setBackgroundColor(getResources().getColor(R.color.blue));
                        }
                    });
                    adb.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adb.show();
                }
                else {
                    button4.setBackgroundColor(getResources().getColor(R.color.red));
                    Intent intent = new Intent(DinnerTable.this, FoodList.class);
                    startActivity(intent);
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ColorDrawable)(( button5).getBackground())).getColor() == getResources().getColor(R.color.red)){
                    AlertDialog.Builder adb = new AlertDialog.Builder(DinnerTable.this);
                    adb.setTitle("Thông báo");
                    adb.setMessage("Khách đã trả bàn?");
                    adb.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            button5.setBackgroundColor(getResources().getColor(R.color.blue));
                        }
                    });
                    adb.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    adb.show();
                }
                else {
                    button5.setBackgroundColor(getResources().getColor(R.color.red));
                    Intent intent = new Intent(DinnerTable.this, FoodList.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Xử lý sự kiện khi người dùng nhấn nút mũi tên quay lại trên ActionBar
            // Ví dụ: Đóng Activity, hiển thị thông báo, ...
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}