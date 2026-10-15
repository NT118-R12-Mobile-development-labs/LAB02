package com.example.case06;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Activity context;

    public ThumbnailAdapter(Activity context, int layoutID, List<Thumbnail> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);

        Thumbnail thumbnail = getItem(position);
        TextView tvThumbnail = convertView.findViewById(R.id.tvThumbnail);
        ImageView imgThumbnail = convertView.findViewById(R.id.imgThumbnail);

        tvThumbnail.setText(thumbnail.getName());
        imgThumbnail.setImageResource(thumbnail.getImg());
        imgThumbnail.setVisibility(View.GONE);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);

        Thumbnail thumbnail = getItem(position);
        TextView tvThumbnail = convertView.findViewById(R.id.tvThumbnail);
        ImageView imgThumbnail = convertView.findViewById(R.id.imgThumbnail);

        tvThumbnail.setText(thumbnail.getName());
        imgThumbnail.setImageResource(thumbnail.getImg());
        imgThumbnail.setVisibility(View.VISIBLE);

        return convertView;
    }
}