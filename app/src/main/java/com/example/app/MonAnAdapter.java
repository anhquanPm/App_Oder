package com.example.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonAnAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonAn> monAnList;

    public MonAnAdapter(Context context, int layout, List<MonAn> monAnList) {
        this.context = context;
        this.layout = layout;
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
        ImageView imageMon;
        TextView textMoTa, tenMon, textGia, textGiaMonAn;
        Button buttonSua, buttonXoa;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imageMon = convertView.findViewById(R.id.imageMon);
            holder.textMoTa = convertView.findViewById(R.id.textMoTa);
            holder.tenMon = convertView.findViewById(R.id.tenMon);
            holder.textGia = convertView.findViewById(R.id.textGia);
            holder.textGiaMonAn = convertView.findViewById(R.id.textGiaMonAn);
            holder.buttonSua = convertView.findViewById(R.id.buttonSua);
            holder.buttonXoa = convertView.findViewById(R.id.buttonXoa);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MonAn monAn = monAnList.get(position);

        holder.tenMon.setText(monAn.getTen());
        holder.textMoTa.setText(monAn.getMoTa());
        holder.textGiaMonAn.setText(String.valueOf(monAn.getGia()));

        //chuyen byte[] ->bitmap
        byte[] hinhanh = monAn.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);
        holder.imageMon.setImageBitmap(bitmap);

        return convertView;
    }
}
