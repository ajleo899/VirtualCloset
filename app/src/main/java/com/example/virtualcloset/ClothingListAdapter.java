package com.example.virtualcloset;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClothingListAdapter extends ArrayAdapter<Closet.ClothingArticle> {
    private Context context;
    private ArrayList<Closet.ClothingArticle> listOfClothes;

    public ClothingListAdapter(Context context, ArrayList<Closet.ClothingArticle> listOfClothes) {
        super(context, R.layout.clothing_item, listOfClothes);
        this.context = context;
        this.listOfClothes = listOfClothes;
    }

    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Closet.ClothingArticle cloth = (Closet.ClothingArticle)object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.clothing_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.clothingName);
        textView.setText(listOfClothes.get(position).getName());
        ImageView imageView = (ImageView) rowView.findViewById(R.id.clothingImage);
        byte[] articleByteArray = listOfClothes.get(position).getImage();
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(articleByteArray, 0, articleByteArray.length));
        return rowView;
    }


}

