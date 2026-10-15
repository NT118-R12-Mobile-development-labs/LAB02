package com.example.case06;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;
    public  DishAdapter(Activity context, int layoutID, List<Dish> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, null, false);

        Dish dish = getItem(position);
        ImageView imgDish = convertView.findViewById(R.id.imgDish);
        TextView tvDish = convertView.findViewById(R.id.tvDish);
        ImageView imgStar = convertView.findViewById(R.id.imgStar);

        imgDish.setImageResource(dish.getThumbnail().getImg());
        tvDish.setText(dish.getName());
        imgStar.setVisibility(dish.isPromotion() ? View.VISIBLE : View.GONE);

        return convertView;
    }

}
