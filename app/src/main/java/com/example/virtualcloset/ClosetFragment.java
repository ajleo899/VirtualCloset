package com.example.virtualcloset;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;

public class ClosetFragment extends Fragment {

    private FloatingActionButton goToCloset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_closet, container, false);
        ImageView shirtView = (ImageView) rootView.findViewById(R.id.imageView);
        ImageView pantsView = (ImageView) rootView.findViewById(R.id.imageView2);
        ImageView shoesView = (ImageView) rootView.findViewById(R.id.imageView3);
        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onDown(MotionEvent event) {
                        System.out.println("onDown");
                        return true;
                    }

                    @Override
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        System.out.println("onSingleTap");
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        System.out.println("onLongPress");
                    }

                    @Override
                    public boolean onDoubleTap(MotionEvent e) {
                        System.out.println("onDoubleTap");
                        return true;
                    }

                    @Override
                    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                            float distanceX, float distanceY) {
                        System.out.println("onScroll");
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent event1, MotionEvent event2,
                                           float velocityX, float velocityY) {
                        System.out.println("onFling");
                        return true;
                    }
                });

        shirtView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        pantsView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        shoesView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        goToCloset = (FloatingActionButton) rootView.findViewById(R.id.goToListCloset);
        goToCloset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openListClosetActivity(v);
        }
    });

        return rootView;
}

    public void openListClosetActivity(View v) {
        Intent intent = new Intent(v.getContext(), ListClosetActivity.class);
        startActivity(intent);
    }
}