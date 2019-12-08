package com.example.virtualcloset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {


    private Button favButton;
    private Button shuffleButton;
    private Button weatherButton;
    private Button collectionsButton;
    private Closet closet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        closet = (Closet) this.getArguments().getSerializable("closet");

        collectionsButton = (Button) rootView.findViewById(R.id.collectionsButton);
        collectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCollectionsActivity(v);
            }
        });

        return rootView;
    }

    public void openCollectionsActivity(View v) {
        Intent intent = new Intent(v.getContext(), CollectionsActivity.class);
        intent.putExtra("closet", closet);
        startActivityForResult(intent, 20);

    }
}