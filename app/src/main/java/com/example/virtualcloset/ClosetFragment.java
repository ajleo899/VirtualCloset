package com.example.virtualcloset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.*;
import android.widget.ImageView;

public class ClosetFragment extends Fragment {

    private FloatingActionButton goToCloset;
    private FloatingActionButton addClothing;
    private Closet closet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_closet, container, false);

        closet = (Closet) this.getArguments().getSerializable("closet");

        final ImageView shirtView = (ImageView) rootView.findViewById(R.id.shirtTemplate);
        final ImageView pantsView = (ImageView) rootView.findViewById(R.id.pantsTemplate);
        final ImageView shoesView = (ImageView) rootView.findViewById(R.id.shoesTemplate);
        final GestureDetector gesture1 = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {


                    // Minimal x and y axis swipe distance.
                    private int MIN_SWIPE_DISTANCE_X = 100;
                    private int MIN_SWIPE_DISTANCE_Y = 100;

                    // Maximal x and y axis swipe distance.
                    private int MAX_SWIPE_DISTANCE_X = 1000;
                    private int MAX_SWIPE_DISTANCE_Y = 1000;

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

                        // Get swipe delta value in x axis.
                        float deltaX = e1.getX() - e2.getX();

                        // Get swipe delta value in y axis.
                        float deltaY = e1.getY() - e2.getY();

                        // Get absolute value.
                        float deltaXAbs = Math.abs(deltaX);
                        float deltaYAbs = Math.abs(deltaY);

                        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
                        if((deltaXAbs >= MIN_SWIPE_DISTANCE_X) && (deltaXAbs <= MAX_SWIPE_DISTANCE_X))
                        {
                            if(deltaX > 0)
                            {
                                System.out.println("Swipe to Left");
                                shirtView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shirttemplate));
                            }else
                            {
                                System.out.println("Swipe to Right");
                                shirtView.setImageDrawable(getResources().getDrawable(R.drawable.ic_blackshirt));
                            }
                        }

                        if((deltaYAbs >= MIN_SWIPE_DISTANCE_Y) && (deltaYAbs <= MAX_SWIPE_DISTANCE_Y))
                        {
                            if(deltaY > 0)
                            {
                                System.out.println("Swipe to Up");
                            }else
                            {
                                System.out.println("Swipe to Down");
                            }
                        }
                        return true;
                    }


                    @Override
                    public boolean onFling(MotionEvent event1, MotionEvent event2,
                                           float velocityX, float velocityY) {
                        System.out.println("onFling");
                        return true;
                    }
                });

        final GestureDetector gesture2 = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    // Minimal x and y axis swipe distance.
                    private int MIN_SWIPE_DISTANCE_X = 100;
                    private int MIN_SWIPE_DISTANCE_Y = 100;

                    // Maximal x and y axis swipe distance.
                    private int MAX_SWIPE_DISTANCE_X = 1000;
                    private int MAX_SWIPE_DISTANCE_Y = 1000;

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

                        // Get swipe delta value in x axis.
                        float deltaX = e1.getX() - e2.getX();

                        // Get swipe delta value in y axis.
                        float deltaY = e1.getY() - e2.getY();

                        // Get absolute value.
                        float deltaXAbs = Math.abs(deltaX);
                        float deltaYAbs = Math.abs(deltaY);

                        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
                        if((deltaXAbs >= MIN_SWIPE_DISTANCE_X) && (deltaXAbs <= MAX_SWIPE_DISTANCE_X))
                        {
                            if(deltaX > 0)
                            {
                                System.out.println("Swipe to Left");
                                pantsView.setImageDrawable(getResources().getDrawable(R.drawable.ic_pantstemplate));
                            }else
                            {
                                System.out.println("Swipe to Right");
                                pantsView.setImageDrawable(getResources().getDrawable(R.drawable.ic_blackpants));
                            }
                        }

                        if((deltaYAbs >= MIN_SWIPE_DISTANCE_Y) && (deltaYAbs <= MAX_SWIPE_DISTANCE_Y))
                        {
                            if(deltaY > 0)
                            {
                                System.out.println("Swipe to Up");
                            }else
                            {
                                System.out.println("Swipe to Down");
                            }
                        }
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent event1, MotionEvent event2,
                                           float velocityX, float velocityY) {
                        System.out.println("onFling");
                        return true;
                    }
                });

        final GestureDetector gesture3 = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    // Minimal x and y axis swipe distance.
                    private int MIN_SWIPE_DISTANCE_X = 100;
                    private int MIN_SWIPE_DISTANCE_Y = 100;

                    // Maximal x and y axis swipe distance.
                    private int MAX_SWIPE_DISTANCE_X = 1000;
                    private int MAX_SWIPE_DISTANCE_Y = 1000;


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

                        // Get swipe delta value in x axis.
                        float deltaX = e1.getX() - e2.getX();

                        // Get swipe delta value in y axis.
                        float deltaY = e1.getY() - e2.getY();

                        // Get absolute value.
                        float deltaXAbs = Math.abs(deltaX);
                        float deltaYAbs = Math.abs(deltaY);

                        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
                        if((deltaXAbs >= MIN_SWIPE_DISTANCE_X) && (deltaXAbs <= MAX_SWIPE_DISTANCE_X))
                        {
                            if(deltaX > 0)
                            {
                                System.out.println("Swipe to Left");
                            }else
                            {
                                System.out.println("Swipe to Right");
                            }
                        }

                        if((deltaYAbs >= MIN_SWIPE_DISTANCE_Y) && (deltaYAbs <= MAX_SWIPE_DISTANCE_Y))
                        {
                            if(deltaY > 0)
                            {
                                System.out.println("Swipe to Up");
                            }else
                            {
                                System.out.println("Swipe to Down");
                            }
                        }


                        switch((int)Math.round(Math.random())) {
                            case 0:
                                shirtView.setImageDrawable(getResources().getDrawable(R.drawable.ic_blackshirt));
                                pantsView.setImageDrawable(getResources().getDrawable(R.drawable.ic_blackpants));
                                break;
                            case 1:
                                shirtView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shirttemplate));
                                pantsView.setImageDrawable(getResources().getDrawable(R.drawable.ic_pantstemplate));
                                break;
                        }
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
                return gesture1.onTouchEvent(event);
            }
        });

        pantsView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture2.onTouchEvent(event);
            }
        });

        shoesView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture3.onTouchEvent(event);
            }
        });

        goToCloset = (FloatingActionButton) rootView.findViewById(R.id.goToListCloset);
        goToCloset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openListClosetActivity(v);
        }
    });

        addClothing = (FloatingActionButton) rootView.findViewById(R.id.addClothing);
        addClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddClothingActivity(v);
            }
        });

        return rootView;
}

    public void openListClosetActivity(View v) {
        Intent intent = new Intent(v.getContext(), ListClosetActivity.class);
        intent.putExtra("closet", closet);
        startActivity(intent);
    }

    public void openAddClothingActivity(View v) {
        Intent intent2 = new Intent(v.getContext(), AddClothingActivity.class);
        intent2.putExtra("closet", closet);
        startActivity(intent2);
    }


}