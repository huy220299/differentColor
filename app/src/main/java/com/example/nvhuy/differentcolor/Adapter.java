package com.example.nvhuy.differentcolor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<item> {
    ArrayList<item> listItem ;
    Context context;
    public Adapter(@NonNull Context context, int resource, @NonNull List<item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listItem = new ArrayList<>(objects);
    }

    @Override
    public int getCount() {
        return listItem.size();
    }
    public void update(ArrayList<item> arr){
        this.listItem.clear();
        this.listItem.addAll(arr);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item,null);
        }
        if(listItem.size()>0){
            item item =listItem.get(position);
            ImgCustom imgCustom = convertView.findViewById(R.id.img);
            imgCustom.setColorFilter(Color.parseColor(item.color));
        }
        return convertView;
    }
}
