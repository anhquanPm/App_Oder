package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_datMonNgay;

    SharedPreferences sharedPreferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Order Food");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff00DDED));
        }

        getView();
        FoodList.nhaBep = sharedPreferences.getString("sdt","");


        btn_datMonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DinnerTable.class);
                startActivity(intent);
            }
        });
    }


    private void getView()
    {
        sharedPreferences = getSharedPreferences("sdt",MODE_PRIVATE);
        btn_datMonNgay = findViewById(R.id.btn_datMonNgay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu1){
            Intent intent = new Intent(MainActivity.this, SettingAcivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.sdt){
            DialogNhaBep();
        }
        return super.onOptionsItemSelected(item);
    }
    private void DialogNhaBep(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.nha_bep);
        EditText edtNumber = (EditText) dialog.findViewById(R.id.editTextNumberSdt);
        Button btnxn = (Button) dialog.findViewById(R.id.button);
        edtNumber.setText(edtNumber.getText());
        //Button bnXacNhan = (Button) dialog.findViewById(R.id.buttonXacNhan1);
        btnxn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodList.nhaBep = edtNumber.getText().toString();
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putString("sdt",edtNumber.getText().toString());
                ed.commit();
                dialog.dismiss();
            }
        });
        dialog.show();
    }


}