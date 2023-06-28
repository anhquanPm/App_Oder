package com.example.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter{
    private int layout;
    private Context context;
    private List<MonAn> monAnList;

    public MenuAdapter(Context context, int layout, List<MonAn> monAnList) {
        this.layout = layout;
        this.context = context;
        this.monAnList = monAnList;
    }

    @Override
    public int getCount() {
        return this.monAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imageFood;
        TextView textFood, textPrice, price, amount, ThanhTien, textTiien;
        ImageButton buttonAdd, buttonDelete;
        Button buttonShowMore;
        int SL = 0;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imageFood = convertView.findViewById(R.id.imageFood);
            holder.textFood = convertView.findViewById(R.id.textFood);
            holder.textPrice = convertView.findViewById(R.id.textPrice);
            holder.price = convertView.findViewById(R.id.price);
            holder.amount = convertView.findViewById(R.id.amount);
            holder.ThanhTien = convertView.findViewById(R.id.ThanhTien);
            holder.textTiien = convertView.findViewById(R.id.textTiien);
            holder.buttonAdd = convertView.findViewById(R.id.buttonAdd);
            holder.buttonDelete = convertView.findViewById(R.id.buttonDelete);
            holder.buttonShowMore = convertView.findViewById(R.id.buttonShowMore);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MonAn monAn = this.monAnList.get(position);

        holder.textFood.setText(monAn.getTen());
        holder.price.setText(String.valueOf(monAn.getGia()));

        byte[] hinhanh = monAn.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);
        holder.imageFood.setImageBitmap(bitmap);

        holder.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.SL++;
                holder.amount.setText(String.valueOf(holder.SL));
                holder.textTiien.setText(String.valueOf(holder.SL * monAn.getGia()));
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.SL > 0) {
                    holder.SL--;
                    holder.amount.setText(String.valueOf(holder.SL));
                    holder.textTiien.setText(String.valueOf(holder.SL * monAn.getGia()));
                }
            }
        });

        return convertView;
    }
}
