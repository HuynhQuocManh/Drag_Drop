package com.huynhquocmanh.drag_drop;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.image1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.image2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.image3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.image4).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.ll1).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll2).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll3).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll4).setOnDragListener(new MyDragListener());
    }

    private final class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == event.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        //Drawable enterShape =
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // Do nothing
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;

                case DragEvent.ACTION_DROP:
                    View view = (View) event.getLocalState();
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    viewGroup.removeView(view);
                    LinearLayout linearLayout = (LinearLayout) v;
                    linearLayout.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
            return true;
        }
    }


}

