package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingAcivity extends AppCompatActivity {
    
    EditText edt_nhapKey;
    Button btn_dongY, btn_huy;
    
    private final int KEY = 12345;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_acivity);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Cài đặt");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff00DDED));
        }
        
        edt_nhapKey = findViewById(R.id.edt_nhapKey);
        
        btn_dongY = findViewById(R.id.btn_dongY);
        btn_huy = findViewById(R.id.btn_huy);
        
        btn_dongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int key = Integer.parseInt(edt_nhapKey.getText().toString());
                if(key == KEY){
//                    Intent intent = new Intent(SettingAcivity.this, );
                    Toast.makeText(SettingAcivity.this, "Đúng mã", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SettingAcivity.this, "Key không chính xác", Toast.LENGTH_SHORT).show();
                    edt_nhapKey.setText("");
                }
            }
        });

        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}