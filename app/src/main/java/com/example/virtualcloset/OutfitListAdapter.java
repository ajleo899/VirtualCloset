package com.example.virtualcloset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OutfitListAdapter extends ArrayAdapter<Closet.Outfit> {
    private final Context context;
    private final ArrayList<Closet.Outfit> outfits;

    public OutfitListAdapter(Context context, ArrayList<Closet.Outfit> fits)
    {
        super(context, R.layout.outfit_item, fits);
        this.context = context;
        this.outfits = fits;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Closet.Outfit currentFit = getItem(position);
        final View result;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.outfit_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.outfitName);
        ImageView shirtView = (ImageView) rowView.findViewById(R.id.outfitTop);
        ImageView pantsView = (ImageView) rowView.findViewById(R.id.outfitBottom);
        ImageView shoesView = (ImageView) rowView.findViewById(R.id.outfitShoe);
        textView.setText(outfits.get(position).getName());
        shirtView.setImageBitmap(outfits.get(position).getTop().getImage());
        shirtView.setImageBitmap(outfits.get(position).getBottom().getImage());
        shirtView.setImageBitmap(outfits.get(position).getShoe().getImage());

        return rowView;
    }



}
