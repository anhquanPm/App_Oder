package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;

    public FoodAdapter(Context context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return this.foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
        // ko bt vt j
    }

    private class ViewHolder {
        ImageView imageFood;
        TextView textName, textDonGia, textPrice, textAmount, textThanhTien, textViewTongTien;
        ImageButton buttonAdd, buttonDelete, buttonShowMore;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Food food = (Food) getItem(position);
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();

            holder.imageFood = convertView.findViewById(R.id.imageFood);
            holder.textName = convertView.findViewById(R.id.textFood);
            holder.textDonGia = convertView.findViewById(R.id.textPrice);
            holder.textPrice = convertView.findViewById(R.id.price);
            holder.textAmount = convertView.findViewById(R.id.amount);
            holder.textThanhTien = convertView.findViewById(R.id.ThanhTien);
            holder.textViewTongTien = convertView.findViewById(R.id.textTiien);
            holder.buttonAdd = convertView.findViewById(R.id.buttonAdd);
            holder.buttonDelete = convertView.findViewById(R.id.buttonDelete);
            holder.buttonShowMore = convertView.findViewById(R.id.buttonShowMore);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textName.setText(food.getName());
        holder.textPrice.setText(food.getPrice());
        holder.imageFood.setImageResource(food.getResourceIdPicture());
        return  convertView;
    }
}
